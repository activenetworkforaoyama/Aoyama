package co.jp.aoyama.test;

import co.jp.aoyama.macchinetta.converter.*;

public class CommonConverterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String para1 = "";
		String para2 = null;
		String para3 = "1";
		String para4 = "1234567890";
		String para5 = "20190817";
		String para6 = "2019-08-17";
		String para7 = "123456789012";
		
		HalfWidthSpaceInserter halfWidthSpaceInserter = new HalfWidthSpaceInserter();
		
		String a = halfWidthSpaceInserter.getvalue(para1, 12, "righ");
		String b = halfWidthSpaceInserter.getvalue(para1, 12, "left");
		String c = halfWidthSpaceInserter.getvalue(para2, 12, "righ");
		String d = halfWidthSpaceInserter.getvalue(para2, 12, "left");
		String e = halfWidthSpaceInserter.getvalue(para3, 12, "righ");
		String f = halfWidthSpaceInserter.getvalue(para3, 12, "left");
		String g = halfWidthSpaceInserter.getvalue(para4, 12, "righ");
		String h = halfWidthSpaceInserter.getvalue(para4, 12, "left");
		String i = halfWidthSpaceInserter.getvalue(para7, 12, "righ");
		String j = halfWidthSpaceInserter.getvalue(para7, 12, "left");
		
		System.out.println("***a***:" +a);
		System.out.println("***b***:" +b);
		System.out.println("***c***:" +c);
		System.out.println("***d***:" +d);
		System.out.println("***e***:" +e);
		System.out.println("***f***:" +f);
		System.out.println("***g***:" +g);
		System.out.println("***h***:" +h);
		System.out.println("***i***:" +i);
		System.out.println("***j***:" +j);
		System.out.println("**HalfWidthSpaceInserter終了*********************************");
		
		HalfWidthZeroInserter HalfWidthZeroInserter = new HalfWidthZeroInserter();
		
		String a1 = HalfWidthZeroInserter.getvalue(para1, 12);
		String b1 = HalfWidthZeroInserter.getvalue(para2, 12);
		String c1 = HalfWidthZeroInserter.getvalue(para3, 12);
		String d1 = HalfWidthZeroInserter.getvalue(para1, 12, 1, 3);
		String e1 = HalfWidthZeroInserter.getvalue(para2, 12, 1, 3);
		String f1 = HalfWidthZeroInserter.getvalue(para3, 12, 1, 3);
		String g1 = HalfWidthZeroInserter.getvalue(para4, 12, 1, 3);
		
		System.out.println("***a1***:" +a1);
		System.out.println("***b1***:" +b1);
		System.out.println("***c1***:" +c1);
		System.out.println("***d1***:" +d1);
		System.out.println("***e1***:" +e1);
		System.out.println("***f1***:" +f1);
		System.out.println("***g1***:" +g1);
		
		System.out.println("**HalfWidthZeroInserter終了*********************************");
		SimpleDateConverter SimpleDateConverter = new SimpleDateConverter();
		
		String a2 = SimpleDateConverter.getValue(para1);
		String b2 = SimpleDateConverter.getValue(para2);
		String c2 = SimpleDateConverter.getValue(para3);
		String d2 = SimpleDateConverter.getValue(para4);
		String e2 = SimpleDateConverter.getValue(para5);
		String f2 = SimpleDateConverter.getValue(para6);
		
		System.out.println("***a2***:" +a2);
		System.out.println("***b2***:" +b2);
		System.out.println("***c2***:" +c2);
		System.out.println("***d2***:" +d2);
		System.out.println("***e2***:" +e2);
		System.out.println("***f2***:" +f2);
		System.out.println("**SimpleDateConverter終了*********************************");
	}

}
