package co.jp.aoyama.macchinetta.domain.repository.piece;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Piece;

public interface PieceRepository {

    List<Piece> pieceQueryAll();
	
    Piece pieceQueryByPrimaryKey(@Param("factoryCode") String factoryCode, @Param("itemCode") String itemCode);

    List<Piece> pieceQueryFuzzy(@Param("factoryCode") String factoryCode, @Param("itemCode") String itemCode);

	void insertPieceByPrimaryKey(@Param("pieceInsertList") List<Piece> pieceInsertList);

	void updatePieceByPrimaryKey(@Param("pieceUpdateList") List<Piece> pieceUpdateList);

	void deletePieceByPrimaryKey(@Param("pieceDeleteList") List<Piece> pieceDeleteList);
	
	Integer pieceFactoryCodeQuery(@Param("factoryCode") String factoryCode);
	
	Integer pieceItemCodeQuery(@Param("itemCode") String itemCode);
	
}