package co.jp.aoyama.macchinetta.app.delivery;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.GeneralCode;
import co.jp.aoyama.macchinetta.domain.model.ShopDelivery;
import co.jp.aoyama.macchinetta.domain.service.delivery.ShopDeliveryService;
import co.jp.aoyama.macchinetta.domain.service.generalcode.GeneralCodeService;

/**
 * 納期管理
 * @author wuzhengyang
 *
 */
@Controller
@RequestMapping(value = "/delivery")
public class ShopDeliveryController {
	
	@Inject
    SessionContent sessionContent;
    
    @Inject
    ShopDeliveryService shopDeliveryService;
    
    @Inject
    GeneralCodeService generalCodeService;
    
    @Inject
    Mapper beanMapper;
	
	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String pieceInit(Model model) {
		List<GeneralCode> generalCodeList = getGeneralCode();
		model.addAttribute("generalCodeList", generalCodeList);
		return "delivery/shopDeliveryForm";
	}
	
	/**
	 * 納期管理の更新
	 * @param ShopDeliveryFormList
	 * @return
	 */
	@RequestMapping(value = "/shopDeliveryUpdate", method = RequestMethod.POST)
	@ResponseBody
	public List<ShopDeliveryForm> shopDeliveryUpdate(@RequestBody List<ShopDeliveryForm> shopDeliveryFormList) {
		//新規情報を格納する
		List<ShopDelivery> shopDeliveryInsertList = new ArrayList<ShopDelivery>();
		//修正情報を格納する
		List<ShopDelivery> shopDeliveryUpdateList = new ArrayList<ShopDelivery>();
		//削除されたオブジェクト
		List<ShopDelivery> shopDeliveryDeleteList = new ArrayList<ShopDelivery>();
		//戻り先
		List<ShopDeliveryForm> shopDeliveryFormListReturn = new ArrayList<ShopDeliveryForm>();
		//本方法では、データが間違っていると記録されている表示
		boolean failureTemp = false;
		
		//店着納期区分のcodeValueを取得します
		List<GeneralCode> generalCodeList = getGeneralCode();
		for (int i = 0; i < shopDeliveryFormList.size(); i++) {
			for (int j = 0; j < generalCodeList.size(); j++) {
				if(generalCodeList.get(j).getCodeName().equals(shopDeliveryFormList.get(i).getShopDeliveryClass())) {
					shopDeliveryFormList.get(i).setShopDeliveryClass(generalCodeList.get(j).getCodeValue());
					break;
				}
			}
		}
		
		for (int i = 0; i < shopDeliveryFormList.size(); i++) {
			ShopDeliveryForm shopDeliveryFormGet = shopDeliveryFormList.get(i);
			//日付書式の変更:string-->date
			shopDeliveryFormGet = stringToDate(shopDeliveryFormGet);
			if(shopDeliveryFormGet.getDelType() == true) {
				//削除の操作
				ShopDelivery shopDelivery = beanMapper.map(shopDeliveryFormGet, ShopDelivery.class);
				ShopDelivery shopDeliveryQueryByPrimaryKey = shopDeliveryService.shopDeliveryQueryByPrimaryKey(shopDelivery);
				if(shopDeliveryQueryByPrimaryKey != null) {
					if(shopDelivery.getVersion().equals(shopDeliveryQueryByPrimaryKey.getVersion())) {
						//バージョン番号が正しいです、削除の作業
						shopDeliveryDeleteList.add(shopDelivery);
						shopDeliveryFormListReturn.add(shopDeliveryFormGet);
					}else {
						//バージョン番号が不正です
						//setUpdateFailure("-4")：バージョン番号が不正です
						shopDeliveryFormGet.setUpdateFailure("-4");
						failureTemp = true;
						shopDeliveryFormListReturn.add(shopDeliveryFormGet);
					}
				}else {
					//納期情報の主キーはすでに存在しない。確認して再入力してください。
		            //setUpdateFailure("-3")：削除のエラーが存在する場合
					shopDeliveryFormGet.setUpdateFailure("-3");
					failureTemp = true;
		            shopDeliveryFormListReturn.add(shopDeliveryFormGet);
				}
			}else{
				//新規または修正の操作
				ShopDelivery shopDelivery = beanMapper.map(shopDeliveryFormGet, ShopDelivery.class);
				if("1".equals(shopDelivery.getOptionType())) {
					//"1"は修正区分
					//納期情報の有無の照会
					ShopDelivery shopDeliveryQueryByPrimaryKey = shopDeliveryService.shopDeliveryQueryByPrimaryKey(shopDelivery);
					if(shopDeliveryQueryByPrimaryKey != null) {
						//納期情報が存在し
						if(shopDelivery.getVersion().equals(shopDeliveryQueryByPrimaryKey.getVersion())) {
							//バージョン番号が正しいです、修正の作業
							shopDelivery.setUpdatedAt(new Date());
							shopDelivery.setUpdatedUserId(sessionContent.getUserId());
							shopDeliveryUpdateList.add(shopDelivery);
							//setUpdateFailure("0")：エラーが存在しない場合
							shopDeliveryFormGet.setUpdateFailure("0");
							shopDeliveryFormListReturn.add(shopDeliveryFormGet);
						}else {
							//バージョン番号が不正です
							//setUpdateFailure("-4")：バージョン番号が不正です
							shopDeliveryFormGet.setUpdateFailure("-4");
							failureTemp = true;
				            shopDeliveryFormListReturn.add(shopDeliveryFormGet);
						}
					}else {
						//納期情報の主キーはすでに存在しない。確認して再入力してください。
			            //setUpdateFailure("-2")：修正のエラーが存在する場合
						shopDeliveryFormGet.setUpdateFailure("-2");
						failureTemp = true;
			            shopDeliveryFormListReturn.add(shopDeliveryFormGet);
					}
				}else if("2".equals(shopDelivery.getOptionType())) {
					//"2"は新規区分
					//承り日に共通点があるかどうか
					Integer shopDeliveryQueryIntersection = shopDeliveryService.shopDeliveryQueryIntersection(shopDelivery);
					if(shopDeliveryQueryIntersection != 0) {
						//納期情報の主キーはすでに存在している。確認して再入力してください。
						//setUpdateFailure("-1")：新規のエラーが存在する場合
						shopDeliveryFormGet.setUpdateFailure("-1");
						failureTemp = true;
						shopDeliveryFormListReturn.add(shopDeliveryFormGet);
					}else {
						//条件を満たす
						shopDelivery.setCreatedAt(new Date());
						shopDelivery.setCreatedUserId(sessionContent.getUserId());
						shopDelivery.setUpdatedAt(new Date());
						shopDelivery.setUpdatedUserId(sessionContent.getUserId());
						shopDeliveryInsertList.add(shopDelivery);
						//setUpdateFailure("0")：エラーが存在しない場合
						shopDeliveryFormGet.setUpdateFailure("0");
						shopDeliveryFormListReturn.add(shopDeliveryFormGet);
					}
				}
			}
		}
		
		//すべてのデータに誤りがないので、新規、修正、削除の操作を開始します
		if(failureTemp == false) {
			//画面に表示されているデータのバージョン番号の変更を返します
			for (int i = 0; i < shopDeliveryFormListReturn.size(); i++) {
				if(shopDeliveryFormListReturn.get(i).getVersion() == null) {
					Short s1 = 1;
					shopDeliveryFormListReturn.get(i).setVersion(s1);
				}else {
					Short version = shopDeliveryFormListReturn.get(i).getVersion();
					shopDeliveryFormListReturn.get(i).setVersion(++version);
				}
			}
			
			if(shopDeliveryInsertList.size() != 0) {
				//新規の数はではありません
				//新規された場合、バージョン番号は１に設定されます
				for (int i = 0; i < shopDeliveryInsertList.size(); i++) {
					Short s1 = 1;
					shopDeliveryInsertList.get(i).setVersion(s1);
				}
				
				shopDeliveryService.insertShopDeliveryByPrimaryKey(shopDeliveryInsertList);
			}
			
			if(shopDeliveryUpdateList.size() != 0) {
				//修正の数はではありません
				//修正の場合、バージョン番号は１から増加します
				for (int i = 0; i < shopDeliveryUpdateList.size(); i++) {
					Short version = shopDeliveryUpdateList.get(i).getVersion();
					shopDeliveryUpdateList.get(i).setVersion(++version);
				}
				
				shopDeliveryService.updateShopDeliveryByPrimaryKey(shopDeliveryUpdateList);
			}
			
			if(shopDeliveryDeleteList.size() != 0) {
				//削除の数はではありません
				//戻ったりリストから消去したデータを削除します
				for (int i = 0, length = shopDeliveryFormListReturn.size(); i < length; i++) {
					if (shopDeliveryFormListReturn.get(i).getDelType() == true) {
						shopDeliveryFormListReturn.remove(shopDeliveryFormListReturn.get(i));
						length--;
						i--;
					}
				}
				
				shopDeliveryService.deleteShopDeliveryByPrimaryKey(shopDeliveryDeleteList);
			}
		}
		
		//店着納期区分の名前を取得します
		for (int i = 0; i < shopDeliveryFormListReturn.size(); i++) {
			for (int j = 0; j < generalCodeList.size(); j++) {
				if(generalCodeList.get(j).getCodeValue().equals(shopDeliveryFormListReturn.get(i).getShopDeliveryClass())) {
					shopDeliveryFormListReturn.get(i).setCodeName(generalCodeList.get(j).getCodeName());
					break;
				}
			}
		}
	
		return shopDeliveryFormListReturn;
	}
		
