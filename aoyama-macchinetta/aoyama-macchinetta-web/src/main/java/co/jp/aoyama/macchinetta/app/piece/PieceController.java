package co.jp.aoyama.macchinetta.app.piece;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import org.dozer.Mapper;
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
    
	private PieceForm pieceForm = new PieceForm();
	
	@ModelAttribute
	public PieceForm setupForm() {
	  return pieceForm;
	}
	  
	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping(value = "init", method = RequestMethod.GET)
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
		
		for (int i = 0; i < pieceFormList.size(); i++) {
			if(pieceFormList.get(i).getDelType()) {
				//削除の操作
				Piece piece = beanMapper.map(pieceFormList.get(i), Piece.class);
				pieceDeleteList.add(piece);
			}else{
				//新規または修正の操作
				Piece piece = beanMapper.map(pieceFormList.get(i), Piece.class);
				if("1".equals(piece.getOptionType())) {
					//"1"は修正区分
					//為替情報の有無の照会
					Piece pieceQueryByPrimaryKey = pieceService.pieceQueryByPrimaryKey(piece);
					if(pieceQueryByPrimaryKey != null) {
						//為替情報が存在し、修正の作業
						piece.setUpdatedAt(new Date());
						piece.setUpdatedUserId(sessionContent.getUserId());
						pieceUpdateList.add(piece);
						//setUpdateFailure("0")：エラーが存在しない場合
						pieceFormList.get(i).setUpdateFailure("0");
						pieceFormListReturn.add(pieceFormList.get(i));
					}else {
						//下代価格の主キーはすでに存在しません。確認して再入力してください。
			            //setUpdateFailure("-4"):下代価格の主キーはすでに存在しません
			            pieceFormList.get(i).setUpdateFailure("-4");
			            pieceFormListReturn.add(pieceFormList.get(i));
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
						pieceFormList.get(i).setUpdateFailure("-1");
			            pieceFormListReturn.add(pieceFormList.get(i));
					}else if(pieceFactoryCodeQuery == 0) {
						//工場コードは工場マスタに存在しません。確認して再入力してください。
						//setUpdateFailure("-2"):工場コードは工場マスタに存在しません
						pieceFormList.get(i).setUpdateFailure("-2");
			            pieceFormListReturn.add(pieceFormList.get(i));
					}else if(pieceItemCodeQuery == 0) {
						//アイテムコードはアイテムマスタに存在しません。確認して再入力してください。
						//setUpdateFailure("-3"):アイテムコードはアイテムマスタに存在しません
						pieceFormList.get(i).setUpdateFailure("-3");
			            pieceFormListReturn.add(pieceFormList.get(i));
					}else {
						//条件を満たす
						piece.setCreatedAt(new Date());
						piece.setCreatedUserId(sessionContent.getUserId());
						piece.setUpdatedAt(new Date());
						piece.setUpdatedUserId(sessionContent.getUserId());
						pieceInsertList.add(piece);
						//setUpdateFailure("0")：エラーが存在しない場合
						pieceFormList.get(i).setUpdateFailure("0");
						pieceFormList.get(i).setDisplayIdentify(true);
			            pieceFormListReturn.add(pieceFormList.get(i));
					}
				}
			}
		}
		
		if(pieceInsertList.size() != 0) {
			//新規の数はではありません
			pieceService.insertPieceByPrimaryKey(pieceInsertList);
		}
		
		if(pieceUpdateList.size() != 0) {
			//修正の数はではありません
			pieceService.updatePieceByPrimaryKey(pieceUpdateList);
		}
		
		if(pieceDeleteList.size() != 0) {
			//削除の数はではありません
			pieceService.deletePieceByPrimaryKey(pieceDeleteList);
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