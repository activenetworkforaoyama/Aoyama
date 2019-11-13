package co.jp.aoyama.macchinetta.app.fabric;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.message.MessageKeys;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Fabric;
import co.jp.aoyama.macchinetta.domain.service.fabric.FabricService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

/**
 * 生地情報
 * @author wuzhengyang
 *
 */
@Controller
@RequestMapping(value = "/fabric")
public class FabricController {
	
	//1：CSVファイルの項目数が不正です。行数＝「エラー発生の第一番目の行数」
	private static final String NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT = "1";
	//2.1：生地品番は既に生地マスタに存在するため登録できません。オーダーパターン＝{0}，生地品番＝{1}，処理区分＝{2}，行数＝{3}
	//2.2：生地マスタに存在しない生地品番のため更新できません。オーダーパターン＝{0}，生地品番＝{1}，処理区分＝{2}，行数＝{3}
	private static final String PROCESSING_SEPARATION_IS_INCORRECT = "2";
	//3：生地ブランドマスタに存在しない生地ブランド管理番号です。オーダーパターン＝{0}，生地品番＝{1}，生地ブランド管理番号＝{2}，行数＝{3}
	private static final String MANAGEMENT_NUMBER_DOES_NOT_EXIST = "3";
	//4：「一個目のエラーの行数」行目の「エラー発生の項目名」は必須です
	private static final String PROJECT_NAME_IS_EMPTY = "4";
	//5：「エラー発生の第一番目の行数」行目の「エラー発生の項目名」の値が不正です。
	private static final String VALUE_IS_INCORRECT = "5";
	//6：「エラー発生の第一番目の行数」の「エラー発生の項目名」の桁数が不正です。
	private static final String NUMBER_OF_BITS_IS_INCORRECT = "6";
	//7：オーダーパターンはログインする業態と不一致のため登録できません。オーダーパターン＝{0}，行数＝{1}
	private static final String THE_STATUS_OF_ORDER_PATTERN_IS_INCORRECT = "7";
	//8：選択されたファイルに重複データが存在しているため、更新できませんでした。オーダーパターン＝{0}，生地品番＝{1}，行数＝{2}、{3}
	private static final String DUPLICATE_PRIMARY_KEY_IN_FILE = "8";
	//10：全角
	private static final String FULL_ANGLE = "10";
	//99：要求にかない
	private static final String MEET_THE_REQUIREMENT = "99";
	
	@Inject
    SessionContent sessionContent;
	
	@Inject
	FabricService fabricService;
	
	@Inject
	OrderListService orderListService;
	
	@Inject
	ServletContext servletContext;
	
	private static final Logger logger = LoggerFactory
            .getLogger(FabricController.class);

	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping(value = "init")
	public String fabricDataupload(Model model) {
		String category = sessionContent.getCategory();
		model.addAttribute("category", category);
		return "fabric/fabricForm";
	}
	