	/**
	 * 承り日に共通点があるかどうか
	 * @param ShopDeliveryFormList
	 * @return
	 */
	@RequestMapping(value = "/shopDeliveryQueryIntersection", method = RequestMethod.GET)
	@ResponseBody
	public List<ShopDeliveryForm> shopDeliveryQueryIntersection(ShopDeliveryForm shopDeliveryForm) {
		//戻り先
		List<ShopDeliveryForm> shopDeliveryFormListReturn = new ArrayList<ShopDeliveryForm>();
		//日付書式の変更:string-->date
		shopDeliveryForm = stringToDate(shopDeliveryForm);
		//店着納期区分の名前を取得します
		List<GeneralCode> generalCodeList = getGeneralCode();
		
		if("全区分".equals(shopDeliveryForm.getShopDeliveryClass())) {
			//店着納期区分は全区分です
			for (int i = 0; i < generalCodeList.size(); i++) { 
				//ループ、ShopDeliveryFormの値を設定します
				ShopDeliveryForm shopDeliveryFormFor = new ShopDeliveryForm();
				shopDeliveryFormFor.setOrderOnStartDate(shopDeliveryForm.getOrderOnStartDate());
				shopDeliveryFormFor.setOrderOnEndDate(shopDeliveryForm.getOrderOnEndDate());
				shopDeliveryFormFor.setShopDeliveryClass(generalCodeList.get(i).getCodeValue());
				shopDeliveryFormFor.setOrderOnStartDateStr(shopDeliveryForm.getOrderOnStartDateStr());
				shopDeliveryFormFor.setOrderOnEndDateStr(shopDeliveryForm.getOrderOnEndDateStr());
				shopDeliveryFormFor.setErrorIdentification(shopDeliveryForm.getErrorIdentification());
				shopDeliveryFormFor.setDelType(shopDeliveryForm.getDelType());
				shopDeliveryFormFor.setOptionType(shopDeliveryForm.getOptionType());
				shopDeliveryFormFor.setUpdateFailure(shopDeliveryForm.getUpdateFailure());
				shopDeliveryFormFor.setNum(shopDeliveryForm.getNum());
				shopDeliveryFormFor.setIsNewData(shopDeliveryForm.getIsNewData());
				
				ShopDelivery shopDelivery = beanMapper.map(shopDeliveryFormFor, ShopDelivery.class);
				//承り日に共通点があるかどうか 、０：交差点は存在しません、-１：交差して存在する
				Integer shopDeliveryQueryIntersection = shopDeliveryService.shopDeliveryQueryIntersection(shopDelivery);
				
				if(shopDeliveryQueryIntersection == 0) {
					//０：交差点は存在しません
					//日付を入力するより早く、空白の日付があるかどうか
					List<Date> orderOnStartDateQuery = shopDeliveryService.orderOnStartDateQuery(shopDelivery);
					orderOnStartDateAssignment(shopDelivery, shopDeliveryFormFor, orderOnStartDateQuery);
					
					//日付を入力するより遅く、空白の日付があるかどうか
					List<Date> orderOnEndDateQuery = shopDeliveryService.orderOnEndDateQuery(shopDelivery);
					orderOnEndDateAssignment(shopDelivery, shopDeliveryFormFor, orderOnEndDateQuery);
					
					shopDeliveryFormFor = dateToString(shopDeliveryFormFor);
					
					//setErrorIdentification("0")：エラーが存在しない場合
					shopDeliveryFormFor.setErrorIdentification("0");
					shopDeliveryFormListReturn.add(shopDeliveryFormFor); 
				}else {
					//setErrorIdentification("-1")：エラーが存在する場合
					shopDeliveryFormFor.setErrorIdentification("-1");
					shopDeliveryFormListReturn.add(shopDeliveryFormFor); 
				} 
				
			}
		}else {
			//店着納期区分は全区分でない場合
			ShopDelivery shopDelivery = beanMapper.map(shopDeliveryForm, ShopDelivery.class);
			
			//承り日に共通点があるかどうか 、０：交差点は存在しません、-１：交差して存在する
			Integer shopDeliveryQueryIntersection = shopDeliveryService.shopDeliveryQueryIntersection(shopDelivery);
			
			if(shopDeliveryQueryIntersection == 0) {
				//０：交差点は存在しません
				//日付を入力するより早く、空白の日付があるかどうか
				List<Date> orderOnStartDateQuery = shopDeliveryService.orderOnStartDateQuery(shopDelivery);
				orderOnStartDateAssignment(shopDelivery, shopDeliveryForm, orderOnStartDateQuery);
				
				//日付を入力するより遅く、空白の日付があるかどうか
				List<Date> orderOnEndDateQuery = shopDeliveryService.orderOnEndDateQuery(shopDelivery);
				orderOnEndDateAssignment(shopDelivery, shopDeliveryForm, orderOnEndDateQuery);
				shopDeliveryForm = dateToString(shopDeliveryForm);
				
				//setErrorIdentification("0")：エラーが存在しない場合
				shopDeliveryForm.setErrorIdentification("0");
				shopDeliveryFormListReturn.add(shopDeliveryForm); 
			}else {
				//setErrorIdentification("-1")：エラーが存在する場合
				shopDeliveryForm.setErrorIdentification("-1");
				shopDeliveryFormListReturn.add(shopDeliveryForm); 
			} 
			
		}
		
		//店着納期区分の名前を取得します
		for (int i = 0; i < shopDeliveryFormListReturn.size(); i++) {
			for (int j = 0; j < generalCodeList.size(); j++) {
				if(shopDeliveryFormListReturn.get(i).getShopDeliveryClass().equals(generalCodeList.get(j).getCodeValue())) {
					shopDeliveryFormListReturn.get(i).setCodeName(generalCodeList.get(j).getCodeName());
					break;
				}
			}
		}
		 
		return shopDeliveryFormListReturn;
	}
	
