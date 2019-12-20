package co.jp.aoyama.macchinetta.app.common;

public class ZenkakuKatakanaToHankakuKatakana {
	 private static final String kanaHanZenTbl[][] = {
		      // 2文字構成の濁点付き半角カナ
		      // 必ずテーブルに先頭に置いてサーチ順を優先すること
		      { "ｶﾞ", "ガ" }, { "ｷﾞ", "ギ" }, { "ｸﾞ", "グ" }, { "ｹﾞ", "ゲ" }, { "ｺﾞ", "ゴ" }, 
		      { "ｻﾞ", "ザ" }, { "ｼﾞ", "ジ" }, { "ｽﾞ", "ズ" }, { "ｾﾞ", "ゼ" }, { "ｿﾞ", "ゾ" },
		      { "ﾀﾞ", "ダ" }, { "ﾁﾞ", "ヂ" }, { "ﾂﾞ", "ヅ" }, { "ﾃﾞ", "デ" }, { "ﾄﾞ", "ド" },
		      { "ﾊﾞ", "バ" }, { "ﾋﾞ", "ビ" }, { "ﾌﾞ", "ブ" }, { "ﾍﾞ", "ベ" }, { "ﾎﾞ", "ボ" }, 
		      { "ﾊﾟ", "パ" }, { "ﾋﾟ", "ピ" }, { "ﾌﾟ", "プ" }, { "ﾍﾟ", "ペ" }, { "ﾎﾟ", "ポ" }, 
		      { "ｳﾞ", "ヴ" },
		      // 1文字構成の半角カナ
		      { "ｱ", "ア" }, { "ｲ", "イ" }, { "ｳ", "ウ" }, { "ｴ", "エ" }, { "ｵ", "オ" }, 
		      { "ｶ", "カ" }, { "ｷ", "キ" }, { "ｸ", "ク" }, { "ｹ", "ケ" }, { "ｺ", "コ" }, 
		      { "ｻ", "サ" }, { "ｼ", "シ" }, { "ｽ", "ス" }, { "ｾ", "セ" }, { "ｿ", "ソ" }, 
		      { "ﾀ", "タ" }, { "ﾁ", "チ" }, { "ﾂ", "ツ" }, { "ﾃ", "テ" }, { "ﾄ", "ト" }, 
		      { "ﾅ", "ナ" }, { "ﾆ", "ニ" }, { "ﾇ", "ヌ" }, { "ﾈ", "ネ" }, { "ﾉ", "ノ" }, 
		      { "ﾊ", "ハ" }, { "ﾋ", "ヒ" }, { "ﾌ", "フ" }, { "ﾍ", "ヘ" }, { "ﾎ", "ホ" }, 
		      { "ﾏ", "マ" }, { "ﾐ", "ミ" }, { "ﾑ", "ム" }, { "ﾒ", "メ" }, { "ﾓ", "モ" }, 
		      { "ﾔ", "ヤ" }, { "ﾕ", "ユ" }, { "ﾖ", "ヨ" }, 
		      { "ﾗ", "ラ" }, { "ﾘ", "リ" }, { "ﾙ", "ル" }, { "ﾚ", "レ" }, { "ﾛ", "ロ" }, 
		      { "ﾜ", "ワ" }, { "ｦ", "ヲ" }, { "ﾝ", "ン" }, 
		      { "ｧ", "ァ" }, { "ｨ", "ィ" }, { "ｩ", "ゥ" }, { "ｪ", "ェ" }, { "ｫ", "ォ" }, 
		      { "ｬ", "ャ" }, { "ｭ", "ュ" }, { "ｮ", "ョ" }, { "ｯ", "ッ" }, 
		      { "｡", "。" }, { "｢", "「" }, { "｣", "」" }, { "､", "、" }, { "･", "・" }, 
		      { "ｰ", "ー" }, { "", "" }
	};

	 /**
	  * 全角カタカナ → 半角カタカナ変換
	  * @param kana
	  * @return
	  */
	 public static String ZenToHanForKKana(String kana) {
	      StringBuffer sb = new StringBuffer();
	      for (int i = 0, j = 0; i < kana.length(); i++) {
	          Character c = new Character(kana.charAt(i));
	          // Unicode全角カタカナのコード範囲か?
	          if (c.compareTo(new Character((char)0x30a1)) >= 0
	              && c.compareTo(new Character((char)0x30fc)) <= 0) {
	              // 半角全角変換テーブルを検索する
	              for (j = 0; j < kanaHanZenTbl.length; j++) {
	                  if (kana.substring(i).startsWith(kanaHanZenTbl[j][1])) {
	                      sb.append(kanaHanZenTbl[j][0]);
	                      break;
	                  }
	              }
	              // 検索できなければ、変換しない
	              if (j >= kanaHanZenTbl.length) {
	                  sb.append(c);
	              }   
	            } else { // 全角カタカナ以外なら変換しない
	                sb.append(c);
	            }
	      }
	      return sb.toString();
	  }
	 
}
