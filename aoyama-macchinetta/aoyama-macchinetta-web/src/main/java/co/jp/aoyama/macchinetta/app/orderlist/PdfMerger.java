package co.jp.aoyama.macchinetta.app.orderlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 * pdfマージ
 * 
 * @author liuzhenyua
 *
 */
public class PdfMerger {

	public void mergePdf(String pdfPath, String out, List<String> checkedWhether) throws Throwable {

		PdfMerg(pdfPath, out, checkedWhether);
	}

	/**
	 * 
	 * @param folder
	 * @return
	 * @throws IOException
	 */
	public static String[] getCurFiles(String folder, List<String> checkedWhether) throws IOException {

		File _folder = new File(folder);
		File[] files = _folder.listFiles();
		int flag = 0;
		ArrayList<String> list = new ArrayList<String>();
		for (String checkedOrderId : checkedWhether) {
			for (int i = 0; i < files.length; i++) {
				if (!files[i].isDirectory()) {
					if (files[i].getName().contains(checkedOrderId)) {
						if (files[i].getName().endsWith("pdf")) {
							list.add(files[i].getName());
							flag = flag + 1;
							break;
						}
					}
				}
			}
			if(flag == 0) {
				throw new FileNotFoundException(checkedOrderId);
			}
		}
		if(list.size() == 0) {
			throw new FileNotFoundException();
		}
		return list.toArray(new String[list.size()]);
	}

	/**
	 * 
	 * @param folder
	 * @param destinationFileName
	 * @throws IOException
	 * @throws Exception
	 */
	public static void PdfMerg(String folder, String destinationFileName, List<String> checkedWhether)
			throws IOException, Exception {

		PDFMergerUtility mergePdf = new PDFMergerUtility();

		String[] filesInFolder = getCurFiles(folder, checkedWhether);

		System.out.println(Arrays.toString(filesInFolder));

		for (int i = 0; i < filesInFolder.length; i++) {
			mergePdf.addSource(folder + File.separator + filesInFolder[i]);
		}
		mergePdf.setDestinationFileName(destinationFileName);

		mergePdf.mergeDocuments(null);

		System.out.println("Merge is done");
	}
}