	 /**
	 * 曖昧なクエリ
	 * @param ShopDeliveryForm
	 * @return
	 */
	@RequestMapping(value = "/shopDeliveryQueryFuzzy" , method = RequestMethod.GET)
	@ResponseBody
	public List<ShopDeliveryForm> shopDeliveryQueryFuzzy(ShopDeliveryForm shopDeliveryForm){
		shopDeliveryForm = stringToDate(shopDeliveryForm);
		if("全区分".equals(shopDeliveryForm.getShopDeliveryClass())) {
			//全区分を空とする
			shopDeliveryForm.setShopDeliveryClass("");
		}
		ShopDelivery shopDelivery = beanMapper.map(shopDeliveryForm, ShopDelivery.class);
		//曖昧なクエリ、ShopDelivery集合に戻ります
		List<ShopDelivery> shopDeliveryList = shopDeliveryService.shopDeliveryQueryFuzzy(shopDelivery);
		List<ShopDeliveryForm> shopDeliveryFormList = new ArrayList<ShopDeliveryForm>();
		for (ShopDelivery shopDeliveryFor : shopDeliveryList) {
			ShopDeliveryForm shopDeliveryFormFor = beanMapper.map(shopDeliveryFor, ShopDeliveryForm.class);
			shopDeliveryFormFor = dateToString(shopDeliveryFormFor);
			shopDeliveryFormList.add(shopDeliveryFormFor);
		}
		
		//店着納期区分の名前を取得します
		List<GeneralCode> generalCodeList = getGeneralCode();
		for (int i = 0; i < shopDeliveryFormList.size(); i++) {
			for (int j = 0; j < generalCodeList.size(); j++) {
				if(shopDeliveryFormList.get(i).getShopDeliveryClass().equals(generalCodeList.get(j).getCodeValue())) {
					shopDeliveryFormList.get(i).setCodeName(generalCodeList.get(j).getCodeName());
					break;
				}
			}
		}
		
		return shopDeliveryFormList;
	}
	
