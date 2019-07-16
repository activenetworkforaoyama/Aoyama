package co.jp.aoyama.macchinetta.domain.service.piece;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Piece;
import co.jp.aoyama.macchinetta.domain.repository.piece.PieceRepository;

@Service
@Transactional
public class PieceServiceImpl implements PieceService {
	@Inject
    PieceRepository pieceRepository;

	/**
	 * すべての為替情報を調べる
	 */
	@Override
	public List<Piece> pieceQueryAll() {
		List<Piece> priceList = pieceRepository.pieceQueryAll();
		return priceList;
	}
	
	/**
	 * 主キーからオブジェクトが存在するかどうかを調べる
	 */
	@Override
	public Piece pieceQueryByPrimaryKey(Piece piece) {
		Piece pieceQueryByPrimaryKey = pieceRepository.pieceQueryByPrimaryKey(piece.getFactoryCode(),piece.getItemCode());
		return pieceQueryByPrimaryKey;
	}
	
	/**
	 * 工場コード存在するかどうかを調べる
	 */
	@Override
	public Integer pieceFactoryCodeQuery(Piece piece) {
		Integer pieceFactoryCodeQuery = pieceRepository.pieceFactoryCodeQuery(piece.getFactoryCode());
		return pieceFactoryCodeQuery;
	}
	
	/**
	 * アイテムコード存在するかどうかを調べる
	 */
	@Override
	public Integer pieceItemCodeQuery(Piece piece) {
		Integer pieceItemCodeQuery = pieceRepository.pieceItemCodeQuery(piece.getItemCode());
		return pieceItemCodeQuery;
	}
	
	/**
	 * 主キーによる新規
	 */
	@Override
	public Boolean insertPieceByPrimaryKey(List<Piece> pieceInsertList) {
		pieceRepository.insertPieceByPrimaryKey(pieceInsertList);
		return true;
	}
	
	/**
	 * 主キーによる修正
	 */
	@Override
	public Boolean updatePieceByPrimaryKey(List<Piece> pieceUpdateList) {
		pieceRepository.updatePieceByPrimaryKey(pieceUpdateList);
		return true;
	}

	/**
	 * 主キーによる削除
	 */
	@Override
	public Boolean deletePieceByPrimaryKey(List<Piece> pieceDeleteList) {
		pieceRepository.deletePieceByPrimaryKey(pieceDeleteList);
		return true;
	}

	/**
	 * 曖昧なクエリ
	 */
	@Override
	public List<Piece> pieceQueryFuzzy(Piece piece) {
		List<Piece> priceList = pieceRepository.pieceQueryFuzzy(piece.getFactoryCode(),piece.getItemCode());
		return priceList;
	}

}
