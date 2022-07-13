package analysis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import course.Course;
import course.TopicAndSLT;

/**
 * A flexible program that writes data to an Excel file in either XLSX or XLS
 * format, depending on the extension of the file.
 * 
 * @author www.codejava.net
 *
 */
public class SLTMatrixExcelWriter {

	private File tempFile;

	public File getTempFile() {
		return tempFile;
	}

	public void setTempFile(File tempFile) {
		tempFile.deleteOnExit();
		this.tempFile = tempFile;
	}

	protected void writeExcel(ArrayList<SLTMatrixAnalysis> sltmList) throws IOException, ServletException, SQLException {
		Workbook workbook = getWorkbook("slt-matrix.xlsx");
		Sheet sheet = workbook.createSheet();

		int rowCount = 0;

		Row row = sheet.createRow(0);
		Cell head1 = row.createCell(1);
		head1.setCellValue("BIL");
		Cell head2 = row.createCell(2);
		head2.setCellValue("KOD KURSUS");
		Cell head3 = row.createCell(3);
		head3.setCellValue("NAMA KURSUS");
		head3.setCellStyle(null);
		Cell head4 = row.createCell(4);
		head4.setCellValue("KREDIT");

		// slt
		Cell head5 = row.createCell(5);
		head5.setCellValue("PHYSICAL (LECTURE)");
		Cell head6 = row.createCell(6);
		head6.setCellValue("PHYSICAL (TUTORIAL)");
		Cell head7 = row.createCell(7);
		head7.setCellValue("PHYSICAL (PRACTICAL)");
		Cell head8 = row.createCell(8);
		head8.setCellValue("PHYSICAL (OTHERS)");
		Cell head9 = row.createCell(9);
		head9.setCellValue("ONLINE (LECTURE)");
		Cell head10 = row.createCell(10);
		head10.setCellValue("ONLINE (TUTORIAL)");
		Cell head11 = row.createCell(11);
		head11.setCellValue("ONLINE (PRACTICAL)");
		Cell head12 = row.createCell(12);
		head12.setCellValue("ONLINE (OTHERS)");
		Cell head13 = row.createCell(13);
		head13.setCellValue("NON F2F");

		// asst

		Cell head14 = row.createCell(14);
		head14.setCellValue("CONTINOUS ASSESSMENT (PHYSICAL)");
		Cell head15 = row.createCell(15);
		head15.setCellValue("CONTINOUS ASSESSMENT (ONLINE)");
		Cell head16 = row.createCell(16);
		head16.setCellValue("CONTINOUS ASSESSMENT (NF2F)");
		Cell head17 = row.createCell(17);
		head17.setCellValue("FINAL ASSESSMENT (PHYSICAL)");
		Cell head18 = row.createCell(18);
		head18.setCellValue("FINAL ASSESSMENT (ONLINE)");
		Cell head19 = row.createCell(19);
		head19.setCellValue("FINAL ASSESSMENT (NF2F)");
		Cell head20 = row.createCell(20);
		head20.setCellValue("TOTAL STUDENT LEARNING TIME");

		int i = 1;
		for (SLTMatrixAnalysis sltm : sltmList) {
			row = sheet.createRow(++rowCount);
			writeBook(sltm, row, i);
			i++;
		}

		File tempFile = File.createTempFile("slt-matrix", ".xlsx");
		System.out.println("Temp file : " + tempFile);

		FileOutputStream faos = new FileOutputStream(tempFile);
		workbook.write(faos);
		faos.close();
		setTempFile(tempFile);
	}

	protected void writeBook(SLTMatrixAnalysis sltm, Row row, int num) {

		Cell cell = row.createCell(1);
		cell.setCellValue(num + ".");

		Cell cell2 = row.createCell(2);
		cell2.setCellValue(sltm.getCourseCode());
		
		Cell cell3 = row.createCell(3);
		cell3.setCellValue(sltm.getCourseName());
		
		Cell cell4 = row.createCell(4);
		cell4.setCellValue(sltm.getTotalPlhour());
		
		Cell cell5 = row.createCell(5);
		cell5.setCellValue(sltm.getTotalPthour());
		
		Cell cell6 = row.createCell(6);
		cell6.setCellValue(sltm.getTotalPphour());
		
		Cell cell7 = row.createCell(7);
		cell7.setCellValue(sltm.getTotalPohour());
		
		Cell cell8 = row.createCell(8);
		cell8.setCellValue(sltm.getTotalOlhour());
		
		Cell cell9 = row.createCell(9);
		cell9.setCellValue(sltm.getTotalOthour());
		
		Cell cell10 = row.createCell(10);
		cell10.setCellValue(sltm.getTotalOphour());

		Cell cell11 = row.createCell(11);
		cell11.setCellValue(sltm.getTotalOohour());
		
		Cell cell12 = row.createCell(12);
		cell12.setCellValue(sltm.getTotalTosletNf2fhour());
		
		Cell cell13 = row.createCell(13);
		cell13.setCellValue(sltm.getCasPhour());
		
		Cell cell14 = row.createCell(14);
		cell14.setCellValue(sltm.getCasOhour());
		
		Cell cell15 = row.createCell(15);
		cell15.setCellValue(sltm.getCasNf2fhour());
		
		Cell cell16 = row.createCell(16);
		cell16.setCellValue(sltm.getFasPhour());
		
		Cell cell17 = row.createCell(17);
		cell17.setCellValue(sltm.getFasOhour());
		
		Cell cell18 = row.createCell(18);
		cell18.setCellValue(sltm.getFasNf2fhour());
		
		Cell cell19 = row.createCell(19);
		cell19.setCellValue(sltm.getCourseSLTGrandTotal());
		
	
	
	}

	protected Workbook getWorkbook(String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

}