	/**
	 * ダウンロードの方法
	 * @param request
	 * @param response
	 * @return　文字列パス
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/fabricDownload" , method = RequestMethod.GET)
	public ResponseEntity fabricDownload(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		//order_pttern状況を取得する
		String category = request.getParameter("category");
		//データベースから生地の情報を読み取る
		List<Fabric> fabricList = fabricService.fabricQueryByCoOrPo(category);
		//バイト配列出力ストリーム
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		//取得時間
		Date dateNow = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateToday = dateFormat.format(dateNow); 
		
		//表示項目名を定義する
		String[] title = {"処理区分","オーダーパターン","生地品番","素材品番","生地ブランド管理番号",
				"業態","年季","色","柄","色(青山表記)",
				"柄(青山表記)","素材ネーム","アイテム区分","コート可否","組成表示",
				"工場コード","メーカーコード","LCR縫製可否","上代","PANTS追加増額率",
				"シングルGILET追加増額率","ダブルGILET追加増額率","ダブルJACKET増額率","シングルJACKET単品率","ダブルJACKET単品率",
				"PANTS単品率","シングルGILET単品率","ダブルGILET単品率","シングルコート単品率","ダブルコート単品率",
				"シングルJacketの単品購買追加金額","ダブルJacketの単品購買追加金額","シングルGiletの単品購買追加金額","ダブルGiletの単品購買追加金額",
				"Pantsの単品購買追加金額","シングルCoatの単品購買追加金額","ダブルCoatの単品購買追加金額",
				"生地代","ウォッシャブル可否","タキシード可否","下代調整金","契約No",
				"手帳(貿易)期限","生地インポーター","フル毛芯仕様可否","シャツ仕様可否","店着納期区分（通常）",
				"店着納期区分（早割）","店着納期区分（コート専用）","取扱注意","生地ネーム有無","理論在庫",
				"実在庫"};
		
		String[][] content = new String[fabricList.size()][title.length];
		for (int i = 0; i < fabricList.size(); i++) {
			//読み出した情報を文字列配列に変換する
			Fabric fabric = new Fabric();	
			fabric = fabricList.get(i);
			//処理区分,オーダーパターン,生地品番,素材品番,生地ブランド管理番号
			content[i][0] = "";
			content[i][1] = setUpEmptyString(String.valueOf(fabric.getOrderPattern()));
			content[i][2] = setUpEmptyString(String.valueOf(fabric.getFabricNo()));
			content[i][3] = setUpEmptyString(String.valueOf(fabric.getMaterialNo()));
			content[i][4] = setUpEmptyString(String.valueOf(fabric.getFablicBrandNo()));
			
			//業態,年季,色,柄,色(青山表記)
			content[i][5] = setUpEmptyString(String.valueOf(fabric.getStoreBrand()));
			content[i][6] = setUpEmptyString(String.valueOf(fabric.getSeason()));
			content[i][7] = setUpEmptyString(String.valueOf(fabric.getColor()));
			content[i][8] = setUpEmptyString(String.valueOf(fabric.getPattern()));
			content[i][9] = setUpEmptyString(String.valueOf(fabric.getColorAoyama()));
            
            //柄(青山表記),素材ネーム,アイテム区分,コート可否,組成表示
			content[i][10] = setUpEmptyString(String.valueOf(fabric.getPatternAoyama()));
			content[i][11] = setUpEmptyString(String.valueOf(fabric.getMaterialName()));
			content[i][12] = setUpEmptyString(String.valueOf(fabric.getItemClass()));
			content[i][13] = setUpEmptyString(String.valueOf(fabric.getCoatAvailable()));
			content[i][14] = setUpEmptyString(String.valueOf(fabric.getCompositionLabel()));
            
            //工場コード,メーカーコード,LCR縫製可否,上代,PANTS追加増額率
			content[i][15] = setUpEmptyString(String.valueOf(fabric.getFactoryCode()));
			content[i][16] = setUpEmptyString(String.valueOf(fabric.getMakerCode()));
			content[i][17] = setUpEmptyString(String.valueOf(fabric.getLcrSewingAvailable()));
			content[i][18] = setUpEmptyString(String.valueOf(fabric.getRetailPrice()));
			content[i][19] = setUpEmptyString(String.valueOf(fabric.getAdditionalPantsRate()));
        	
        	//シングルGILET追加増額率,ダブルGILET追加増額率,ダブルJACKET増額率,シングルJACKET単品率,ダブルJACKET単品率
			content[i][20] = setUpEmptyString(String.valueOf(fabric.getAdditionalSingleGiletRate()));
			content[i][21] = setUpEmptyString(String.valueOf(fabric.getAdditionalDoubleGiletRate()));
			content[i][22] = setUpEmptyString(String.valueOf(fabric.getAdditionalDoubleJacketRate()));
			content[i][23] = setUpEmptyString(String.valueOf(fabric.getSingleJacketOnlyRate()));
			content[i][24] = setUpEmptyString(String.valueOf(fabric.getDoubleJacketOnlyRate()));
        	
        	//PANTS単品率,シングルGILET単品率,ダブルGILET単品率,シングルコート単品率、ダブルコート単品率
			content[i][25] = setUpEmptyString(String.valueOf(fabric.getPantOnlyRate()));
			content[i][26] = setUpEmptyString(String.valueOf(fabric.getSingleGiletOnlyRate()));
			content[i][27] = setUpEmptyString(String.valueOf(fabric.getDoubleGiletOnlyRate()));
			content[i][28] = setUpEmptyString(String.valueOf(fabric.getCoatSingleOnlyRate()));
			content[i][29] = setUpEmptyString(String.valueOf(fabric.getCoatDoubleOnlyRate()));
        	
			//シングルJacketの単品購買追加金額、ダブルJacketの単品購買追加金額、シングルGiletの単品購買追加金額、ダブルGiletの単品購買追加金額
			//Pantsの単品購買追加金額、シングルCoatの単品購買追加金額、ダブルCoatの単品購買追加金額
			content[i][30] = setUpEmptyString(String.valueOf(fabric.getJkSingleOnlyPlusAlphaPrice()));
			content[i][31] = setUpEmptyString(String.valueOf(fabric.getJkDoubleOnlyPlusAlphaPrice()));
			content[i][32] = setUpEmptyString(String.valueOf(fabric.getGlSingleOnlyPlusAlphaPrice()));
			content[i][33] = setUpEmptyString(String.valueOf(fabric.getGlDoubleOnlyPlusAlphaPrice()));
			content[i][34] = setUpEmptyString(String.valueOf(fabric.getPtOnlyPlusAlphaPrice()));
			content[i][35] = setUpEmptyString(String.valueOf(fabric.getCtSingleOnlyPlusAlphaPrice()));
			content[i][36] = setUpEmptyString(String.valueOf(fabric.getCtDoubleOnlyPlusAlphaPrice()));
			
        	//生地代,ウォッシャブル可否,タキシード可否,下代調整金,契約No
			content[i][37] = setUpEmptyString(String.valueOf(fabric.getFabricPrice()));
			content[i][38] = setUpEmptyString(String.valueOf(fabric.getWashableAvailable()));
			content[i][39] = setUpEmptyString(String.valueOf(fabric.getTuxedoAvailable()));
			content[i][40] = setUpEmptyString(String.valueOf(fabric.getWsPriceAdjust()));
			content[i][41] = setUpEmptyString(String.valueOf(fabric.getContractNo()));
        	
        	//手帳(貿易)期限,生地インポーター,フル毛芯仕様可否,シャツ仕様可否,店着納期区分（通常）
			content[i][42] = setUpEmptyString(String.valueOf(fabric.getSpinningLimitDate()));
			if(!("".equals(content[i][42]))) {
				SimpleDateFormat spinningLimitDateSDF = new SimpleDateFormat("yyyyMMdd");
		        content[i][42] = spinningLimitDateSDF.format(fabric.getSpinningLimitDate());
			}
			content[i][43] = setUpEmptyString(String.valueOf(fabric.getFablicImporter()));
			content[i][44] = setUpEmptyString(String.valueOf(fabric.getFullHairclothAvailable()));
			content[i][45] = setUpEmptyString(String.valueOf(fabric.getShirtSleeveAvailable()));
			content[i][46] = setUpEmptyString(String.valueOf(fabric.getStoreDelvNormal()));
            
			//店着納期区分（早割）,店着納期区分（コート専用）,取扱注意,生地ネーム有無,理論在庫
			content[i][47] = setUpEmptyString(String.valueOf(fabric.getStoreDelvEarly()));
			content[i][48] = setUpEmptyString(String.valueOf(fabric.getStoreDelvCoat()));
			content[i][49] = setUpEmptyString(String.valueOf(fabric.getHandlingCaution()));
			content[i][50] = setUpEmptyString(String.valueOf(fabric.getFabricNameExist()));
			content[i][51] = setUpEmptyString(String.valueOf(fabric.getTheoreticalStock()));
			
			//実在庫
			content[i][52] = setUpEmptyString(String.valueOf(fabric.getActualStock()));
		}
		
		//タイトルと内容をバイト出力ストリーム書き込みます
		writeByteArrayOutputStream(output, title, content);
		
		String fileNameDefault = "生地情報ダウンロード_"+dateToday+".csv";
		try {
			response.addHeader("Content-Type", "application/force-download");
			//デフォルトのダウンロードファイル名を設定する
			response.addHeader("Content-Disposition", "attachment; filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
			
			//ByteArrayをbyte配列に変換
			byte[] byteArray = output.toByteArray();
			//byte配列をStringに変換
			String strFromByteArray = new String(byteArray);
			//出力ストリームのエンコード形式を設定します
			response.getOutputStream().write(strFromByteArray.getBytes("Shift_JIS"));
			
			response.setStatus(200);
			logger.info("Download is OK");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
        return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * アップロードの方法
	 * @param file　ユーザーがアップロードのファイル
	 * @param model　容器
	 * @return 文字列パス
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "fabricUpload" , method = RequestMethod.POST)
	public String fabricUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Model model) throws IllegalStateException, IOException {
		//order_pttern状況を取得する
		String category = request.getParameter("category");
		//strArr：エラー発生の第一番目の情報
		//strArr「０」：エラー発生の第一番目の行数。 strArr「１」：エラー発生の項目名。 strArr「２」：エラー発生のタイプ。
		String[] strArr = new String[3];
		//ファイル解析後のオブジェクトは、このリストに格納する
		List<Fabric> fabricList;
		//エラーがあった場合は、初めてエラーが発生した行のオブジェクトを格納する
		Fabric fabricError = new Fabric();
		//新規、修正、削除本数の保存
		String[] fabricUpdate = {"0","0","0"};
		try {
			//ファイル解析をリスト化する
			fabricList = convertStreamToString(file.getInputStream(), category);
			//ループ、エラー発生の第一番目の行数を探す
			for (Fabric fabricFor : fabricList) {
				if(fabricFor.getErrorArr() != null) {
					//strArr「０」：エラー発生の第一番目の行数。 strArr「１」：エラー発生の項目名。 strArr「２」：エラー発生のタイプ。
					strArr[0] = fabricFor.getErrorArr()[0];
					strArr[1] = fabricFor.getErrorArr()[1];
					strArr[2] = fabricFor.getErrorArr()[2];
					fabricError = fabricFor;
					break;
				}
			}

			if(strArr[0] != null) {
				//エラーがあつた場合
				//エラーメッセージがフロントに提示される
				ResultMessages messagesError = ResultMessages.error();
				if(NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT.equals(strArr[2])) {
					//1：CSVファイルの項目数が不正です。行数＝「エラー発生の第一番目の行数」
					messagesError.add(MessageKeys.E005, strArr[0]); 
					logger.error(messagesError.toString());
				}else if(PROCESSING_SEPARATION_IS_INCORRECT.equals(strArr[2])) {
					//変換された一時のオブジェクトを処理区分します
					String temporaryHandleDiscriminate = null;
					//エラーの場合の仮処理区分を正常な処理区分に変換します
					if("X".equals(fabricError.getHandleDiscriminate())) {
						temporaryHandleDiscriminate = "I";
						//2.1：生地品番は既に生地マスタに存在するため登録できません。オーダーパターン＝{0}，生地品番＝{1}，処理区分＝{2}，行数＝{3}
						messagesError.add(MessageKeys.E022, fabricError.getOrderPattern(), fabricError.getFabricNo(), 
								temporaryHandleDiscriminate, strArr[0]); 
						logger.error(messagesError.toString());
					}else if("Y".equals(fabricError.getHandleDiscriminate())) {
						temporaryHandleDiscriminate = "U";
						//2.2：生地マスタに存在しない生地品番のため更新できません。オーダーパターン＝{0}，生地品番＝{1}，処理区分＝{2}，行数＝{3}
						messagesError.add(MessageKeys.E006, fabricError.getOrderPattern(), fabricError.getFabricNo(), 
								temporaryHandleDiscriminate, strArr[0]); 
						logger.error(messagesError.toString());
					}else if("Z".equals(fabricError.getHandleDiscriminate())) {
						temporaryHandleDiscriminate = "D";
						//2.2：生地マスタに存在しない生地品番のため更新できません。オーダーパターン＝{0}，生地品番＝{1}，処理区分＝{2}，行数＝{3}
						messagesError.add(MessageKeys.E006, fabricError.getOrderPattern(), fabricError.getFabricNo(), 
								temporaryHandleDiscriminate, strArr[0]); 
						logger.error(messagesError.toString());
					}
				}else if(MANAGEMENT_NUMBER_DOES_NOT_EXIST.equals(strArr[2])) {
					//3：生地ブランドマスタに存在しない生地ブランド管理番号です。オーダーパターン＝{0}，生地品番＝{1}，生地ブランド管理番号＝{2}，行数＝{3}
					messagesError.add(MessageKeys.E007, fabricError.getOrderPattern(), fabricError.getFabricNo(), 
							fabricError.getFablicBrandNo(), strArr[0]); 
					logger.error(messagesError.toString());
				}else if(PROJECT_NAME_IS_EMPTY.equals(strArr[2])) {
					//4：「一個目のエラーの行数」行目の「エラー発生の項目名」は入力必須です。
					messagesError.add(MessageKeys.E008, strArr[0], strArr[1]); 
					logger.error(messagesError.toString());
				}else if(VALUE_IS_INCORRECT.equals(strArr[2])) {
					//5：「エラー発生の第一番目の行数」行目の「エラー発生の項目名」の値に誤りがあります。
					messagesError.add(MessageKeys.E010, strArr[0], strArr[1]); 
					logger.error(messagesError.toString());
				}else if(NUMBER_OF_BITS_IS_INCORRECT.equals(strArr[2])) {
					//6：「エラー発生の第一番目の行数」行目の「エラー発生の項目名」の桁数が異なります。
					messagesError.add(MessageKeys.E011, strArr[0], strArr[1]); 
					logger.error(messagesError.toString());
				}else if(THE_STATUS_OF_ORDER_PATTERN_IS_INCORRECT.equals(strArr[2])) {
					//7：オーダーパターンはログインする業態と不一致のため登録できません。オーダーパターン＝{0}，行数＝{1}
					messagesError.add(MessageKeys.E027, fabricError.getOrderPattern(), strArr[0]); 
					logger.error(messagesError.toString());
				}else if(DUPLICATE_PRIMARY_KEY_IN_FILE.equals(strArr[2])) {
					//8：選択されたファイルに重複データが存在しているため、更新できませんでした。オーダーパターン＝{0}，生地品番＝{1}，行数＝{2}、{3}
					//このエラーが発生した場合、strArr[0]は２回目に繰り返される行数、strArr[1]は最初の反復の行数です
					messagesError.add(MessageKeys.E028, fabricError.getOrderPattern(), fabricError.getFabricNo(),
							strArr[1], strArr[0]); 
					logger.error(messagesError.toString());
				}
				//フロントでエラーメッセージを提示する
				model.addAttribute("resultMessages", messagesError);
				// ログを出力
		    	logger.error(messagesError.toString());
			}else {
				//単一行データのエラーメッセージがないの場合
				//更新操作を行う
				fabricUpdate = fabricService.fabricUpdate(fabricList);
				
				//更新成功のメッセージボックスは設ける
				ResultMessages messagesSuccess = ResultMessages.success();
				//fabricUpdate「０」：登録件数；　fabricUpdate「１」：更新件数；　fabricUpdate「２」：削除件数
				messagesSuccess.add(MessageKeys.I002, fabricUpdate[0], fabricUpdate[1], fabricUpdate[2]); 
				model.addAttribute("resultMessages", messagesSuccess);
				logger.info(messagesSuccess.toString());
			}
			
		} catch (MultipartException | IOException e) {
			e.printStackTrace();
			//エラーメッセージがフロントに提示される
			ResultMessages messagesError = ResultMessages.error();
			//6：「エラー発生の第一番目の行数」の「エラー発生の項目名」の桁数が不正です。
			messagesError.add(MessageKeys.E004); 
			// ログを出力
	    	logger.error(messagesError.toString());
		}
		
		model.addAttribute("category", category);
		return "fabric/fabricForm";
	}
	
	/**
	 * アップロードファイルの解析
	 * @param inputStream
	 * @return　解析後のコレクション
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Fabric> convertStreamToString(InputStream inputStream, String category) throws UnsupportedEncodingException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"Shift_JIS"));
	    StringBuilder sb = new StringBuilder();
	    ArrayList<Fabric> fabricList = new ArrayList<Fabric>();
	    ArrayList<String> list = new ArrayList<String>();
	    String line = null;
	    
	    Map primaryKeyMap = new HashMap();
	    
	    try {
	        while ((line = reader.readLine()) != null) {
	        	sb.append(line);
	        	list.add(sb.toString());
	        	sb.setLength(0);
	        }
	        
	        if(list.size() != 0) {
	        	list.remove(0);
	        }
	        
	        //現在のループの行数
	        Integer countErrorLine = 0;
	        for (String string : list) {
	        	countErrorLine = countErrorLine + 1;
	        	Fabric fabric = new Fabric();
				String[] data = string.split(",");

				//属性値が要求を満たしているかどうか
				String dataWhetherConform = null;
				
				//検査項目数
				if(("I".equals(data[0]) || "U".equals(data[0]) || "D".equals(data[0])) 
						&& (data.length != 52)) {
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "", NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT));
					break;
				}
				
				//検査処理区分
				if(!("null".equals(data[0])) && data[0] != null && !("".equals(data[0]))
						&& ("I".equals(data[0]) || "U".equals(data[0]) || "D".equals(data[0]))){
					
					//ｃｓｖファイルに主キーの重複データがあるがどうか
					String primaryKeyStr = String.valueOf(data[1]).concat(String.valueOf(data[2]));
					if(primaryKeyMap.isEmpty() == true) {
						//最初のデータ、主キーのコレクションは空です
						primaryKeyMap.put(primaryKeyStr, String.valueOf(countErrorLine));
					} else {
						boolean contains = primaryKeyMap.containsKey(primaryKeyStr);
						if(contains == false) {
							//主キーの繰り返しなし
							primaryKeyMap.put(primaryKeyStr, String.valueOf(countErrorLine));
						}else {
							//主キーの繰り返し
							fabric.setOrderPattern(data[1]);
							fabric.setFabricNo(data[2]);
							//このエラーが発生した場合、2番目のパラメータは２回目に繰り返される行数、３番目のパラメータは最初の反復の行数です
							fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, 
									String.valueOf(primaryKeyMap.get(primaryKeyStr)),
									DUPLICATE_PRIMARY_KEY_IN_FILE));
							break;
						}
					}
					
					//検査オーダーバターン、特殊のチェック
					if("CO".equals(data[1]) || "PO".equals(data[1])){
						fabric.setOrderPattern(data[1]);
					}else if("".equals(data[1])){
						fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "オーダーパターン", PROJECT_NAME_IS_EMPTY));
						break;
					}else{
						fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "オーダーパターン", VALUE_IS_INCORRECT));
						break;
					}
					
					//生地品番
					dataWhetherConform = stringCheckIsHalfAngle(data[2], 20);
					if(dataWhetherConform == MEET_THE_REQUIREMENT){
						fabric.setFabricNo(data[2]);
					}else{
						setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "生地品番");
						break;
					}
					
					//処理区分がI、U、Dの場合
					if("I".equals(data[0])) {
						boolean fabricCheckExistence = fabricService.fabricCheckExistence(data[1], data[2]);
						if(fabricCheckExistence == false) {
							fabric.setHandleDiscriminate(data[0]);
							fabric.setCreatedUserId(sessionContent.getUserId());
							fabric.setUpdatedUserId(sessionContent.getUserId());
						}else {
							//エラー場合、Iの代わりにXを使います
							fabric.setHandleDiscriminate("X");
							fabric.setMaterialNo(data[3]);
							fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "処理区分", PROCESSING_SEPARATION_IS_INCORRECT));
							break;
						}
					}else if("U".equals(data[0])) {
						boolean fabricCheckExistence = fabricService.fabricCheckExistence(data[1], data[2]);
						if(fabricCheckExistence == true) {
							fabric.setHandleDiscriminate(data[0]);
							fabric.setUpdatedUserId(sessionContent.getUserId());
						}else {
							//エラー場合、Uの代わりにYを使います
							fabric.setHandleDiscriminate("Y");
							fabric.setMaterialNo(data[3]);
							fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "処理区分", PROCESSING_SEPARATION_IS_INCORRECT));
							break;
						}
					}else if("D".equals(data[0])) {
						boolean fabricCheckExistence = fabricService.fabricCheckExistence(data[1], data[2]);
						if(fabricCheckExistence == true) {
							fabric.setHandleDiscriminate(data[0]);
							fabricList.add(fabric);
							continue;
						}else {
							//エラー場合、Dの代わりにZを使います
							fabric.setHandleDiscriminate("Z");
							fabric.setMaterialNo(data[3]);
							fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "処理区分", PROCESSING_SEPARATION_IS_INCORRECT));
							break;
						}
					}
				}else {
					continue;
				}
				
				//検査素材品番
				dataWhetherConform = stringCheckNoAngle(data[3], 30);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){ 
					fabric.setMaterialNo(data[3]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "素材品番");
					break;
				}
				
				//生地ブランド管理番号、特殊のチェック
				boolean fablicBrandNoCheckExistence = fabricService.fablicBrandNoCheckExistence(data[4]);
				if("".equals(data[4])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "生地ブランド管理番号", PROJECT_NAME_IS_EMPTY));
					break;
				}else if(fablicBrandNoCheckExistence == false) {
					//生地ブランド管理番号存在しない、まちがった生地ブランド管理番号を書き入れる
					fabric.setFablicBrandNo(data[4]);
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "生地ブランド管理番号", MANAGEMENT_NUMBER_DOES_NOT_EXIST));
					break;
				}
				dataWhetherConform = integerCheckIsHalfAngle(data[4]);
				//5桁以下の正の整数
				String regEx = "^\\d{1,5}$";
				Pattern pattern = Pattern.compile(regEx);
				Matcher matcher = pattern.matcher(data[4]);
				if(dataWhetherConform == VALUE_IS_INCORRECT){
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "生地ブランド管理番号");
					break;
				}else if(!(matcher.matches())) {
					setErrorArrayToFabricList(fabricList, fabric, NUMBER_OF_BITS_IS_INCORRECT, countErrorLine, "生地ブランド管理番号");
					break;
				}else{
					fabric.setFablicBrandNo(data[4]);
				}
				
				//業態
				dataWhetherConform = stringCheckIsHalfAngle(data[5], 6);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setStoreBrand(data[5]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "業態");
					break;
				}
				
				//年季
				dataWhetherConform = stringCheckIsHalfAngle(data[6], 2);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setSeason(data[6]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "年季");
					break;
				}
				
				//色
				dataWhetherConform = stringCheckIsHalfAngle(data[7], 1);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setColor(data[7]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "色");
					break;
				}
				
				//柄
				dataWhetherConform = stringCheckIsHalfAngle(data[8], 1);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setPattern(data[8]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "柄");
					break;
				}
				
				//色(青山表記)
				dataWhetherConform = stringCheckIsHalfAngle(data[9], 1);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setColorAoyama(data[9]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "色(青山表記)");
					break;
				}
				
				//柄(青山表記)
				dataWhetherConform = stringCheckIsHalfAngle(data[10], 1);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setPatternAoyama(data[10]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "柄(青山表記)");
					break;
				}
				
				//素材ネーム
				dataWhetherConform = stringCheckNoAngle(data[11], 50);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setMaterialName(data[11]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "素材ネーム");
					break;
				}
				
				//アイテム区分、特殊のチェック
				if("01".equals(data[12]) || "02".equals(data[12]) || "05".equals(data[12]) || "06".equals(data[12])){
					fabric.setItemClass(data[12]);
				}else if("".equals(data[12])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "アイテム区分", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "アイテム区分", VALUE_IS_INCORRECT));
					break;
				}
				
				//コート可否、特殊のチェック
				if("1".equals(data[13]) || "0".equals(data[13])){
					fabric.setCoatAvailable(data[13]);
				}else if("".equals(data[13])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "コート可否", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "コート可否", VALUE_IS_INCORRECT));
					break;
				}
				
				//組成表示
				dataWhetherConform = stringCheckNoAngle(data[14], 300);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setCompositionLabel(data[14]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "組成表示");
					break;
				}
				
				//工場コード
				dataWhetherConform = stringCheckIsHalfAngle(data[15], 6);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setFactoryCode(data[15]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "工場コード");
					break;
				}
				
				//メーカーコード
				dataWhetherConform = stringCheckIsHalfAngle(data[16], 6);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setMakerCode(data[16]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "メーカーコード");
					break;
				}
				
				//LCR縫製可否、特殊のチェック
				if("1".equals(data[17]) || "0".equals(data[17])){
					fabric.setLcrSewingAvailable(data[17]);
				}else if("".equals(data[17])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "LCR縫製可否", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "LCR縫製可否", VALUE_IS_INCORRECT));
					break;
				}
				
				//上代
				dataWhetherConform = integerCheckIsHalfAngle(data[18]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setRetailPrice(Integer.parseInt(data[18]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "上代");
					break;
				}
				
				//PANTS追加増額率
				dataWhetherConform = integerCheckIsHalfAngle(data[19]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setAdditionalPantsRate(Integer.parseInt(data[19]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "PANTS追加増額率");
					break;
				}
				
				//シングルGILET追加増額率
				dataWhetherConform = integerCheckIsHalfAngle(data[20]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setAdditionalSingleGiletRate(Integer.parseInt(data[20]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "シングルGILET追加増額率");
					break;
				}
				
				//ダブルGILET追加増額率
				dataWhetherConform = integerCheckIsHalfAngle(data[21]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setAdditionalDoubleGiletRate(Integer.parseInt(data[21]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルGILET追加増額率");
					break;
				}
				
				//ダブルJACKET増額率
				dataWhetherConform = integerCheckIsHalfAngle(data[22]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setAdditionalDoubleJacketRate(Integer.parseInt(data[22]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルJACKET増額率");
					break;
				}
				
				//シングルJACKET単品率
				dataWhetherConform = integerCheckIsHalfAngle(data[23]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setSingleJacketOnlyRate(Integer.parseInt(data[23]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "シングルJACKET単品率");
					break;
				}
				
				//ダブルJACKET単品率
				dataWhetherConform = integerCheckIsHalfAngle(data[24]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setDoubleJacketOnlyRate(Integer.parseInt(data[24]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルJACKET単品率");
					break;
				}
				
				//PANTS単品率
				dataWhetherConform = integerCheckIsHalfAngle(data[25]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setPantOnlyRate(Integer.parseInt(data[25]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "PANTS単品率");
					break;
				}
				
				//シングルGILET単品率
				dataWhetherConform = integerCheckIsHalfAngle(data[26]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setSingleGiletOnlyRate(Integer.parseInt(data[26]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "シングルGILET単品率");
					break;
				}
				
				//ダブルGILET単品率
				dataWhetherConform = integerCheckIsHalfAngle(data[27]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setDoubleGiletOnlyRate(Integer.parseInt(data[27]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルGILET単品率");
					break;
				}
	        	
				//シングルコート単品率
				dataWhetherConform = integerCheckIsHalfAngle(data[28]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setCoatSingleOnlyRate(Integer.parseInt(data[28]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "シングルコート単品率");
					break;
				}
				
				//ダブルコート単品率
				dataWhetherConform = integerCheckIsHalfAngle(data[29]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setCoatDoubleOnlyRate(Integer.parseInt(data[29]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルコート単品率");
					break;
				}
				
				//シングルJacketの単品購買追加金額
				dataWhetherConform = integerCheckIsHalfAngle(data[30]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setJkSingleOnlyPlusAlphaPrice(Integer.parseInt(data[30]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "シングルJacketの単品購買追加金額");
					break;
				}
				
				//ダブルJacketの単品購買追加金額
				dataWhetherConform = integerCheckIsHalfAngle(data[31]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setJkDoubleOnlyPlusAlphaPrice(Integer.parseInt(data[31]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルJacketの単品購買追加金額");
					break;
				}
				
				//シングルGiletの単品購買追加金額
				dataWhetherConform = integerCheckIsHalfAngle(data[32]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setGlSingleOnlyPlusAlphaPrice(Integer.parseInt(data[32]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "シングルGiletの単品購買追加金額");
					break;
				}
				
				//ダブルGiletの単品購買追加金額
				dataWhetherConform = integerCheckIsHalfAngle(data[33]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setGlDoubleOnlyPlusAlphaPrice(Integer.parseInt(data[33]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルGiletの単品購買追加金額");
					break;
				}
				
				//Pantsの単品購買追加金額
				dataWhetherConform = integerCheckIsHalfAngle(data[34]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setPtOnlyPlusAlphaPrice(Integer.parseInt(data[34]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "Pantsの単品購買追加金額");
					break;
				}
				
				//シングルCoatの単品購買追加金額
				dataWhetherConform = integerCheckIsHalfAngle(data[35]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setCtSingleOnlyPlusAlphaPrice(Integer.parseInt(data[35]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "シングルCoatの単品購買追加金額");
					break;
				}
				
				//ダブルCoatの単品購買追加金額
				dataWhetherConform = integerCheckIsHalfAngle(data[36]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setCtDoubleOnlyPlusAlphaPrice(Integer.parseInt(data[36]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "ダブルCoatの単品購買追加金額");
					break;
				}
				
				//生地代
				dataWhetherConform = integerCheckIsHalfAngle(data[37]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setFabricPrice(Integer.parseInt(data[37]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "生地代");
					break;
				}
				
				//ウォッシャブル可否、特殊のチェック
				if("1".equals(data[38]) || "0".equals(data[38])){
					fabric.setWashableAvailable(data[38]);
				}else if("".equals(data[38])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "ウォッシャブル可否", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "ウォッシャブル可否", VALUE_IS_INCORRECT));
					break;
				}
				
				//タキシード可否、特殊のチェック
				if("1".equals(data[39]) || "0".equals(data[39])){
					fabric.setTuxedoAvailable(data[39]);
				}else if("".equals(data[39])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "タキシード可否", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "タキシード可否", VALUE_IS_INCORRECT));
					break;
				}
				
				//下代調整金
				dataWhetherConform = integerCheckIsHalfAngle(data[40]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setWsPriceAdjust(Integer.parseInt(data[40]));
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "下代調整金");
					break;
				}
				
				//契約No
				dataWhetherConform = stringCheckIsHalfAngle(data[41], 20);
				if(dataWhetherConform == MEET_THE_REQUIREMENT || dataWhetherConform == PROJECT_NAME_IS_EMPTY){
					fabric.setContractNo(data[41]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "契約No");
					break;
				}
				
				//手帳(貿易)期限、特殊のチェック
				dataWhetherConform = stringCheckIsHalfAngle(data[42], 20);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					boolean convertSuccess = true;
					SimpleDateFormat spinningLimitDateSDF = new SimpleDateFormat("yyyyMMdd");
					try {
						spinningLimitDateSDF.setLenient(false);
						spinningLimitDateSDF.parse(data[42]);
						} catch (ParseException e) {
							//e.printStackTrace();
							convertSuccess=false;
						} 
					if(convertSuccess == true) {
						Date spinningLimitDateDate = spinningLimitDateSDF.parse(data[42]);
						fabric.setSpinningLimitDate(spinningLimitDateDate);
					}else {
						fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "手帳(貿易)期限", VALUE_IS_INCORRECT));
						break;
					}
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "手帳(貿易)期限");
					break;
				}
				
				//生地インポーター
				dataWhetherConform = stringCheckIsHalfAngle(data[43], 2);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setFablicImporter(data[43]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "生地インポーター");
					break;
				}
				
				//フル毛芯仕様可否、特殊のチェック
				if("1".equals(data[44]) || "0".equals(data[44])){
					fabric.setFullHairclothAvailable(data[44]);
				}else if("".equals(data[44])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "フル毛芯仕様可否", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "フル毛芯仕様可否", VALUE_IS_INCORRECT));
					break;
				}
				
				//シャツ仕様可否、特殊のチェック
				if("1".equals(data[45]) || "0".equals(data[45])){
					fabric.setShirtSleeveAvailable(data[45]);
				}else if("".equals(data[45])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "シャツ仕様可否", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "シャツ仕様可否", VALUE_IS_INCORRECT));
					break;
				}
				
				//店着納期区分（通常）
				dataWhetherConform = stringCheckIsHalfAngle(data[46], 2);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setStoreDelvNormal(data[46]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "店着納期区分（通常）");
					break;
				}
				
				//店着納期区分（早割）
				dataWhetherConform = stringCheckIsHalfAngle(data[47], 2);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setStoreDelvEarly(data[47]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "店着納期区分（早割）");
					break;
				}
				
				//店着納期区分（コート専用）
				dataWhetherConform = stringCheckIsHalfAngle(data[48], 2);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					fabric.setStoreDelvCoat(data[48]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "店着納期区分（コート専用）");
					break;
				}
				
				
				//取扱注意
				dataWhetherConform = stringCheckNoAngle(data[49], 50);
				if(dataWhetherConform == MEET_THE_REQUIREMENT || dataWhetherConform == PROJECT_NAME_IS_EMPTY){
					fabric.setHandlingCaution(data[49]);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "取扱注意");
					break;
				}
				
				//生地ネーム有無、特殊のチェック
				if("1".equals(data[50]) || "0".equals(data[50])){
					fabric.setFabricNameExist(data[50]);
				}else if("".equals(data[50])){
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "生地ネーム有無", PROJECT_NAME_IS_EMPTY));
					break;
				}else{
					fabricList.add(setErrorArrayDeploy(fabric, countErrorLine, "生地ネーム有無", VALUE_IS_INCORRECT));
					break;
				}
				
				//理論在庫、特殊のチェック
				dataWhetherConform = bigDecimalCheck(data[51]);
				if(dataWhetherConform == MEET_THE_REQUIREMENT){
					BigDecimal bigDecimal = new BigDecimal(data[51]); 
					bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP); 
					fabric.setTheoreticalStock(bigDecimal);
				}else{
					setErrorArrayToFabricList(fabricList, fabric, dataWhetherConform, countErrorLine, "理論在庫");
					break;
				}
				
				fabricList.add(fabric);
			}
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            inputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return fabricList;
	}
	
	/**
	 * エラーのオブジェクトはコレクションに入れる
	 * @param fabricList　修正されたコレクションの準備
	 * @param fabric　エラーが発生した相手
	 * @param dataWhetherConform　誤りがないかどうかのパラメータを判断する
	 * @param line　エラーが発生行
	 * @param row　エラーが発生列
	 * @return　エラーメッセージを設定した後のコレクション
	 */
	private ArrayList<Fabric> setErrorArrayToFabricList(ArrayList<Fabric> fabricList, Fabric fabric, 
			String dataWhetherConform, Integer line, String row) {
//		if(dataWhetherConform != null && "".equals(dataWhetherConform) && "null".equals(dataWhetherConform)) {
//			fabricList.add(setErrorArrayDeploy(fabric, line, row, dataWhetherConform));
//		}
		if(dataWhetherConform == NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT) {
			//CSVファイルの項目数が不正です。行数＝「エラー発生の第一番目の行数」
			fabricList.add(setErrorArrayDeploy(fabric, line, row, NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT));
		}else if(dataWhetherConform == PROCESSING_SEPARATION_IS_INCORRECT){
			//「エラー発生の第一番目の行数」の「エラー発生の項目名」の桁数が不正です。
			fabricList.add(setErrorArrayDeploy(fabric, line, row, PROCESSING_SEPARATION_IS_INCORRECT));
		}else if(dataWhetherConform == MANAGEMENT_NUMBER_DOES_NOT_EXIST){
			//「エラー発生の第一番目の行数」の「エラー発生の項目名」の桁数が不正です。
			fabricList.add(setErrorArrayDeploy(fabric, line, row, MANAGEMENT_NUMBER_DOES_NOT_EXIST));
		}else if(dataWhetherConform == PROJECT_NAME_IS_EMPTY){
			//「エラー発生の第一番目の行数」の「エラー発生の項目名」の桁数が不正です。
			fabricList.add(setErrorArrayDeploy(fabric, line, row, PROJECT_NAME_IS_EMPTY));
		}else if(dataWhetherConform == VALUE_IS_INCORRECT || dataWhetherConform == FULL_ANGLE){
			//「エラー発生の第一番目の行数」行目の「エラー発生の項目名」の値が不正です。||全角
			fabricList.add(setErrorArrayDeploy(fabric, line, row, VALUE_IS_INCORRECT));
		}else if(dataWhetherConform == NUMBER_OF_BITS_IS_INCORRECT){
			//「エラー発生の第一番目の行数」の「エラー発生の項目名」の桁数が不正です。
			fabricList.add(setErrorArrayDeploy(fabric, line, row, NUMBER_OF_BITS_IS_INCORRECT));
		}else if(dataWhetherConform == THE_STATUS_OF_ORDER_PATTERN_IS_INCORRECT){
			//オーダーパターンはログインする業態と不一致のため登録できません。オーダーパターン＝{0}，行数＝{1}
			fabricList.add(setErrorArrayDeploy(fabric, line, row, THE_STATUS_OF_ORDER_PATTERN_IS_INCORRECT));
		}
		return fabricList;
	}
	
