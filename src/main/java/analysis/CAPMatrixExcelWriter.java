package analysis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import course.Course;

/**
 * A flexible program that writes data to an Excel file in either XLSX or XLS
 * format, depending on the extension of the file.
 * 
 * @author www.codejava.net modified by Mohamad Basyir bin Zainuddin
 *
 */
public class CAPMatrixExcelWriter {
	
	private File tempFile;
	
	public File getTempFile() {
		return tempFile;
	}

	public void setTempFile(File tempFile) {
		tempFile.deleteOnExit();
		this.tempFile = tempFile;
	}

	protected void writeExcel(ArrayList<CourseAndPLOAnalysis> capList) throws IOException, ServletException, SQLException {
		Workbook workbook = getWorkbook("cap-matrix.xlsx");
		Sheet sheet = workbook.createSheet();

		int rowCount = 7;

		Row row = sheet.createRow(7);
		Cell head1 = row.createCell(1);
		head1.setCellValue("BIL");
		Cell head2 = row.createCell(2);
		head2.setCellValue("KOD KURSUS");
		Cell head3 = row.createCell(3);
		head3.setCellValue("NAMA KURSUS");
		head3.setCellStyle(null);
		Cell head4 = row.createCell(4);
		head4.setCellValue("KREDIT");

		for (int i = 5; i < 16; i++) {

			Cell ploHead = row.createCell(i);
			ploHead.setCellValue("PLO" + (i - 4));
		}

		int i = 1;
		for (CourseAndPLOAnalysis cap : capList) {
			row = sheet.createRow(++rowCount);
			writeBook(cap, row, i);
			i++;
		}
		File tempFile = File.createTempFile("cap-matrix", ".xlsx");
		System.out.println("Temp file : " + tempFile);

		FileOutputStream faos = new FileOutputStream(tempFile);
		workbook.write(faos);
		faos.close();
		setTempFile(tempFile);
	}

	protected void writeBook(CourseAndPLOAnalysis cap, Row row, int num) {
		Cell cell = row.createCell(1);
		cell.setCellValue(num + ".");

		cell = row.createCell(2);
		cell.setCellValue(cap.getCourseCode());

		cell = row.createCell(3);
		cell.setCellValue(cap.getCourseName());

		cell = row.createCell(4);
		cell.setCellValue(cap.getCourseCredit());

		cell = row.createCell(5);
		cell.setCellValue(cap.getPlo1());

		cell = row.createCell(6);
		cell.setCellValue(cap.getPlo2());

		cell = row.createCell(7);
		cell.setCellValue(cap.getPlo3());

		cell = row.createCell(8);
		cell.setCellValue(cap.getPlo4());

		cell = row.createCell(9);
		cell.setCellValue(cap.getPlo5());

		cell = row.createCell(10);
		cell.setCellValue(cap.getPlo6());

		cell = row.createCell(11);
		cell.setCellValue(cap.getPlo7());

		cell = row.createCell(12);
		cell.setCellValue(cap.getPlo8());

		cell = row.createCell(13);
		cell.setCellValue(cap.getPlo9());

		cell = row.createCell(14);
		cell.setCellValue(cap.getPlo10());

		cell = row.createCell(15);
		cell.setCellValue(cap.getPlo11());
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