	/**
	 * 日付書式の変更:date-->string
	 */
	@SuppressWarnings("unlikely-arg-type")
	public ShopDeliveryForm dateToString(ShopDeliveryForm ShopDeliveryForm){
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		
		//Date形式をStr形式に変更する、ShopDeliveryFormクラスオブジェクトに保存する
		if ((!"".equals(ShopDeliveryForm.getOrderOnStartDate())) && ShopDeliveryForm.getOrderOnStartDate() != null) {
			ShopDeliveryForm.setOrderOnStartDateStr(format.format(ShopDeliveryForm.getOrderOnStartDate()));
		}
		if ((!"".equals(ShopDeliveryForm.getOrderOnEndDate())) && ShopDeliveryForm.getOrderOnEndDate() != null) {
			ShopDeliveryForm.setOrderOnEndDateStr(format.format(ShopDeliveryForm.getOrderOnEndDate()));
		}
		if ((!"".equals(ShopDeliveryForm.getShopDeliveryOn())) && ShopDeliveryForm.getShopDeliveryOn() != null) {
			ShopDeliveryForm.setShopDeliveryOnStr(format.format(ShopDeliveryForm.getShopDeliveryOn()));
		}
		if ((!"".equals(ShopDeliveryForm.getBlankIntervalStart())) && ShopDeliveryForm.getBlankIntervalStart() != null) {
			ShopDeliveryForm.setBlankIntervalStartStr(format.format(ShopDeliveryForm.getBlankIntervalStart()));
		}
		if ((!"".equals(ShopDeliveryForm.getBlankIntervalEnd())) && ShopDeliveryForm.getBlankIntervalEnd() != null) {
			ShopDeliveryForm.setBlankIntervalEndStr(format.format(ShopDeliveryForm.getBlankIntervalEnd()));
		}
		
		return ShopDeliveryForm;
	}
	