	/**
	 * エラーた行の情報を設定する
	 * @param fabric　エラーが発生した相手
	 * @param line　エラーが発生行
	 * @param row　エラーが発生列
	 * @param type　エラーのタイプ
	 * @return　エラーメッセージを設定した後のオブジェクト
	 */
	private Fabric setErrorArrayDeploy(Fabric fabric, Integer line, String row, String type) {
		//エンティクラスのフォーマットに基づいて、エラー情報を配列に入れる
		String[] str = {String.valueOf(line), row, type};
		//エラーた行、エラーメッセージの設定
		fabric.setErrorArr(str);
		return fabric;
	}
	
	/**
	 * チェックstring型、半角でも全角でもよい
	 * @param str　検査の内容を準備する
	 * @return NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT:空;　NUMBER_OF_BITS_IS_INCORRECT:桁が正しくない; 
	 * @return MEET_THE_REQUIREMENT:要求にかなう
	 */
	private String stringCheckNoAngle(String str, int i) {
		if("null".equals(str) || str == null || "".equals(str)){
			//空
			return PROJECT_NAME_IS_EMPTY;
		}else{
			if(str.length() <= i){
				//要求にかなう
				return MEET_THE_REQUIREMENT;
			}else {
				//桁が正しくない
				return NUMBER_OF_BITS_IS_INCORRECT;
			}
		}
	}
	
