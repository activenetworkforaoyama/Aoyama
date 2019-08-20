package co.jp.aoyama.macchinetta.domain.consts;

public class DomainConst {

	// 工場ステータス 生産開始前
	public static final String MAKER_FACTORY_STATUS_F0 = "F0";
	// 工場ステータス 生産開始
	public static final String MAKER_FACTORY_STATUS_F1 = "F1";
	// 工場ステータス 生産終了
	public static final String MAKER_FACTORY_STATUS_F2 = "F2";

	// 工場自動連携ステータス 送信前
	public static final String SEND2FACTORY_STATUS_0 = "0";
	// 工場自動連携ステータス 送信済み
	public static final String SEND2FACTORY_STATUS_1 = "1";
	// 工場自動連携ステータス 送信失敗 エラーなし
	public static final String SEND2FACTORY_STATUS_2 = "2";
	// 工場自動連携ステータス 送信失敗 データタイプエラー
	public static final String SEND2FACTORY_STATUS_3 = "3";
	// 工場自動連携ステータス 送信失敗 データエラー
	public static final String SEND2FACTORY_STATUS_4 = "4";
	// 工場自動連携ステータス 送信失敗 エラーデータと同一会計
	public static final String SEND2FACTORY_STATUS_5 = "5";

	// 会計ステータス 会計済
	public static final String CASH_STATUS_01 = "01";
	// 会計ステータス 会計取消
	public static final String CASH_STATUS_02 = "02";
	// 会計ステータス 会計再確認要
	public static final String CASH_STATUS_03 = "03";

	// TSCステータス 一時保存
	public static final String TSC_STATUS_T0 = "T0";
	// TSCステータス 取り置き
	public static final String TSC_STATUS_T1 = "T1";
	// TSCステータス 登録済
	public static final String TSC_STATUS_T2 = "T2";
	// TSCステータス 会計済
	public static final String TSC_STATUS_T3 = "T3";
	// TSCステータス 商品部承認済
	public static final String TSC_STATUS_T4 = "T4";
	// TSCステータス メーカー承認済
	public static final String TSC_STATUS_T5 = "T5";
	// TSCステータス 仕入済
	public static final String TSC_STATUS_T6 = "T6";
	// TSCステータス お渡し済
	public static final String TSC_STATUS_T7 = "T7";

	// バッチでデータ更新用ユーザID
	public static final String BATCH_UPDATE_USERID = "BatchUpd";

}
