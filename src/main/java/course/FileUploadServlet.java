package course;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
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
  
import attribute.Attribute;

/**
 * Servlet implementation class FileParsingServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("test receive at commanded method");
        final String UPLOAD_DIRECTORY = "uploads2";
        
        final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
        final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
        final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
        
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
 
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;
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
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    
                } else {
                    // Process form file field (input type="file").
                    String fieldName = item.getFieldName();
                    String fileName = FilenameUtils.getName(item.getName());
                    InputStream fileContent = item.getInputStream();
                    Course course = parseSimpleAdjacents(fileContent);
                    String fileSize = FileUtils.byteCountToDisplaySize(item.getSize());
                    
                    request.getSession().setAttribute("message", "Upload has been done successfully! <br>" + fileName + "<br>" + 
                    fileSize + "<br>");
                    request.getSession().setAttribute("course", course);
                }
            }
        } catch (Exception e) {
            throw new ServletException("Cannot parse multipart request.", e);
        }
        
        String fromCommand = request.getParameter("fromCommand");
        String courseCodeOld = request.getParameter("courseCodeOld");
        
        if (courseCodeOld.equals("") || courseCodeOld.equals(null)) {
        	request.getRequestDispatcher("/excel-upload-true-add-course.jsp").forward(request, response);
        }
        else if (!courseCodeOld.equals("") || !courseCodeOld.equals(null)) {
            request.getRequestDispatcher("/excel-upload-true-edit-course.jsp?courseCodeOld=" + courseCodeOld).forward(request, response);
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
	
	//below are methods for parsing course data part by part.
	//first method is for parsing attributes that have values in cells adjacent to
	//the attribute cell.
	protected Course parseSimpleAdjacents(InputStream fileContent) {
		
		Course course = new Course();
		Workbook wb = null;
		Row row = null;
		Cell cell = null;
		String value = null;
		Attribute attributeObj = new Attribute();
		ArrayList<String> predefinedAttributes = attributeObj.getPredefinedAttributes();
		
		try {
			wb = new XSSFWorkbook(fileContent);
		}
		catch(FileNotFoundException e)  {
			e.printStackTrace();  
		}  
		catch(IOException e1)  {
			e1.printStackTrace();  
		} 
	
		Sheet sheet = wb.getSheetAt(0);
		
		for (int i=0; i<sheet.getLastRowNum(); i++) {
		row = sheet.getRow(i);
		
		for (int j=0; j<30; j++) {
			cell = row.getCell(j);
			
			try {
				value = cell.getStringCellValue();
			}
			catch (java.lang.IllegalStateException ex) {
				value = String.valueOf(cell.getNumericCellValue());
			}
			catch (java.lang.NullPointerException ex) {
				continue;
			}
			
			for (String e : predefinedAttributes) {
				
				if (value.equals(e)) {
					
					switch(e) {
					
						case "Course Name:" :
							cell = row.getCell(j+3);
							value = cell.getStringCellValue();
							course.setCourseName(value);
							break;
						
						case "Course Code:" :
							cell = row.getCell(j+3);
							value = cell.getStringCellValue();
							course.setCourseCode(value);
							break;
						
						case "Course Classification:" :
							cell = row.getCell(j+3);
							value = cell.getStringCellValue();
							course.setCourseClassification(value);
							break;
							
						case "Synopsis:" :
							cell = row.getCell(j+3);
							value = cell.getStringCellValue();
							course.setCourseSynopsis(value);
							break;
							
						case "Name(s) of Academic Staff:" :
							value = "";
							
							for (int k=i; k < (i+3); k++) {
								row = sheet.getRow(k);
								cell = row.getCell(j+4);
								value += cell.getStringCellValue() + "\n";
							}
							course.setCourseAcadStaff(value);
							break;
							
						case "Semester and Year offered:" :
							value = "";
							
							for (int k=j+3; k < (j+10); k++) {
								cell = row.getCell(k);
								
								try {
									value += cell.getStringCellValue() + " ";
								}
								catch (java.lang.IllegalStateException ex) {
									value += ": " + String.format("%.0f", cell.getNumericCellValue()) + "; \n ";
									continue;
								}
								catch (java.lang.NullPointerException ex) {
									continue;
								}
							}
							course.setCourseSemYearOffered(value);
							break;
						
						case "Credit Value:" :
							cell = row.getCell(j+3);
							value = String.valueOf(cell.getNumericCellValue());
							course.setCourseCredit(value);
							break;
							
						case "Pre-requisite/ co-requisite (if any):" :
							cell = row.getCell(j+3);
							value = cell.getStringCellValue();
							course.setCoursePrerequisite(value);
							break;
							
						case "Course Learning Outcomes (CLO)" :
							value = "";
							
							for (int k=i; k < (i+3); k++) {
								row = sheet.getRow(k);
								cell = row.getCell(j+5);
								value += cell.getStringCellValue() + "\n";
							}
							course.setCourseLearningOutcomes(value);
							break;
							
						case "Identify special requirement or resources to deliver the course "
								+ "(e.g., software, nursery, computer lab, simulation room etc)" :
							cell = row.getCell(j+8);
							value = cell.getStringCellValue();
							course.setCourseSpecialReq(value);
							break;
							
						case "References (include required and further readings, and should be the most current)" :
							cell = row.getCell(j+8);
							value = cell.getStringCellValue();
							course.setCourseReferences(value);
							break;
							
						case "Other additional information (if applicable)" :
							cell = row.getCell(j+8);
							value = cell.getStringCellValue();
							course.setCourseOtherInfo(value);
							break;
							
						default :
							System.out.println("");
				
					}
				}
			}
		}
	}
		
		return course;
	}
	
//	protected void parseSimpleAdjacents(Course course) {

//	}
//	
	
	
	
		
		
		

}