	/**
	 * チェックstring型、半角でなければなりません
	 * @param str　検査の内容を準備する
	 * @return NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT:空;　NUMBER_OF_BITS_IS_INCORRECT:桁が正しくない; 
	 * @return MEET_THE_REQUIREMENT:要求にかなう; FULL_ANGLE:全角
	 */
	private String stringCheckIsHalfAngle(String str, int i) {
		String regEx = "^[A-Za-z0-9]+$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		
		if("null".equals(str) || str == null || "".equals(str)){
			//空
			return PROJECT_NAME_IS_EMPTY;
		}else{
	        if(!(matcher.matches())) {
	        	//全角です
	        	return FULL_ANGLE;
	        }else if(str.length() <= i){
	        	//要求にかなう
				return MEET_THE_REQUIREMENT;
			}else {
				//桁が正しくない
				return NUMBER_OF_BITS_IS_INCORRECT;
			}
		}
	}
	
	/**
	 * チェックinteger型、半角でなければなりません
	 * @param str　検査の内容を準備する
	 * @return NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT:空; VALUE_IS_INCORRECT:タイプが正しくない;　
	 * @return NUMBER_OF_BITS_IS_INCORRECT:桁が正しくない;  MEET_THE_REQUIREMENT:要求にかなう; FULL_ANGLE:全角
	 */
	private String integerCheckIsHalfAngle(String str) {
		String regEx = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		
		boolean digits = NumberUtils.isDigits(str);
		if("null".equals(str) || str == null || "".equals(str)){
			//空
			return PROJECT_NAME_IS_EMPTY;
		}else{
	        if(!(matcher.matches())) {
	        	//全角です
	        	return FULL_ANGLE;
	        }else if(digits != true) {
	        	//タイプが正しくない
				return VALUE_IS_INCORRECT;
			}else {
				//要求にかなう
				return MEET_THE_REQUIREMENT;
			}
		}
	}

