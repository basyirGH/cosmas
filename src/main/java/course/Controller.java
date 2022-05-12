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

package course;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
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
import org.apache.commons.io.FilenameUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/ControllerCourse")
@MultipartConfig

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String serverInfo = request.getSession().getServletContext().getServerInfo();
		System.out.println("Server Info" + serverInfo);
		String servletInfo = request.getSession().getServletContext().getMajorVersion() + "."
				+ request.getSession().getServletContext().getMinorVersion();
		System.out.println("Servlet Info" + servletInfo);

		String command = request.getParameter("command");
		if (command != null) {
			try {
				switch (command) {
				case "Add Course":
					addCourse(request, response);
					break;

				case "Courses":
					getCourses(request, response);
					break;

				case "Edit":
					edit(request, response);
					break;

				case "Save Edit":
					saveEdit(request, response);
					break;

				case "Delete":
					delete(request, response);
					break;

				case "addMapping8":
					testCreateAttribute8(request, response);
					break;

				case "readMapping8":
					testReadAttribute8(request, response);
					break;

				case "getPageForUpdateMapping8":
					getPageForUpdateMapping8(request, response);
					break;

				case "updateMapping8":
					testUpdateAttribute8(request, response);
					break;

				case "goToFileChooser":
					goToFileChooser(request, response);
					break;

				default:
					DAO dao = new DAO();
					for (Course c : dao.getList()) {
						if (c.getCourseCode().equals(command) || c.getCourseName().equals(command)) {
							System.out.println("course found... : " + command);
							getCourseView(request, response);
							return;
						} else {
							System.out.println("finding course... : " + command);
						}

					}
					break;
				}
			} catch (SQLException e) {
				throw new SQLException(e);
			}
		}
	}

	protected void addCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String courseCode = request.getParameter("courseCode");
		String courseName = request.getParameter("courseName");
		String courseClassification = request.getParameter("courseClassification");
		String courseSynopsis = request.getParameter("courseSynopsis");
		String courseAcadStaff = request.getParameter("courseAcadStaff");
		String courseSemYearOffered = request.getParameter("courseSemYearOffered");
		String courseCredit = String.valueOf(request.getParameter("courseCredit"));
		String coursePrerequisite = request.getParameter("coursePrerequisite");
		String courseLearningOutcomes = request.getParameter("courseLearningOutcomes");
		String courseTransSkills = request.getParameter("courseTransSkills");
		String courseSLTDist = request.getParameter("courseSLTDist");
		String courseSpecialReq = request.getParameter("courseSpecialReq");
		String courseReferences = request.getParameter("courseReferences");
		String courseOtherInfo = request.getParameter("courseOtherInfo");
		String courseDatesApproval = request.getParameter("courseDatesApproval");

		// CLO PLO

		String checkedTrue = request.getParameter("CLOPLOcheckedTrue");
		char delimiter = ',';
		char[] checkedTrueCharArray = checkedTrue.toCharArray();
		ArrayList<Character> checkedTrueCharArrayList = new ArrayList<Character>();
		ArrayList<String> checkedTrueArrayList = new ArrayList<String>();
		String temp = "";
		String teachingMethodsForCLO1 = request.getParameter("TeachingMethodsForCLO1");
		String teachingMethodsForCLO2 = request.getParameter("TeachingMethodsForCLO2");
		String teachingMethodsForCLO3 = request.getParameter("TeachingMethodsForCLO3");
		String assessmentMethodsForCLO1 = request.getParameter("AssessmentMethodsForCLO1");
		String assessmentMethodsForCLO2 = request.getParameter("AssessmentMethodsForCLO2");
		String assessmentMethodsForCLO3 = request.getParameter("AssessmentMethodsForCLO3");
		String MQFLOforPLOArray = request.getParameter("MQFLOforPLOArray");
		char[] MQFLOforPLOCharArray = MQFLOforPLOArray.toCharArray();
		ArrayList<Character> MQFLOforPLOCharArrayList = new ArrayList<Character>();
		ArrayList<String> MQFLOforPLOArrayList = new ArrayList<String>();

		for (char c : checkedTrueCharArray) {
			checkedTrueCharArrayList.add(c);
		}

		for (int i = 0; i < checkedTrueCharArrayList.size(); i++) {
			char c = checkedTrueCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == checkedTrueCharArrayList.size() - 1) {
				checkedTrueArrayList.add(temp);
				temp = "";
			}
		}

		for (char c : MQFLOforPLOCharArray) {
			MQFLOforPLOCharArrayList.add(c);
		}

		for (int i = 0; i < MQFLOforPLOCharArrayList.size(); i++) {
			char c = MQFLOforPLOCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == MQFLOforPLOCharArrayList.size() - 1) {
				MQFLOforPLOArrayList.add(temp);
				temp = "";
			}
		}

		for (String s : MQFLOforPLOArrayList) {
			System.out.println("checked: " + s);
		}

		Course course = new Course();
		course.setCourseCLOPLOMapping(checkedTrueArrayList);
		course.setTeachingMethodsForCLO1(teachingMethodsForCLO1);
		course.setTeachingMethodsForCLO2(teachingMethodsForCLO2);
		course.setTeachingMethodsForCLO3(teachingMethodsForCLO3);
		course.setAssessmentMethodsForCLO1(assessmentMethodsForCLO1);
		course.setAssessmentMethodsForCLO2(assessmentMethodsForCLO2);
		course.setAssessmentMethodsForCLO3(assessmentMethodsForCLO3);
		course.setMQFLOforPLO(MQFLOforPLOArrayList);

		DAO dao = new DAO();

		course.setCourseAcadStaff(courseAcadStaff);
		course.setCourseClassification(courseClassification);
		course.setCourseCode(courseCode);
		course.setCourseCredit(courseCredit);
		course.setCourseDatesApproval(courseDatesApproval);
		course.setCourseName(courseName);
		course.setCourseOtherInfo(courseOtherInfo);
		course.setCoursePrerequisite(coursePrerequisite);
		course.setCourseLearningOutcomes(courseLearningOutcomes);
		course.setCourseReferences(courseReferences);
		course.setCourseSemYearOffered(courseSemYearOffered);
		course.setCourseSLTDist(courseSLTDist);
		course.setCourseSpecialReq(courseSpecialReq);
		course.setCourseSynopsis(courseSynopsis);
		course.setCourseTransSkills(courseTransSkills);

		dao.add(course);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	protected void getCourses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		DAO dao = new DAO();
		List<Course> courseList = dao.getList();
		java.util.Date date = new java.util.Date();
		System.out.println("test check list of all courses: " + date);
		for (Course c : courseList) {
			System.out.println(c.getCourseCode());
		}

		Collections.reverse(courseList);
		request.getSession().setAttribute("courseList", courseList);
		RequestDispatcher rd = request.getRequestDispatcher("courses.jsp");
		rd.forward(request, response);

	}

	protected void getCourseView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String courseCode = request.getParameter("courseCode");
		System.out.println("test receive course code from choosing a course from course list: " + courseCode);
		DAO dao = new DAO();
		Course course = dao.getCourse(courseCode);
		System.out.println("test receive checkedTrue at controller: " + course.getCourseCLOPLOMapping());
		request.getSession().setAttribute("course", course);
		request.getSession().setAttribute("courseCodeOld", courseCode);
		RequestDispatcher rd = request.getRequestDispatcher("view-course.jsp");
		rd.forward(request, response);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String courseCode = request.getParameter("courseCode");
		String courseCodeOld = request.getParameter("courseCodeOld");
		DAO dao = new DAO();
		Course course = dao.getCourse(courseCode);

		request.getSession().setAttribute("course", course);
		request.getSession().setAttribute("courseCodeOld", courseCodeOld);
		RequestDispatcher rd = request.getRequestDispatcher("edit-course.jsp");
		rd.forward(request, response);
	}

	protected void saveEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String courseCodeOld = request.getParameter("courseCodeOld");
		System.out.println("test receive coursecodeold at controller: " + courseCodeOld);
		String courseCode = request.getParameter("courseCode");
		String courseName = request.getParameter("courseName");
		String courseClassification = request.getParameter("courseClassification");
		String courseSynopsis = request.getParameter("courseSynopsis");
		String courseAcadStaff = request.getParameter("courseAcadStaff");
		String courseSemYearOffered = request.getParameter("courseSemYearOffered");
		String courseCredit = String.valueOf(request.getParameter("courseCredit"));
		String coursePrerequisite = request.getParameter("coursePrerequisite");
		String courseLearningOutcomes = request.getParameter("courseLearningOutcomes");
		String courseTransSkills = request.getParameter("courseTransSkills");
		String courseSLTDist = request.getParameter("courseSLTDist");;
		String courseSpecialReq = request.getParameter("courseSpecialReq");
		String courseReferences = request.getParameter("courseReferences");
		String courseOtherInfo = request.getParameter("courseOtherInfo");
		String courseDatesApproval = request.getParameter("courseDatesApproval");

		String checkedTrue = request.getParameter("checkedTrueCLOPLOArray");
		System.out.println("Controller check update: " + checkedTrue);
		char delimiter = ',';
		char[] checkedTrueCharArray = checkedTrue.toCharArray();
		ArrayList<Character> checkedTrueCharArrayList = new ArrayList<Character>();
		ArrayList<String> checkedTrueArrayList = new ArrayList<String>();
		String temp = "";
		String teachingMethodsForCLO1 = request.getParameter("TeachingMethodsForCLO1");
		String teachingMethodsForCLO2 = request.getParameter("TeachingMethodsForCLO2");
		String teachingMethodsForCLO3 = request.getParameter("TeachingMethodsForCLO3");
		String assessmentMethodsForCLO1 = request.getParameter("AssessmentMethodsForCLO1");
		String assessmentMethodsForCLO2 = request.getParameter("AssessmentMethodsForCLO2");
		String assessmentMethodsForCLO3 = request.getParameter("AssessmentMethodsForCLO3");
		String MQFLOforPLOArray = request.getParameter("MQFLOforPLOArray");
		char[] MQFLOforPLOCharArray = MQFLOforPLOArray.toCharArray();
		ArrayList<Character> MQFLOforPLOCharArrayList = new ArrayList<Character>();
		ArrayList<String> MQFLOforPLOArrayList = new ArrayList<String>();

		for (char c : checkedTrueCharArray) {
			checkedTrueCharArrayList.add(c);
		}

		for (int i = 0; i < checkedTrueCharArrayList.size(); i++) {
			char c = checkedTrueCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == checkedTrueCharArrayList.size() - 1) {
				checkedTrueArrayList.add(temp);
				temp = "";
			}
		}

		for (char c : MQFLOforPLOCharArray) {
			MQFLOforPLOCharArrayList.add(c);
		}

		for (int i = 0; i < MQFLOforPLOCharArrayList.size(); i++) {
			char c = MQFLOforPLOCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == MQFLOforPLOCharArrayList.size() - 1) {
				MQFLOforPLOArrayList.add(temp);
				temp = "";
			}
		}

		for (String s : MQFLOforPLOArrayList) {
			System.out.println("checked MQFLOforPLOArrayList: " + s);
		}

		Course courseEdit = new Course();
		courseEdit.setCourseAcadStaff(courseAcadStaff);
		courseEdit.setCourseClassification(courseClassification);
		courseEdit.setCourseCode(courseCode);
		courseEdit.setCourseCredit(courseCredit);
		courseEdit.setCourseDatesApproval(courseDatesApproval);
		courseEdit.setCourseName(courseName);
		courseEdit.setCourseOtherInfo(courseOtherInfo);
		courseEdit.setCoursePrerequisite(coursePrerequisite);
		courseEdit.setCourseLearningOutcomes(courseLearningOutcomes);
		courseEdit.setCourseReferences(courseReferences);
		courseEdit.setCourseSemYearOffered(courseSemYearOffered);
		courseEdit.setCourseSLTDist(courseSLTDist);
		courseEdit.setCourseSpecialReq(courseSpecialReq);
		courseEdit.setCourseSynopsis(courseSynopsis);
		courseEdit.setCourseTransSkills(courseTransSkills);
		courseEdit.setCourseCLOPLOMapping(checkedTrueArrayList);
		courseEdit.setTeachingMethodsForCLO1(teachingMethodsForCLO1);
		courseEdit.setTeachingMethodsForCLO2(teachingMethodsForCLO2);
		courseEdit.setTeachingMethodsForCLO3(teachingMethodsForCLO3);
		courseEdit.setAssessmentMethodsForCLO1(assessmentMethodsForCLO1);
		courseEdit.setAssessmentMethodsForCLO2(assessmentMethodsForCLO2);
		courseEdit.setAssessmentMethodsForCLO3(assessmentMethodsForCLO3);
		courseEdit.setMQFLOforPLO(MQFLOforPLOArrayList);

		DAO dao = new DAO();
		int updateOK = dao.update(courseEdit, courseCodeOld);
		if (updateOK == 1) {
			request.getSession().setAttribute("isCourseUpdated", true);
			System.out.println("update ok ");
			request.getSession().setAttribute("course", courseEdit);
			getCourseView(request, response);
		} else {
			request.getSession().setAttribute("isCourseUpdated", false);
			System.out.println("update not ok");
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String courseCode = request.getParameter("courseCode");
		DAO dao = new DAO();
		int deleteCourse = dao.delete(courseCode);

		if (deleteCourse == 1) {
			System.out.println("delete ok ");
			getCourses(request, response);
		} else {
			System.out.println("delete failed ");
		}
	}

	protected void testCreateAttribute8(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String checkedTrue = request.getParameter("CLOPLOcheckedTrue");
		char delimiter = ',';
		char[] checkedTrueCharArray = checkedTrue.toCharArray();
		ArrayList<Character> checkedTrueCharArrayList = new ArrayList<Character>();
		ArrayList<String> checkedTrueArrayList = new ArrayList<String>();
		String temp = "";
		String teachingMethodsForCLO1 = request.getParameter("TeachingMethodsForCLO1");
		String teachingMethodsForCLO2 = request.getParameter("TeachingMethodsForCLO2");
		String teachingMethodsForCLO3 = request.getParameter("TeachingMethodsForCLO3");
		String assessmentMethodsForCLO1 = request.getParameter("AssessmentMethodsForCLO1");
		String assessmentMethodsForCLO2 = request.getParameter("AssessmentMethodsForCLO2");
		String assessmentMethodsForCLO3 = request.getParameter("AssessmentMethodsForCLO3");
		String MQFLOforPLOArray = request.getParameter("MQFLOforPLOArray");
		char[] MQFLOforPLOCharArray = MQFLOforPLOArray.toCharArray();
		ArrayList<Character> MQFLOforPLOCharArrayList = new ArrayList<Character>();
		ArrayList<String> MQFLOforPLOArrayList = new ArrayList<String>();

		for (char c : checkedTrueCharArray) {
			checkedTrueCharArrayList.add(c);
		}

		for (int i = 0; i < checkedTrueCharArrayList.size(); i++) {
			char c = checkedTrueCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == checkedTrueCharArrayList.size() - 1) {
				checkedTrueArrayList.add(temp);
				temp = "";
			}
		}

		for (char c : MQFLOforPLOCharArray) {
			MQFLOforPLOCharArrayList.add(c);
		}

		for (int i = 0; i < MQFLOforPLOCharArrayList.size(); i++) {
			char c = MQFLOforPLOCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == MQFLOforPLOCharArrayList.size() - 1) {
				MQFLOforPLOArrayList.add(temp);
				temp = "";
			}
		}

		for (String s : MQFLOforPLOArrayList) {
			System.out.println("checked: " + s);
		}

		Course course = new Course();
		course.setCourseCLOPLOMapping(checkedTrueArrayList);
		course.setTeachingMethodsForCLO1(teachingMethodsForCLO1);
		course.setTeachingMethodsForCLO2(teachingMethodsForCLO2);
		course.setTeachingMethodsForCLO3(teachingMethodsForCLO3);
		course.setAssessmentMethodsForCLO1(assessmentMethodsForCLO1);
		course.setAssessmentMethodsForCLO2(assessmentMethodsForCLO2);
		course.setAssessmentMethodsForCLO3(assessmentMethodsForCLO3);
		course.setMQFLOforPLO(MQFLOforPLOArrayList);

		DAO dao = new DAO();
		dao.testAddMapping8(course);
	}

	protected void testReadAttribute8(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("header info: " + request.getQueryString());

		String courseCode = request.getParameter("courseCode");

		Course course = new Course();
		DAO dao = new DAO();

		course = dao.testReadMapping8(courseCode);
		System.out.println("test receive at controller: " + course.getCourseCLOPLOMapping());

		request.getSession().setAttribute("course", course);
		RequestDispatcher rd = request.getRequestDispatcher("z2_testReadAttribute8.jsp");
		rd.forward(request, response);

	}

	protected void getPageForUpdateMapping8(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String courseCode = request.getParameter("courseCode");
		System.out.println("test receive course code: " + courseCode);
		Course course = new Course();
		DAO dao = new DAO();

		course = dao.testReadMapping8(courseCode);
		ArrayList<String> checkedTrueArrayList = course.getCourseCLOPLOMapping();
		course.setCourseCode(courseCode);
		course.setCourseCLOPLOMapping(checkedTrueArrayList);
		System.out.println("test receive mqf at controller: " + course.getMQFLOforPLO());

		request.getSession().setAttribute("course", course);
		RequestDispatcher rd = request.getRequestDispatcher("z3_testUpdateAttribute8.jsp");
		rd.forward(request, response);
	}

	protected void testUpdateAttribute8(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String checkedTrue = request.getParameter("checkedTrue");
		System.out.println("Controller check update: " + checkedTrue);
		String courseCode = request.getParameter("courseCode");
		char delimiter = ',';
		char[] checkedTrueCharArray = checkedTrue.toCharArray();
		ArrayList<Character> checkedTrueCharArrayList = new ArrayList<Character>();
		ArrayList<String> checkedTrueArrayList = new ArrayList<String>();
		String temp = "";
		String teachingMethodsForCLO1 = request.getParameter("TeachingMethodsForCLO1");
		String teachingMethodsForCLO2 = request.getParameter("TeachingMethodsForCLO2");
		String teachingMethodsForCLO3 = request.getParameter("TeachingMethodsForCLO3");
		String assessmentMethodsForCLO1 = request.getParameter("AssessmentMethodsForCLO1");
		String assessmentMethodsForCLO2 = request.getParameter("AssessmentMethodsForCLO2");
		String assessmentMethodsForCLO3 = request.getParameter("AssessmentMethodsForCLO3");
		String MQFLOforPLOArray = request.getParameter("MQFLOforPLOArray");
		char[] MQFLOforPLOCharArray = MQFLOforPLOArray.toCharArray();
		ArrayList<Character> MQFLOforPLOCharArrayList = new ArrayList<Character>();
		ArrayList<String> MQFLOforPLOArrayList = new ArrayList<String>();

		for (char c : checkedTrueCharArray) {
			checkedTrueCharArrayList.add(c);
		}

		for (int i = 0; i < checkedTrueCharArrayList.size(); i++) {
			char c = checkedTrueCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == checkedTrueCharArrayList.size() - 1) {
				checkedTrueArrayList.add(temp);
				temp = "";
			}
		}

		for (char c : MQFLOforPLOCharArray) {
			MQFLOforPLOCharArrayList.add(c);
		}

		for (int i = 0; i < MQFLOforPLOCharArrayList.size(); i++) {
			char c = MQFLOforPLOCharArrayList.get(i);
			if (c != delimiter) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == MQFLOforPLOCharArrayList.size() - 1) {
				MQFLOforPLOArrayList.add(temp);
				temp = "";
			}
		}

		for (String s : MQFLOforPLOArrayList) {
			System.out.println("checked MQFLOforPLOArrayList: " + s);
		}

		Course course = new Course();
		course.setCourseCode(courseCode);
		course.setCourseCLOPLOMapping(checkedTrueArrayList);
		course.setTeachingMethodsForCLO1(teachingMethodsForCLO1);
		course.setTeachingMethodsForCLO2(teachingMethodsForCLO2);
		course.setTeachingMethodsForCLO3(teachingMethodsForCLO3);
		course.setAssessmentMethodsForCLO1(assessmentMethodsForCLO1);
		course.setAssessmentMethodsForCLO2(assessmentMethodsForCLO2);
		course.setAssessmentMethodsForCLO3(assessmentMethodsForCLO3);
		course.setMQFLOforPLO(MQFLOforPLOArrayList);

		DAO dao = new DAO();
		int updateOK = dao.testUpdateMapping8(course);

		if (updateOK == 1) {
			System.out
					.println("update ok. new mapping for " + course.getCourseCode() + " is " + course.getMQFLOforPLO());
		} else {
			System.out.println("update not ok.");
		}

		request.getSession().setAttribute("course", course);
		RequestDispatcher rd = request.getRequestDispatcher("z2_testReadAttribute8.jsp");
		rd.forward(request, response);

	}

	protected void goToFileChooser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String fromCommand = request.getParameter("fromCommand");
		String courseCodeOld = request.getParameter("courseCodeOld");
		System.out.println("test receive coursecodeold value: " + courseCodeOld);
		request.getSession().setAttribute("fromCommand", fromCommand);
		request.getSession().setAttribute("courseCodeOld", courseCodeOld);
		RequestDispatcher rd = request.getRequestDispatcher("file-chooser.jsp?courseCodeOld=" + courseCodeOld);
		rd.forward(request, response);
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
}
