/*
 * Controller
 * 
 * v1.0
 * 
 * Author: Basyir Zainuddin
 * 
 * Purpose: This Java Source File delegates user input (in the HTTP request object) 
 * from an HTML form to handler methods as specified.
 */

package analysis;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Paint;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import analysis.DAO;
import course.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/analysis")
@MultipartConfig

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int ARBITARY_SIZE = 1048;

	public Controller() {
		super();
	}

	protected void doCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String serverInfo = request.getSession().getServletContext().getServerInfo();
		System.out.println("Server Info" + serverInfo);
		String servletInfo = request.getSession().getServletContext().getMajorVersion() + "."
				+ request.getSession().getServletContext().getMinorVersion();
		System.out.println("Servlet Info" + servletInfo);

		String analysisType = request.getParameter("type");
		if (analysisType != null) {
			try {
				switch (analysisType) {
				case "cap-matrix":
					getCAPMatrixView(request, response);
					break;
				case "download-cap-matrix":
					downloadCAPMatrix(request, response);
					break;
				case "slt-matrix":
					getSltMatrixView(request, response);
					break;
				case "download-slt-matrix":
					downloadSltMatrix(request, response);
					break;
				case "plo-count-chart":
					getPLOCountView(request, response);
					break;
				case "toslet-chart":
					getTosletChartView(request, response);
				}

			} catch (SQLException e) {
				throw new SQLException(e);
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println(
						"Method invoked by command below returned null.\n If there is no command, please make sure you've logged in."
								+ "\ncommand: " + analysisType);
			}
		}
	}

	protected ArrayList<SLTMatrixAnalysis> getSltmList() throws IOException, SQLException {

		ArrayList<SLTMatrixAnalysis> sltmList = new ArrayList<SLTMatrixAnalysis>();
		DAO dao = new DAO();

		List<Course> courseList = dao.getCourses();

		for (Course course : courseList) {

			ArrayList<TopicAndSLT> tosletList = course.getCourseSLTDist2();
			ArrayList<CASAndSLT> casletList = course.getCourseCasletDist();
			ArrayList<FASAndSLT> fasletList = course.getCourseFasletDist();

			int totalPlhour = 0;
			int totalPthour = 0;
			int totalPphour = 0;
			int totalPohour = 0;
			int totalOlhour = 0;
			int totalOthour = 0;
			int totalOphour = 0;
			int totalOohour = 0;
			int totalTosletNf2fhour = 0;
			int casPhour = 0;
			int casOhour = 0;
			int casNf2fhour = 0;
			int fasPhour = 0;
			int fasOhour = 0;
			int fasNf2fhour = 0;
			int courseSLTGrandTotal = 0;

			SLTMatrixAnalysis sltm = new SLTMatrixAnalysis();

			for (TopicAndSLT toslet : tosletList) {
				try {
					totalPlhour = totalPlhour + toslet.getPlhour();
					totalPthour = totalPthour + toslet.getPlhour();
					totalPphour = totalPphour + toslet.getPlhour();
					totalPohour = totalPohour + toslet.getPlhour();
					totalOlhour = totalOlhour + toslet.getPlhour();
					totalOthour = totalOthour + toslet.getPlhour();
					totalOphour = totalOphour + toslet.getPlhour();
					totalOohour = totalOohour + toslet.getPlhour();
					totalTosletNf2fhour = totalTosletNf2fhour + toslet.getPlhour();
				} catch (NumberFormatException e) {
					continue;
				}

			}

			for (CASAndSLT caslet : casletList) {
				try {
					casPhour = casPhour + (int) Math.round(Double.valueOf(caslet.getPhour()));
					casOhour = casOhour + (int) Math.round(Double.valueOf(caslet.getOhour()));
					casNf2fhour = casNf2fhour + (int) Math.round(Double.valueOf(caslet.getNf2fhour()));
				} catch (NumberFormatException e) {
					continue;
				}
			}

			for (FASAndSLT faslet : fasletList) {
				try {
					fasPhour = fasPhour + (int) Math.round(Double.valueOf(faslet.getPhour()));
					fasOhour = fasOhour + (int) Math.round(Double.valueOf(faslet.getOhour()));
					fasNf2fhour = fasNf2fhour + (int) Math.round(Double.valueOf(faslet.getNf2fhour()));
				} catch (NumberFormatException e) {
					continue;
				}
			}

			sltm.setCourseCode(course.getCourseCode());
			sltm.setCourseName(course.getCourseName());
			sltm.setCourseCredit(course.getCourseCredit());

			sltm.setTotalPlhour(totalPlhour);
			sltm.setTotalPthour(totalPthour);
			sltm.setTotalPphour(totalPphour);
			sltm.setTotalPohour(totalPohour);
			sltm.setTotalOlhour(totalOlhour);
			sltm.setTotalOthour(totalOthour);
			sltm.setTotalOphour(totalOphour);
			sltm.setTotalOohour(totalOohour);
			sltm.setTotalTosletNf2fhour(totalTosletNf2fhour);
			sltm.setCasPhour(casPhour);
			sltm.setCasOhour(casOhour);
			sltm.setCasNf2fhour(casNf2fhour);
			sltm.setFasPhour(fasPhour);
			sltm.setFasOhour(fasOhour);
			sltm.setFasNf2fhour(fasNf2fhour);

			courseSLTGrandTotal = totalPlhour + totalPthour + totalPphour + totalPohour + totalOlhour + totalOthour
					+ totalOphour + totalOohour + totalTosletNf2fhour + casPhour + casOhour + casNf2fhour + fasPhour
					+ fasOhour + fasNf2fhour;

			sltm.setCourseSLTGrandTotal(courseSLTGrandTotal);
			sltmList.add(sltm);

		}
		return sltmList;
	}

	protected void getSltMatrixView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		SLTMatrixExcelWriter ew = new SLTMatrixExcelWriter();
		ew.writeExcel(getSltmList());
		request.getSession().setAttribute("sltmList", null);
		RequestDispatcher rd = request.getRequestDispatcher("slt-matrix.jsp");
		rd.forward(request, response);

	}

	protected void getTosletChartView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		// String courseCode = request.getParameter("test05");
		DAO dao = new DAO();
		String courseCode = request.getParameter("courseCode");
		TopicAndSLTAnalysis analysis = dao.getSLTByMode(courseCode);

		course.DAO dao2 = new course.DAO();
		Course course = dao2.getCourse(courseCode);
		String courseName = course.getCourseName();

		String topics = analysis.getTopics().stream().collect(Collectors.joining("','", "'", "'"));
		ArrayList<String> topicNumbers = new ArrayList<String>();
		String currentTopic = "";
		String currentLab = "";
		String currentChapter = "";

		for (int i = 1; i < 20; i++) {
			currentTopic = "Topic " + i;
			currentLab = "Lab " + i;
			currentChapter = "Chapter " + i;
			if (topics.contains(currentTopic)) {
				topicNumbers.add(currentTopic);
			} else if (topics.contains(currentLab)) {
				topicNumbers.add(currentLab);
			} else if (topics.contains(currentChapter)) {
				topicNumbers.add(currentChapter);
			} else {
				break;
			}
		}

		HttpSession session = request.getSession();

		session.setAttribute("pl_hours", analysis.getPl_hours());
		session.setAttribute("pt_hours", analysis.getPt_hours());
		session.setAttribute("pp_hours", analysis.getPp_hours());
		session.setAttribute("po_hours", analysis.getPo_hours());
		session.setAttribute("ol_hours", analysis.getOl_hours());
		session.setAttribute("ot_hours", analysis.getOt_hours());
		session.setAttribute("op_hours", analysis.getOp_hours());
		session.setAttribute("oo_hours", analysis.getOo_hours());
		session.setAttribute("nf2f_hours", analysis.getNf2f_hours());
		session.setAttribute("courseName", courseName);
		session.setAttribute("courseCode", courseCode);
		session.setAttribute("topics", topicNumbers.stream().collect(Collectors.joining("','", "'", "'")));

		RequestDispatcher rd = request.getRequestDispatcher("toslet-chart.jsp?courseName" + courseName);
		rd.forward(request, response);

	}

	protected void getPLOCountView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		DAO dao = new DAO();
		HttpSession session = request.getSession();

		try {
			session.setAttribute("PLO1", dao.getCourseCountForPLO("PLO01"));
			session.setAttribute("PLO2", dao.getCourseCountForPLO("PLO02"));
			session.setAttribute("PLO3", dao.getCourseCountForPLO("PLO03"));
			session.setAttribute("PLO4", dao.getCourseCountForPLO("PLO04"));
			session.setAttribute("PLO5", dao.getCourseCountForPLO("PLO05"));
			session.setAttribute("PLO6", dao.getCourseCountForPLO("PLO06"));
			session.setAttribute("PLO7", dao.getCourseCountForPLO("PLO07"));
			session.setAttribute("PLO8", dao.getCourseCountForPLO("PLO08"));
			session.setAttribute("PLO9", dao.getCourseCountForPLO("PLO09"));
			session.setAttribute("PLO10", dao.getCourseCountForPLO("PLO10"));
			session.setAttribute("PLO11", dao.getCourseCountForPLO("PLO11"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("plo-count-chart.jsp");
		rd.forward(request, response);

	}

	protected void getCAPMatrixView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		DAO dao = new DAO();
		ArrayList<CourseAndPLOAnalysis> capList = dao.getCapList();
		CAPMatrixExcelWriter ew = new CAPMatrixExcelWriter();
		ew.writeExcel(capList);
		request.getSession().setAttribute("capList", capList);
		RequestDispatcher rd = request.getRequestDispatcher("course-plo-matrix.jsp");
		rd.forward(request, response);

	}

	protected void downloadSltMatrix(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		response.setContentType("text/plain");
		response.setHeader("Content-disposition", "attachment; filename=slt-matrix.xlsx");

		DAO dao = new DAO();
		SLTMatrixExcelWriter ew = new SLTMatrixExcelWriter();
		ArrayList<SLTMatrixAnalysis> sltmList = getSltmList();
		ew.writeExcel(sltmList);
		File tempFile = ew.getTempFile();
		try (InputStream in = new FileInputStream(tempFile); OutputStream out = response.getOutputStream()) {
			String path = this.getServletContext().getContextPath();
			System.out.println("real path: " + path);

			byte[] buffer = new byte[ARBITARY_SIZE];

			int numBytesRead;
			while ((numBytesRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, numBytesRead);
			}

			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void downloadCAPMatrix(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		response.setContentType("text/plain");
		response.setHeader("Content-disposition", "attachment; filename=cap-matrix.xlsx");

		DAO dao = new DAO();
		CAPMatrixExcelWriter ew = new CAPMatrixExcelWriter();
		ew.writeExcel(dao.getCapList());
		File tempFile = ew.getTempFile();
		try (InputStream in = new FileInputStream(tempFile); OutputStream out = response.getOutputStream()) {
			String path = this.getServletContext().getContextPath();
			System.out.println("real path: " + path);

			byte[] buffer = new byte[ARBITARY_SIZE];

			int numBytesRead;
			while ((numBytesRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, numBytesRead);
			}

			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doCommand(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doCommand(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** Old Chart Generator using JFreeChart. Saved for reference. **/
//	JFreeChart chart = ChartFactory.createPieChart("PLO Count Based On Registered Courses", // chart title
//	dataset, // data
//	true, // include legend
//	true, false);
//
//int width = 1024; /* Width of the image */
//int height = 768; /* Height of the image */
//applyChartTheme(chart);
//chart.setAntiAlias(true);
//set chart bg image
//File tempFile = File.createTempFile("plo-count-chart", ".jpeg");
//ChartUtilities.saveChartAsJPEG(tempFile, chart, width, height);
//tempFile.deleteOnExit();
//
//InputStream inputStream = new FileInputStream(tempFile);
//ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//byte[] buffer = new byte[4096];
//int bytesRead = -1;
//
//while ((bytesRead = inputStream.read(buffer)) != -1) {
//outputStream.write(buffer, 0, bytesRead);
//}
//
//byte[] imageBytes = outputStream.toByteArray();
//
//String ploCount64 = Base64.getEncoder().encodeToString(imageBytes);
//
//inputStream.close();
//outputStream.close();
//
//request.getSession().setAttribute("ploCount64", ploCount64);

}