	/**
	 * チェックbigDecimal型、半角でなければなりません
	 * @param str　検査の内容を準備する
	 * @return NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT:空; VALUE_IS_INCORRECT:タイプが正しくない;　
	 * @return NUMBER_OF_BITS_IS_INCORRECT:桁が正しくない;  MEET_THE_REQUIREMENT:要求にかなう; FULL_ANGLE:全角
	 */
	private String bigDecimalCheck(String str) {
		//整数位、小数位
		String regEx = "^\\d{1,3}$|^\\d{1,3}\\.\\d{1,2}$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		
		//数字かどうか
		String regExTwo = "^[-\\+]?[.\\d]*$";
        Pattern patternTwo = Pattern.compile(regExTwo);
        Matcher matcherTwo = patternTwo.matcher(str);
        
		if("null".equals(str) || str == null || "".equals(str)){
			//空
			return PROJECT_NAME_IS_EMPTY;
		}else {
			if(!(matcherTwo.matches())) {
	        	//タイプが正しくない
				return VALUE_IS_INCORRECT;
			}else if(!(matcher.matches())) {
				//桁が正しくない
				return NUMBER_OF_BITS_IS_INCORRECT;
			}else {
				//要求にかなう
				return MEET_THE_REQUIREMENT;
			}
		}
			
	}
	
