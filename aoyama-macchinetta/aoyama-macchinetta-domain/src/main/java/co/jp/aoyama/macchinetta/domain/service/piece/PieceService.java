package co.jp.aoyama.macchinetta.domain.service.piece;

import co.jp.aoyama.macchinetta.domain.model.Piece;
import java.util.List;

public interface PieceService {

    List<Piece> pieceQueryAll();

	Piece pieceQueryByPrimaryKey(Piece piece);

	Integer pieceFactoryCodeQuery(Piece piece);
	
	Integer pieceItemCodeQuery(Piece piece);

	Boolean insertPieceByPrimaryKey(List<Piece> pieceList);
	
	Boolean updatePieceByPrimaryKey(List<Piece> pieceList);

	Boolean deletePieceByPrimaryKey(List<Piece> pieceList);

	List<Piece> pieceQueryFuzzy(Piece piece);
}