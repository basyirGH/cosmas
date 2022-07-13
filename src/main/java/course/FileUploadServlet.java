package course;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Servlet implementation class FileParsingServlet
 */
@WebServlet("/uploader")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIRECTION1 = "right";
	private static final String DIRECTION2 = "left";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("test receive at commanded method");
		final String UPLOAD_DIRECTORY = "uploads2";

		final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
		final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
		final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("test receive at ismultipart content");
			PrintWriter writer = response.getWriter();
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);

		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		System.out.println(uploadPath);

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
			System.out.println(uploadPath);
		}

		try {
			System.out.println(uploadPath);
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) {
				System.out.println("OKKK");
				if (item.isFormField()) {
					// Process regular form field (input type="text|radio|checkbox|etc", select,
					// etc).
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();

				} else {
					// Process form file field (input type="file").
					String fieldName = item.getFieldName();
					String fileName = FilenameUtils.getName(item.getName());
					InputStream fileContent = item.getInputStream();
					Course course = parseSimpleAdjacents(fileContent);
					String fileSize = FileUtils.byteCountToDisplaySize(item.getSize());

					request.getSession().setAttribute("message",
							"Upload has been done successfully! <br>" + fileName + "<br>" + fileSize + "<br>");
					request.getSession().setAttribute("course", course);
				}
			}
		} catch (Exception e) {
			throw new ServletException("Cannot parse multipart request.", e);
		}

		String fromCommand = request.getParameter("fromCommand");
		String courseCodeOld = request.getParameter("courseCodeOld");

		if (courseCodeOld.equals("") || courseCodeOld.equals(null)) {
			request.getRequestDispatcher("/post-extraction-add-course.jsp").forward(request, response);
		} else if (!courseCodeOld.equals("") || !courseCodeOld.equals(null)) {
			request.getRequestDispatcher("/post-extraction-add-course.jsp").forward(request, response);
		}