	/**
	 * ダウンロード時、値が空かどうかを判断する
	 * @param str　入力値
	 * @return
	 */
	private String setUpEmptyString(String str) {
		if(str != null && !("null".equals(str))) {
			//ダウンロードの値は空ではありません
			return str;
		}else {
			//ダウンロードの値は空です、空の文字列に設定
			return "";
		}
	}
	
	/**
	 * チェックshort型
	 * @param str　検査の内容を準備する
	 * @return NUMBER_OF_ITEMS_IN_CSV_FILE_IS_INCORRECT:空; VALUE_IS_INCORRECT:タイプが正しくない;　
	 * @return NUMBER_OF_BITS_IS_INCORRECT:桁が正しくない;  MEET_THE_REQUIREMENT:要求にかなう; FULL_ANGLE:全角
	 */
	private String shortCheck(String str) {
		//32767以下の正の整数
		String regEx = "^\\d{1,4}$||^[1-2]\\d{1,4}$||^3[0-1]\\d{1,3}$||^32[0-6]\\d{1,2}$||^327[0-5]\\d$||^3276[0-7]$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		
		String regExTwo = "^[0-9]+$";
		Pattern patternTwo = Pattern.compile(regExTwo);
		Matcher matcherTwo = patternTwo.matcher(str);
		
		boolean digits = NumberUtils.isDigits(str);
		if("null".equals(str) || str == null || "".equals(str)){
			//空
			return PROJECT_NAME_IS_EMPTY;
		}else{
	        if(!(matcherTwo.matches())) {
	        	//全角です
	        	return FULL_ANGLE;
	        }else if(digits != true) {
	        	//タイプが正しくない
				return VALUE_IS_INCORRECT;
			}else if(!(matcher.matches())) {
				//桁が正しくない
				return NUMBER_OF_BITS_IS_INCORRECT;
			}else {
				//要求にかなう
				return MEET_THE_REQUIREMENT;
			}
		}
	}
	
	/**
	 * タイトルと内容をバイト出力ストリーム書き込みます
	 * @param output
	 * @param title
	 * @param content
	 * @throws IOException
	 */
	private void writeByteArrayOutputStream(ByteArrayOutputStream output, String[] title, String[][] content) throws IOException {
		StringBuffer sbTitle = new StringBuffer();
		for(int i=0;i<title.length;i++) {
			if(i == title.length-1) {
				sbTitle.append(title[i]).append("\r\n");
			}else {
				sbTitle.append(title[i]).append(",");
			}
		}
		
		byte[] a = String.valueOf(sbTitle).getBytes();
		output.write(a);
		
		for(int i=0;i<content.length;i++){
			StringBuffer sbBody = new StringBuffer();
			for(int j=0;j<content[i].length;j++){
				if(j == content[i].length-1) {
					sbBody.append(content[i][j]).append("\r\n");
				}else {
					sbBody.append(content[i][j]).append(",");
				}
			}
			
			byte[] b = String.valueOf(sbBody).getBytes();
			output.write(b);
		}
	}
	
}
