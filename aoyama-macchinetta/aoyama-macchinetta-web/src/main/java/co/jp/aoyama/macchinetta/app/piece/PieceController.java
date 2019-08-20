package co.jp.aoyama.macchinetta.app.piece;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Piece;
import co.jp.aoyama.macchinetta.domain.service.piece.PieceService;

/**
 * 為替管理
 * @author wuzhengyang
 *
 */
@Controller
@RequestMapping(value = "/piece")
public class PieceController {

    @Inject
    SessionContent sessionContent;
    
    @Inject
    PieceService pieceService;
    
    @Inject
    Mapper beanMapper;
	
	private static final Logger logger = LoggerFactory
            .getLogger(PieceController.class);
	
	private PieceForm pieceForm = new PieceForm();
	
	@ModelAttribute
	public PieceForm setupForm() {
	  return pieceForm;
	}
	  
	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping(value = "init")
	public String pieceInit(Model model) {
		return "piece/pieceForm";
	}
	
	/**
	 * すべての為替の情報を調べる
	 * @return
	 */
	@RequestMapping(value = "pieceQueryAll", method = RequestMethod.GET)
	@ResponseBody
	public List<PieceForm> pieceQueryAll() {
		List<PieceForm> pieceFormList = new ArrayList<PieceForm>();
		List<Piece> pieceList = pieceService.pieceQueryAll();
		//バックグラウンド為替オブジェクトをフロントオブジェクトに変換する
		for (Piece piece : pieceList) {
			PieceForm pieceForm = beanMapper.map(piece, PieceForm.class);
			pieceFormList.add(pieceForm);
		}
		return pieceFormList;
	}
	