//        if (fromCommand.equals("addCourse")) {
//        	request.getRequestDispatcher("/excel-upload-true-add-course.jsp").forward(request, response);
//        }
//        else if (fromCommand.equals("saveEdit")) {
//        	request.getRequestDispatcher("/excel-upload-true-edit-course.jsp").forward(request, response);
//        }
//        else {
//        	request.getRequestDispatcher("/excel-upload-true-edit-course.jsp").forward(request, response);
//        }
	}

	// below are methods for parsing course data part by part.
	// first method is for parsing attributes that have values in cells adjacent to
	// the attribute cell.

	protected String traverseSequentialCells(String desiredCellValue, String separator, String attribute, int a,
			Row row, String direction) {

		int cellIndexRightTreshold = 26;
		int cellIndexLeftTreshold = 0;
		Cell cell = null;
		String value = null;
		String result = "";

		if (direction.equals("right")) {
			for (int i = a; i < cellIndexRightTreshold; i++) {
				try {
					cell = row.getCell(i);
					value = cell.getStringCellValue();
				} catch (java.lang.IllegalStateException ex) {
					value = String.valueOf(cell.getNumericCellValue());
				} catch (java.lang.NullPointerException ex) {
					continue;
				}

				if ((cell != null && !value.equals(attribute) && !value.equals(""))) {
					System.out.println("test excel extraction -- found value: " + value);
					result = result.concat(value + separator);

				} else if ((cell != null && !value.equals(attribute) && value.equals(""))
						&& desiredCellValue.equals("0")) {

					System.out.println("test excel extraction -- found value: " + value);
					result = result.concat(desiredCellValue + separator);

				} else {
					System.out.println("test excel extraction -- no " + attribute + " value found at cell " + i
							+ ". continuing...");
				}
			}
		} else if (direction.equals("left")) {
			for (int i = a; i > cellIndexLeftTreshold; i--) {
				try {
					cell = row.getCell(i);
					value = cell.getStringCellValue();
				} catch (java.lang.IllegalStateException ex) {
					value = String.valueOf(cell.getNumericCellValue());
				} catch (java.lang.NullPointerException ex) {
					continue;
				}

				if (cell != null && !value.equals(attribute) && !value.equals("")) {
					System.out.println("test excel extraction -- found value: " + value);
					result = result.concat(value + separator);
				} else {
					System.out.println("test excel extraction -- no " + attribute + " value found at cell " + i
							+ ". continuing...");
				}
			}
		}
		return result;
	}

	protected String traverseListedCells(String numbering[], String attribute, int a, Row row) {

		int cellIndexTreshold = 26;
		Cell cell = null;
		String value = null;
		String result = "Data unavailable";

		for (int i = a; i < cellIndexTreshold; i++) {
			try {
				cell = row.getCell(i);
				value = cell.getStringCellValue();
			} catch (java.lang.IllegalStateException ex) {
				value = String.valueOf(cell.getNumericCellValue());
			} catch (java.lang.NullPointerException ex) {
				continue;
			}

			if (cell != null && !value.equals(attribute) && !value.equals("")) {

				if (value.equals(numbering[0]) || value.equals(numbering[1]) || value.equals(numbering[2])) {

					try {
						cell = row.getCell(i + 1);
						value = cell.getStringCellValue();
					} catch (java.lang.IllegalStateException ex) {
						value = String.valueOf(cell.getNumericCellValue());
					} catch (java.lang.NullPointerException ex) {
						continue;
					}

					value = traverseSimpleHorizCells(attribute, i + 1, row, DIRECTION1);
					result = value;
					break;
				}
			} else {
				System.out.println(
						"test excel extraction -- no " + attribute + " value found at cell " + i + ". continuing...");
			}
		}
		return result;
	}

	protected String traverseSimpleHorizCells(String attribute, int a, Row row, String direction) {

		int cellIndexRightTreshold = 26;
		int cellIndexLeftTreshold = 0;
		Cell cell = null;
		String value = null;
		String result = "Data unavailable";

		if (direction.equals("right")) {
			for (int i = a; i < cellIndexRightTreshold; i++) {
				try {
					cell = row.getCell(i);
					value = cell.getStringCellValue();
				} catch (java.lang.IllegalStateException ex) {
					value = String.valueOf(cell.getNumericCellValue());
				} catch (java.lang.NullPointerException ex) {
					continue;
				}

				if (cell != null && !value.equals(attribute) && !value.equals("")) {
					System.out.println("test excel extraction -- found value: " + value);
					result = value;
					break;
				} else {
					System.out.println("test excel extraction -- no " + attribute + " value found at cell " + i
							+ ". continuing...");
				}
			}
		} else if (direction.equals("left")) {
			for (int i = a; i > cellIndexLeftTreshold; i--) {
				try {
					cell = row.getCell(i);
					value = cell.getStringCellValue();
				} catch (java.lang.IllegalStateException ex) {
					value = String.valueOf(cell.getNumericCellValue());
				} catch (java.lang.NullPointerException ex) {
					continue;
				}

				if (cell != null && !value.equals(attribute) && !value.equals("")) {
					System.out.println("test excel extraction -- found value: " + value);
					result = value;
					break;
				} else {
					System.out.println("test excel extraction -- no " + attribute + " value found at cell " + i
							+ ". continuing...");
				}
			}
		}

		return result;
	}

	protected Course parseSimpleAdjacents(InputStream fileContent) throws SQLException, ServletException, IOException {

		Course course = new Course();
		Workbook wb = null;
		Row row = null;
		Cell cell = null;
		String value = null;
		int sheetIndexTreshold = 5;
		String numbering[] = {};
		int globalRowTreshold = 100;

		try {
			wb = new XSSFWorkbook(fileContent);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (int s = 0; s < sheetIndexTreshold; s++) {

			Sheet sheet = null;
			try {
				sheet = wb.getSheetAt(s);
			} catch (IllegalArgumentException e) {
				break;
			}

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				Row traversalRow = null;
				Row subrow1 = null;
				Row subrow2 = null;
				Row subrow3 = null;

				int a = 0;

				for (int j = 0; j < 30; j++) {
					cell = row.getCell(j);

					try {
						value = cell.getStringCellValue();
					} catch (java.lang.IllegalStateException ex) {
						value = String.valueOf(cell.getNumericCellValue());
					} catch (java.lang.NullPointerException ex) {
						continue;
					}

					if (value.contains("Course Name:")) {
						a = j + 1;
						course.setCourseName(traverseSimpleHorizCells("Course Name:", a, row, DIRECTION1));
					}

					else if (value.contains("Course Code:")) {
						a = j + 1;
						course.setCourseCode(traverseSimpleHorizCells("Course Code:", a, row, DIRECTION1));

					}

					else if (value.contains("Course Classification:")) {
						a = j + 1;
						course.setCourseClassification(
								traverseSimpleHorizCells("Course Classification:", a, row, DIRECTION1));
					}

					else if (value.contains("Synopsis:")) {
						a = j + 1;
						course.setCourseSynopsis(traverseSimpleHorizCells("Synopsis:", a, row, DIRECTION1));
					}

					else if (value.contains("Name(s) of Academic Staff:")) {

						a = j + 1;
						numbering = new String[] { "1.0", "2.0", "3.0" };
						String acadStaffs = "1) ";
						subrow1 = row;
						subrow2 = sheet.getRow(i + 1);
						subrow3 = sheet.getRow(i + 2);
						acadStaffs = acadStaffs
								.concat(traverseListedCells(numbering, "Name(s) of Academic Staff:", a, subrow1));
						acadStaffs = acadStaffs.concat(
								"\n2) " + traverseListedCells(numbering, "Name(s) of Academic Staff:", a, subrow2));
						acadStaffs = acadStaffs.concat(
								"\n3) " + traverseListedCells(numbering, "Name(s) of Academic Staff:", a, subrow3));
						course.setCourseAcadStaff(acadStaffs);
					}

					else if (value.contains("Semester and Year offered:")) {
						a = j + 1;
						course.setCourseSemYearOffered(
								traverseSequentialCells("", "|", "Semester and Year offered:", a, row, DIRECTION1));
					}

					else if (value.contains("Credit Value:")) {
						a = j + 1;
						course.setCourseCredit(traverseSimpleHorizCells("Credit Value:", a, row, DIRECTION1));
					}

					else if (value.contains("Pre-requisite/ co-requisite (if any):")) {
						a = j + 1;
						course.setCoursePrerequisite(
								traverseSimpleHorizCells("Pre-requisite/ co-requisite (if any):", a, row, DIRECTION1));
					}

					else if (value.contains("Course Learning Outcomes (CLO)")) {

						a = j + 1;
						numbering = new String[] { "CLO1", "CLO2", "CLO3" };
						String clos = "CLO1) ";
						subrow1 = row;
						subrow2 = sheet.getRow(i + 1);
						subrow3 = sheet.getRow(i + 2);
						clos = clos
								.concat(traverseListedCells(numbering, "Course Learning Outcomes (CLO)", a, subrow1));
						clos = clos.concat("\nCLO2) "
								+ traverseListedCells(numbering, "Course Learning Outcomes (CLO)", a, subrow2));
						clos = clos.concat("\nCLO3) "
								+ traverseListedCells(numbering, "Course Learning Outcomes (CLO)", a, subrow3));
						course.setCourseLearningOutcomes(clos);
					}

					else if (value
							.contains("Mapping of the Course Learning Outcomes to the Programme Learning Outcomes, "
									+ "Teaching Methods and Assessment Methods")) {

						a = j + 2;
						int colStart = a;
						int colEnd = colStart + 10;

						String attribute = "Mapping of the Course Learning Outcomes to the Programme Learning Outcomes, "
								+ "Teaching Methods and Assessment Methods";
						String mapping = "";
						ArrayList<String> cloplomapping = new ArrayList<String>();
						Row subrow;

						String currentClo = "";
						String currentPlo = "";

						int rowStart = 3;
						int rowEnd = 5;
						int currentTickRowIndex = 0;
						for (int b = rowStart; b <= rowEnd; b++) {

							currentTickRowIndex = i + b;
							subrow = sheet.getRow(currentTickRowIndex);
							for (int c = colStart; c <= colEnd; c++) {

								cell = subrow.getCell(c);
								try {
									value = cell.getStringCellValue();
								} catch (java.lang.IllegalStateException ex) {
									value = String.valueOf(cell.getNumericCellValue());
								} catch (java.lang.NullPointerException ex) {
									continue;
								}

								if (value.equals("?") || value.equals("\u221A") || value.equals("/")) {

									// traverse up implem.

									int rowUpIndexTreshold = currentTickRowIndex + 4;

									for (int d = currentTickRowIndex + 1; d <= rowUpIndexTreshold; d++) {
										traversalRow = sheet.getRow(d);
										cell = traversalRow.getCell(c);

										try {
											value = cell.getStringCellValue();
										} catch (java.lang.IllegalStateException ex) {
											value = String.valueOf(cell.getNumericCellValue());
										} catch (java.lang.NullPointerException ex) {
											continue;
										}

										if (cell != null && !value.equals("")) {
											currentPlo = value;
											break;
										}
									}
									currentClo = currentClo.concat(traverseSequentialCells("", ",", attribute,
											colStart - 1, subrow, DIRECTION2));
								}
							}
						}

						// course.setCourseDatesApproval(currentClo + currentPlo);

					} else if (value.contains("Distribution of Student Learning Time (SLT)")) {

						a = 0;
						String strToslet = "";
						ArrayList<String> strTosletList = new ArrayList<String>();
						ArrayList<TopicAndSLT> tosletList = new ArrayList<TopicAndSLT>();
						String tosletElements[] = {};

						for (int b = i + 5; b < (i + 25); b++) {

							traversalRow = sheet.getRow(b);
							strToslet = traverseSequentialCells("0", "|", "Distribution of Student Learning Time (SLT)",
									a, traversalRow, DIRECTION1);
							strTosletList.add(strToslet);

						}

						for (String e : strTosletList) {

							TopicAndSLT toslet = new TopicAndSLT();
							tosletElements = e.split("\\|");

							if (!tosletElements[1].equals("0")) {

								toslet.setOutline(tosletElements[1]);
								toslet.setClo(tosletElements[2]);
								toslet.setPlhour((int) Math.round(Double.valueOf(tosletElements[3])));
								toslet.setPthour((int) Math.round(Double.valueOf(tosletElements[4])));
								toslet.setPphour((int) Math.round(Double.valueOf(tosletElements[5])));
								toslet.setPohour((int) Math.round(Double.valueOf(tosletElements[6])));
								toslet.setOlhour((int) Math.round(Double.valueOf(tosletElements[7])));
								toslet.setOthour((int) Math.round(Double.valueOf(tosletElements[8])));
								toslet.setOphour((int) Math.round(Double.valueOf(tosletElements[9])));
								toslet.setOohour((int) Math.round(Double.valueOf(tosletElements[10])));
								toslet.setNf2fhour((int) Math.round(Double.valueOf(tosletElements[11])));
								toslet.setTsltId(getNewId("toslet-", 7));
								tosletList.add(toslet);
							} else {
								break;
							}
						}

						course.setCourseSLTDist2(tosletList);

					} else if (value.contains("Continous Assessment")) {

						System.out.println("found attribute ca asst.current row is " + i);
						a = 0;
						String strCaslet = "";
						ArrayList<String> strCasletList = new ArrayList<String>();
						ArrayList<CASAndSLT> casletList = new ArrayList<CASAndSLT>();
						String casletElements[] = {};

						for (int b = i + 2; b < (i + 7); b++) {

							System.out.println("traversing ca rows...current row: " + b);
							traversalRow = sheet.getRow(b);
							strCaslet = traverseSequentialCells("0", "|", "Continous Assessment", a, traversalRow,
									DIRECTION1);
							strCasletList.add(strCaslet);

						}

						for (String e : strCasletList) {

							CASAndSLT caslet = new CASAndSLT();
							casletElements = e.split("\\|");

							if (!casletElements[1].equals("0")) {

								caslet.setAsst(casletElements[1]);
								caslet.setWeightage(casletElements[2]);
								caslet.setPhour(casletElements[3]);
								caslet.setOhour(casletElements[4]);
								caslet.setNf2fhour(casletElements[11]);
								caslet.setAsstId(getNewId("caslet-", 7));
								casletList.add(caslet);
							} else {
								break;
							}
						}

						System.out.println("Caslet list test: " + Arrays.toString(casletElements));
						course.setCourseCasletDist(casletList);
						
					} else if (value.contains("Final Assessment")) {

						System.out.println("found attribute fa asst.current row is " + i);
						a = 0;
						String strFaslet = "";
						ArrayList<String> strFasletList = new ArrayList<String>();
						ArrayList<FASAndSLT> fasletList = new ArrayList<FASAndSLT>();
						String fasletElements[] = {};

						for (int b = i + 2; b < (i + 7); b++) {

							System.out.println("traversing fa rows...current row: " + b);
							traversalRow = sheet.getRow(b);
							strFaslet = traverseSequentialCells("0", "|", "Final Assessment", a, traversalRow,
									DIRECTION1);
							strFasletList.add(strFaslet);

						}

						for (String e : strFasletList) {

							FASAndSLT faslet = new FASAndSLT();
							fasletElements = e.split("\\|");

							if (!fasletElements[1].equals("0")) {

								faslet.setAsst(fasletElements[1]);
								faslet.setWeightage(fasletElements[2]);
								faslet.setPhour(fasletElements[3]);
								faslet.setOhour(fasletElements[4]);
								faslet.setNf2fhour(fasletElements[11]);
								faslet.setAsstId(getNewId("faslet-", 7));
								fasletList.add(faslet);
							} else {
								break;
							}
						}
						System.out.println("Caslet list test: " + Arrays.toString(fasletElements));
						course.setCourseFasletDist(fasletList);
						
					} else if (value.contains("Identify special requirement or resources to deliver the course "
							+ "(e.g., software, nursery, computer lab, simulation room etc)")) {
						a = j + 1;
						course.setCourseSpecialReq(traverseSimpleHorizCells("Identify special requirement or "
								+ "resources to deliver the course (e.g., software, nursery, computer lab, simulation room etc)",
								a, row, DIRECTION1));

					} else if (value.contains(
							"References (include required and further readings, and should be the most current)")) {
						a = j + 1;
						course.setCourseReferences(traverseSimpleHorizCells(
								"References (include required and further readings, and should be the most current)", a,
								row, DIRECTION1));
					}

					else if (value.contains("Other additional information (if applicable)")) {
						a = j + 1;
//						course.setCourseOtherInfo(
//								traverseSimpleHorizCells("Other additional information (if applicable)", a, row));
					}

					else {
						System.out.println("");
					}
				}
			}
		}
		return course;
	}

	protected boolean idIsTaken(String id) throws SQLException, ServletException, IOException {

		DAO dao = new DAO();
		List<String> tosletIdList = dao.getAllTsltId();
		DAO dao2 = new DAO();
		List<String> casletIdList = dao2.getAllCasletId();
		DAO dao3 = new DAO();
		List<String> fasLetIdList = dao3.getAllFasletId();

		for (String e : casletIdList) {
			if (e.equals(id)) {
				return true;
			}
		}

		for (String e : tosletIdList) {
			if (e.equals(id)) {
				return true;
			}
		}

		for (String e : fasLetIdList) {
			if (e.equals(id)) {
				return true;
			}
		}

		return false;

	}

	protected String generateRandom(int n) {
		String NumericString = "0123456789";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (NumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(NumericString.charAt(index));
		}

		return sb.toString();
	}

	protected String getNewId(String prefix, int n) throws SQLException, ServletException, IOException {

		String id = prefix.concat(generateRandom(n));

		while (idIsTaken(id)) {
			id = id.concat(generateRandom(n));
		}

		return id;

	}

//	protected void parseSimpleAdjacents(Course course) {

//	}
//	

}