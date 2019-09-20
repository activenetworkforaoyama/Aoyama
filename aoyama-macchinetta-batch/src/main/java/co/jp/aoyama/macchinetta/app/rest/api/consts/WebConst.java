package co.jp.aoyama.macchinetta.app.rest.api.consts;

/**
 * 
 * @author liufeng
 *
 */
public class WebConst {
	/** 大連大楊Po：api[GetStock]の失敗場合の結果 */
	public static final String STOCK_ERROR = "\"Result\": \"801\"";

	/** 上海服良Co：api[GetAccessToken]の成功場合の結果 */
	public static final String GET_ACCESS_TOKEN_SUCCESS = "01100";

	/** 上海服良Co：api[ReceiveOrder]の成功場合の結果 */
	public static final String RECEIVE_ORDER_SUCCESS = "03100";

	/** 上海服良Co：api[ReceiveOrder]の失敗場合の結果:トークン文字列のフォーマットが不正 */
	public static final String RECEIVE_ORDER_FAILED_TOKEN_FORMAT = "0301";

	/** 上海服良Co：api[ReceiveOrder]の失敗場合の結果:トークン文字列検証失敗、パスワードエラー */
	public static final String RECEIVE_ORDER_FAILED_TOKEN_CHECK = "0302";

	/** 上海服良Co：api[ReceiveOrder]の失敗場合の結果:アプリケーションプログラミングインタフェースパラメータ欠失 */
	public static final String RECEIVE_ORDER_FAILED_PARAM = "0337";

	/** 上海服良Co：api[GetAllQSMatStock]の成功場合の結果 */
	public static final String GET_STOCK_SUCCESS = "08100";

	/** 上海服良Co：api[GetAllQSMatStock]の失敗場合の結果:トークンが存在しない */
	public static final String GET_STOCK_FAILED_TOKEN = "0801";

	/** 上海服良Co：api[GetAllQSMatStock]の失敗場合の結果:パラメータが不足 */
	public static final String GET_STOCK_FAILED_PARAM = "0802";

	/** 上海服良Co：api[GetAllQSMatStock]の失敗場合の結果:生地が存在しない */
	public static final String GET_STOCK_FAILED_FABRIC = "0803";

	/** 上海服良Co：api[GetOrderStatus]の成功場合の結果 */
	public static final String GET_ORDER_STATUS_SUCCESS = "05100";

	/** 上海服良Co：api[GetOrderStatus]の失敗場合の結果:トークンが存在しない */
	public static final String GET_ORDER_STATUS_FAILED_TOKEN = "0501";

	/** 上海服良Co：api[GetOrderStatus]の失敗場合の結果:パラメータが不足 */
	public static final String GET_ORDER_STATUS_FAILED_PARAM = "0502";

	/** 上海服良Co：api[GetOrderStatus]の失敗場合の結果:注文IDが存在しない */
	public static final String GET_ORDER_STATUS_FAILED_ORDER = "0503";

	/** 上海服良Co：api[AESDecrypt]の成功場合の結果 */
	public static final String AES_DECRYPT_SUCCESS = "07100";

	/** 上海服良Co：api[AESDecrypt]の失敗場合の結果:トークンが存在しない */
	public static final String AES_DECRYPT_FAILED_TOKEN = "0701";
}