	/**
	 * 為替情報の更新
	 * @param pieceFormList
	 * @return
	 */
	@RequestMapping(value = "/pieceUpdate", method = RequestMethod.POST)
	@ResponseBody
	public List<PieceForm> pieceUpdate(@RequestBody List<PieceForm> pieceFormList, Model model) {
		//新規情報を格納する
		List<Piece> pieceInsertList = new ArrayList<Piece>();
		//修正情報を格納する
		List<Piece> pieceUpdateList = new ArrayList<Piece>();
		//削除されたオブジェクト
		List<Piece> pieceDeleteList = new ArrayList<Piece>();
		//戻り先
		List<PieceForm> pieceFormListReturn = new ArrayList<PieceForm>();
		//本方法では、データが間違っていると記録されている表示
		boolean failureTemp = false;
		
		for (int i = 0; i < pieceFormList.size(); i++) {
			PieceForm pieceFormGet = pieceFormList.get(i);
			if(pieceFormList.get(i).getDelType()) {
				//削除の操作
				Piece piece = beanMapper.map(pieceFormGet, Piece.class);
				pieceDeleteList.add(piece);
				
				Piece pieceQueryByPrimaryKey = pieceService.pieceQueryByPrimaryKey(piece);
				if(pieceQueryByPrimaryKey != null) {
					if(piece.getVersion().equals(pieceQueryByPrimaryKey.getVersion())) {
						//バージョン番号が正しいです、削除の作業
						pieceDeleteList.add(piece);
						pieceFormListReturn.add(pieceFormGet);
					}else {
						//バージョン番号が不正です
						//setUpdateFailure("-5")：バージョン番号が不正です
						pieceFormGet.setUpdateFailure("-5");
						failureTemp = true;
						pieceFormListReturn.add(pieceFormGet);
						logger.info("バージョン番号が不正です");
					}
				}else {
					//下代価格の主キーはすでに存在しない。確認して再入力してください。
		            //setUpdateFailure("-4")：削除のエラーが存在する場合
					pieceFormGet.setUpdateFailure("-4");
					failureTemp = true;
					pieceFormListReturn.add(pieceFormGet);
					logger.info("削除のエラーが存在する場合。----納期情報の主キーはすでに存在しない。");
				}
			}else{
				//新規または修正の操作
				Piece piece = beanMapper.map(pieceFormList.get(i), Piece.class);
				if("1".equals(piece.getOptionType())) {
					//"1"は修正区分
					//為替情報の有無の照会
					Piece pieceQueryByPrimaryKey = pieceService.pieceQueryByPrimaryKey(piece);
					if(pieceQueryByPrimaryKey != null) {
						//為替情報が存在し
						if(piece.getVersion().equals(pieceQueryByPrimaryKey.getVersion())) {
							//バージョン番号が正しいです、修正の作業
							piece.setUpdatedAt(new Date());
							piece.setUpdatedUserId(sessionContent.getUserId());
							pieceUpdateList.add(piece);
							//setUpdateFailure("0")：エラーが存在しない場合
							pieceFormGet.setUpdateFailure("0");
							pieceFormListReturn.add(pieceFormGet);
						}else {
							//バージョン番号が不正です
							//setUpdateFailure("-5")：バージョン番号が不正です
							pieceFormGet.setUpdateFailure("-5");
							failureTemp = true;
							pieceFormListReturn.add(pieceFormGet);
							logger.info("バージョン番号が不正です");
						}
					}else {
						//下代価格の主キーはすでに存在しません。確認して再入力してください。
			            //setUpdateFailure("-4"):下代価格の主キーはすでに存在しません
						pieceFormGet.setUpdateFailure("-4");
			            failureTemp = true;
			            pieceFormListReturn.add(pieceFormGet);
			            logger.info("修正のエラーが存在する場合。----納期情報の主キーはすでに存在しない。");
					}
				}else if("2".equals(piece.getOptionType())) {
					//"2"は新規区分
					//為替情報の有無の照会
					Piece pieceQueryByPrimaryKey = pieceService.pieceQueryByPrimaryKey(piece);
					Integer pieceFactoryCodeQuery = pieceService.pieceFactoryCodeQuery(piece);
					Integer pieceItemCodeQuery = pieceService.pieceItemCodeQuery(piece);
					if(pieceQueryByPrimaryKey != null) {
						//下代価格の主キーはすでに存在している。確認して再入力してください。
						//setUpdateFailure("-1"):下代価格の主キーはすでに存在している
						pieceFormGet.setUpdateFailure("-1");
			            failureTemp = true;
			            pieceFormListReturn.add(pieceFormGet);
			            logger.info("新規のエラーが存在する場合。----下代価格の主キーはすでに存在している。");
					}else if(pieceFactoryCodeQuery == 0) {
						//工場コードは工場マスタに存在しません。確認して再入力してください。
						//setUpdateFailure("-2"):工場コードは工場マスタに存在しません
						pieceFormGet.setUpdateFailure("-2");
			            failureTemp = true;
			            pieceFormListReturn.add(pieceFormGet);
			            logger.info("新規のエラーが存在する場合。----工場コードは工場マスタに存在しません。");
					}else if(pieceItemCodeQuery == 0) {
						//アイテムコードはアイテムマスタに存在しません。確認して再入力してください。
						//setUpdateFailure("-3"):アイテムコードはアイテムマスタに存在しません
						pieceFormGet.setUpdateFailure("-3");
			            failureTemp = true;
			            pieceFormListReturn.add(pieceFormGet);
			            logger.info("新規のエラーが存在する場合。----アイテムコードはアイテムマスタに存在しません。");
					}else {
						//条件を満たす
						piece.setCreatedAt(new Date());
						piece.setCreatedUserId(sessionContent.getUserId());
						piece.setUpdatedAt(new Date());
						piece.setUpdatedUserId(sessionContent.getUserId());
						pieceInsertList.add(piece);
						//setUpdateFailure("0")：エラーが存在しない場合
						pieceFormGet.setUpdateFailure("0");
						pieceFormListReturn.add(pieceFormGet);
					}
				}
			}
		}
		
		//すべてのデータに誤りがないので、新規、修正、削除の操作を開始します
		if(failureTemp == false) {
			//画面に表示されているデータのバージョン番号の変更を返します
			for (int i = 0; i < pieceFormListReturn.size(); i++) {
				if(pieceFormListReturn.get(i).getVersion() == null) {
					Short s1 = 1;
					pieceFormListReturn.get(i).setVersion(s1);
				}else {
					Short version = pieceFormListReturn.get(i).getVersion();
					pieceFormListReturn.get(i).setVersion(++version);
				}
			}
			
			if(pieceInsertList.size() != 0) {
				//新規の数はではありません
				//新規された場合、バージョン番号は１に設定されます
				for (int i = 0; i < pieceInsertList.size(); i++) {
					Short s1 = 1;
					pieceInsertList.get(i).setVersion(s1);
				}
				
				pieceService.insertPieceByPrimaryKey(pieceInsertList);
			}
			if(pieceUpdateList.size() != 0) {
				//修正の数はではありません
				//修正の場合、バージョン番号は１から増加します
				for (int i = 0; i < pieceUpdateList.size(); i++) {
					Short version = pieceUpdateList.get(i).getVersion();
					pieceUpdateList.get(i).setVersion(++version);
				}
				
				pieceService.updatePieceByPrimaryKey(pieceUpdateList);
			}
			if(pieceDeleteList.size() != 0) {
				//削除の数はではありません
				//戻ったりリストから消去したデータを削除します
				for (int i = 0, length = pieceFormListReturn.size(); i < length; i++) {
					if (pieceFormListReturn.get(i).getDelType() == true) {
						pieceFormListReturn.remove(pieceFormListReturn.get(i));
						length--;
						i--;
					}
				}
				
				pieceService.deletePieceByPrimaryKey(pieceDeleteList);
			}
		}
		
		return pieceFormListReturn;

	}
	
	/**
	 * 曖昧なクエリ
	 * @param pieceForm
	 * @return
	 */
	@RequestMapping(value = "/pieceQueryFuzzy" , method = RequestMethod.GET)
	@ResponseBody
	public List<PieceForm> pieceQueryFuzzy(PieceForm pieceForm){
		Piece piece = beanMapper.map(pieceForm, Piece.class);
		List<Piece> pieceList = pieceService.pieceQueryFuzzy(piece);
		List<PieceForm> pieceFormList = new ArrayList<PieceForm>();
		for (Piece pieceFor : pieceList) {
			PieceForm pieceFormFor = beanMapper.map(pieceFor, PieceForm.class);
			pieceFormList.add(pieceFormFor);
		}
		return pieceFormList;
	}
	
}