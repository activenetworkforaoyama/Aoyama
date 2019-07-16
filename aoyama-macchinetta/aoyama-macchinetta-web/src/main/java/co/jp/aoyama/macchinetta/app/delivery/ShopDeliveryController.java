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
import co.jp.aoyama.macchinetta.domain.model.ShopDelivery;
import co.jp.aoyama.macchinetta.domain.service.delivery.ShopDeliveryService;

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
    Mapper beanMapper;
	
	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String pieceInit(Model model) {
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
		
		for (int i = 0; i < shopDeliveryFormList.size(); i++) {
			ShopDeliveryForm shopDeliveryFormGet = shopDeliveryFormList.get(i);
			//日付書式の変更:string-->date
			shopDeliveryFormGet = stringToDate(shopDeliveryFormGet);
			if(shopDeliveryFormGet.getDelType() == true) {
				//削除の操作
				ShopDelivery shopDelivery = beanMapper.map(shopDeliveryFormGet, ShopDelivery.class);
				shopDeliveryDeleteList.add(shopDelivery);
			}else{
				//新規または修正の操作
				ShopDelivery shopDelivery = beanMapper.map(shopDeliveryFormGet, ShopDelivery.class);
				if("1".equals(shopDelivery.getOptionType())) {
					//"1"は修正区分
					//納期情報の有無の照会
					ShopDelivery shopDeliveryQueryByPrimaryKey = shopDeliveryService.shopDeliveryQueryByPrimaryKey(shopDelivery);
					if(shopDeliveryQueryByPrimaryKey != null) {
						//納期情報が存在し、修正の作業
						shopDelivery.setUpdatedAt(new Date());
						shopDelivery.setUpdatedUserId(sessionContent.getUserId());
						shopDeliveryUpdateList.add(shopDelivery);
						//setUpdateFailure("0")：エラーが存在しない場合
						shopDeliveryFormGet.setUpdateFailure("0");
						shopDeliveryFormListReturn.add(shopDeliveryFormGet);
					}else {
						//納期情報の主キーはすでに存在しない。確認して再入力してください。
			            //setUpdateFailure("-1")：エラーが存在する場合
						shopDeliveryFormGet.setUpdateFailure("-1");
			            shopDeliveryFormListReturn.add(shopDeliveryFormGet);
					}
				}else if("2".equals(shopDelivery.getOptionType())) {
					//"2"は新規区分
					//承り日に共通点があるかどうか
					Integer shopDeliveryQueryIntersection = shopDeliveryService.shopDeliveryQueryIntersection(shopDelivery);
					if(shopDeliveryQueryIntersection != 0) {
						//納期情報の主キーはすでに存在している。確認して再入力してください。
						//setUpdateFailure("-1")：エラーが存在する場合
						shopDeliveryFormGet.setUpdateFailure("-1");
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
	
	if(shopDeliveryInsertList.size() != 0) {
		//新規の数はではありません
		shopDeliveryService.insertShopDeliveryByPrimaryKey(shopDeliveryInsertList);
	}
	
	if(shopDeliveryUpdateList.size() != 0) {
		//修正の数はではありません
		shopDeliveryService.updateShopDeliveryByPrimaryKey(shopDeliveryUpdateList);
	}
	
	if(shopDeliveryDeleteList.size() != 0) {
		//削除の数はではありません
		shopDeliveryService.deleteShopDeliveryByPrimaryKey(shopDeliveryDeleteList);
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
		
		if("全区分".equals(shopDeliveryForm.getShopDeliveryClass())) {
			//店着納期区分は全区分です
			for (int i = 1; i <= 9; i++) { 
				//ループ、ShopDeliveryFormの値を設定します
				ShopDeliveryForm shopDeliveryFormFor = new ShopDeliveryForm();
				shopDeliveryFormFor.setOrderOnStartDate(shopDeliveryForm.getOrderOnStartDate());
				shopDeliveryFormFor.setOrderOnEndDate(shopDeliveryForm.getOrderOnEndDate());
				shopDeliveryFormFor.setShopDeliveryClass("0" + String.valueOf(i));
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
					shopDeliveryForm.setErrorIdentification("0");
					shopDeliveryFormListReturn.add(shopDeliveryFormFor); 
				}else {
					//setErrorIdentification("-1")：エラーが存在する場合
					shopDeliveryForm.setErrorIdentification("-1");
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

}
