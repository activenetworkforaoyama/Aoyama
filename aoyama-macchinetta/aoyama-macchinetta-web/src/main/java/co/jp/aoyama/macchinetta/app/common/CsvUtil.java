package co.jp.aoyama.macchinetta.app.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


/**
 * CSVを出力
 * @author liuzhenyu
 *
 */
public class CsvUtil{
	 
	/**
	 * CSVを出力
	 * @param title タイトル内容
	 * @param content CSV内容
	 * @param outPutPath 出力ファイルのパス
	 * @param filename　出力ファイル名称
	 * @throws Exception　エラー
	 */
    public static void createCSVFile(String[] title, String[][] content,
                                     String outPutPath, String filename) throws Exception{
 
        File csvFile = null;
        BufferedWriter csvWtriter = null;
	
            csvFile = new File(outPutPath + File.separator + filename);
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();
 
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            
            // タイトルを出力
            writeTitle(title, csvWtriter);
 
            // 内容を出力
            writeRow(content, csvWtriter);
            csvWtriter.flush();
            csvWtriter.close();
        
    }
    
	/**
	 * CSVを出力
	 * @param title タイトル内容
	 * @param content CSV内容
	 * @param outPutPath 出力ファイルのパス
	 * @param filename　出力ファイル名称
	 * @throws Exception　エラー
	 */
    public static void createCSVFile(String[] title, String[] content,
                                     String outPutPath, String filename) throws Exception{
 
        File csvFile = null;
        BufferedWriter csvWtriter = null;
	
            csvFile = new File(outPutPath + File.separator + filename);
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();
 
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "SJIS"), 1024);
            
            // タイトルを出力
            writeTitle(title, csvWtriter);
 
            // 内容を出力
            writeRow(content, csvWtriter);
            csvWtriter.flush();
            csvWtriter.close();
        
    }
 
    /**
     * CSVタイトルを出力
     * @param title タイトル内容
     * @param csvWriter 　Writer
     * @throws Exception　エラー
     */
	private static void writeTitle(String[] title, BufferedWriter csvWriter) throws Exception {
    	
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<title.length;i++) {
    		
    		if(i == title.length-1) {
    			sb.append(title[i]).append("\r\n");
    		}else {
    			sb.append(title[i]);
    		}
    	}
    	csvWriter.write(sb.toString());
        //csvWriter.newLine();
    }
	
	/**
	 * CSV内容を出力
	 * @param values　CSV内容
	 * @param csvWriter　Writer
	 * @throws Exception　エラー
	 */
    private static void writeRow(String[][] values, BufferedWriter csvWriter) throws Exception {
    	for(int i=0;i<values.length;i++){
    		StringBuffer sb = new StringBuffer();
            for(int j=0;j<values[i].length;j++){
            	
            	if(j == values[i].length-1) {
            		sb.append(values[i][j]).append("");
            	}else {
            		sb.append(values[i][j]).append("\t");
            	}

            }
        	csvWriter.write(sb.toString());
        	csvWriter.newLine();
        }
    }
    
	/**
	 * CSV内容を出力
	 * @param values　CSV内容
	 * @param csvWriter　Writer
	 * @throws Exception　エラー
	 */
    private static void writeRow(String[] values, BufferedWriter csvWriter) throws Exception {
    	StringBuffer sbTitle = new StringBuffer();
    	for(int i=0; i<values.length; i++){
            sbTitle.append(values[i]).append("\r\n");
        }
    	csvWriter.write(sbTitle.toString());
    }
}