	/**
	 * 日付書式の変更:string-->date
	 */
	public ShopDeliveryForm stringToDate(ShopDeliveryForm ShopDeliveryForm){
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		
		try {
			//Str形式をDate形式に変更する、ShopDeliveryFormクラスオブジェクトに保存する
			if ((!"".equals(ShopDeliveryForm.getOrderOnStartDateStr())) && ShopDeliveryForm.getOrderOnStartDateStr() != null) {
				ShopDeliveryForm.setOrderOnStartDate(format.parse(ShopDeliveryForm.getOrderOnStartDateStr()));
			}
			if ((!"".equals(ShopDeliveryForm.getOrderOnEndDateStr())) && ShopDeliveryForm.getOrderOnEndDateStr() != null) {
				ShopDeliveryForm.setOrderOnEndDate(format.parse(ShopDeliveryForm.getOrderOnEndDateStr()));
			}
			if ((!"".equals(ShopDeliveryForm.getShopDeliveryOnStr())) && ShopDeliveryForm.getShopDeliveryOnStr() != null) {
				ShopDeliveryForm.setShopDeliveryOn(format.parse(ShopDeliveryForm.getShopDeliveryOnStr()));
			}
			if ((!"".equals(ShopDeliveryForm.getBlankIntervalStartStr())) && ShopDeliveryForm.getBlankIntervalStartStr() != null) {
				ShopDeliveryForm.setBlankIntervalStart(format.parse(ShopDeliveryForm.getBlankIntervalStartStr()));
			}
			if ((!"".equals(ShopDeliveryForm.getBlankIntervalEndStr())) && ShopDeliveryForm.getBlankIntervalEndStr() != null) {
				ShopDeliveryForm.setBlankIntervalEnd(format.parse(ShopDeliveryForm.getBlankIntervalEndStr()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return ShopDeliveryForm;
	}
	
	/**
	 * 承り日FROMより早く、承り日FROMから一番近い合法な日付を設定します
	 */
	public void orderOnStartDateAssignment(ShopDelivery shopDelivery,ShopDeliveryForm shopDeliveryForm, 
			List<Date> orderOnStartDateQuery){
		
		Date startQueryAddOne = new Date();
		if(orderOnStartDateQuery.size() != 0) {
			//取得したデータベースの日付を一日追加し、入力した日付と比較するつもりです
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(orderOnStartDateQuery.get(0));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			startQueryAddOne = calendar.getTime();
		}
		
		if(1 < orderOnStartDateQuery.size()) {
			//複数の該当条件のデータ
			if(shopDelivery.getOrderOnStartDate().getTime() != startQueryAddOne.getTime()) {
				//結果の中で最大のデータは入力の日付に等しくないです
				shopDeliveryForm.setBlankIntervalStart(orderOnStartDateQuery.get(0));
			}else{
				//結果の中で最大のデータは入力の日付と同じです
				shopDeliveryForm.setBlankIntervalStart(null);
			}
		}else if(1 == orderOnStartDateQuery.size()){
			//条件の該当するデータは一つしかありません
			if(shopDelivery.getOrderOnStartDate().getTime() != startQueryAddOne.getTime()) {
				//結果の中で最大のデータは入力の日付に等しくないです
				shopDeliveryForm.setBlankIntervalStart(orderOnStartDateQuery.get(0));
			}else{
				//結果の中で最大のデータは入力の日付と同じです
				shopDeliveryForm.setBlankIntervalStart(null);
			}
		}else {
			//条件の該当するデータがありません
			shopDeliveryForm.setBlankIntervalStart(null);
		}
	}
	
	/**
	 * 承り日TOより遅く、承り日TOから一番近い合法な日付を設定します
	 */
	public void orderOnEndDateAssignment(ShopDelivery shopDelivery,ShopDeliveryForm shopDeliveryForm, 
			List<Date> orderOnEndDateQuery){
		
		Date EndQueryMinusOne = new Date();
		if(orderOnEndDateQuery.size() != 0) {
			//取得したデータベースの日付を一日減らして入力した日付と比較するつもりです
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(orderOnEndDateQuery.get(0));
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			EndQueryMinusOne = calendar.getTime();
		}
		
		if(1 < orderOnEndDateQuery.size()) {
			//複数の該当条件のデータ
			if(shopDelivery.getOrderOnEndDate().getTime() != EndQueryMinusOne.getTime()) {
				//結果の中で一番小さいのデータは入力の日付に等しくないです
				shopDeliveryForm.setBlankIntervalEnd(orderOnEndDateQuery.get(0));
			}else{
				//結果の中で一番小さいのデータは入力の日付と同じです
				shopDeliveryForm.setBlankIntervalEnd(null);
			}
		}else if(1 == orderOnEndDateQuery.size()){
			//条件の該当するデータは一つしかありません
			if(shopDelivery.getOrderOnEndDate().getTime() != EndQueryMinusOne.getTime()) {
				//結果の中で一番小さいのデータは入力の日付に等しくないです
				shopDeliveryForm.setBlankIntervalEnd(orderOnEndDateQuery.get(0));
			}else{
				//結果の中で一番小さいのデータは入力の日付と同じです
				shopDeliveryForm.setBlankIntervalEnd(null);
			}
		}else {
			//条件の該当するデータがありません
			shopDeliveryForm.setBlankIntervalEnd(null);
		}
	}
	
	/**
	 * GeneralCodeのオブジェクトを取得
	 * @return
	 */
	private List<GeneralCode> getGeneralCode(){
		GeneralCode generalCode = new GeneralCode();
		generalCode.setCodeType("01");
		List<GeneralCode> generalCodeList = generalCodeService.selectGeneralCodeByCodeType(generalCode);
		return generalCodeList;
	}

}
