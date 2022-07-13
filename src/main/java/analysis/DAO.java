package analysis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import connector.ConnectionManager;
import course.CASAndSLT;
import course.Course;
import course.FASAndSLT;
import course.TopicAndSLT;

public class DAO {
	private static Connection conn = null;

	public DAO() {
		conn = ConnectionManager.getConnection();
	}

	protected List<Course> getCourses() throws IOException, SQLException {
		List<Course> courseList = new ArrayList<Course>();
		
		try {
			Course course = null;
			String query1 = "SELECT COURSE_CODE, COURSE_NAME, COURSE_CREDIT FROM COURSE";
			PreparedStatement ps = conn.prepareStatement(query1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				course = new Course();
				course.setCourseCode(rs.getString("COURSE_CODE"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setCourseCredit(rs.getString("COURSE_CREDIT"));
				
				//toslet
				ArrayList<TopicAndSLT> tosletList = new ArrayList<TopicAndSLT>();
				String subquery1 = "SELECT * FROM TOPIC_SLT WHERE COURSE_CODE = ? ORDER BY OUTLINE";
				PreparedStatement subps1 = conn.prepareStatement(subquery1);
				subps1.setString(1, rs.getString("COURSE_CODE"));
				ResultSet subrs1 = subps1.executeQuery();

				while (subrs1.next()) {
					TopicAndSLT toslet = new TopicAndSLT();
					toslet.setOutline(subrs1.getString("outline"));
					toslet.setClo(subrs1.getString("clo"));
					toslet.setPlhour(subrs1.getInt("pl_hour"));
					toslet.setPthour(subrs1.getInt("pt_hour"));
					toslet.setPphour(subrs1.getInt("pp_hour"));
					toslet.setPohour(subrs1.getInt("po_hour"));
					toslet.setOlhour(subrs1.getInt("ol_hour"));
					toslet.setOthour(subrs1.getInt("ot_hour"));
					toslet.setOphour(subrs1.getInt("op_hour"));
					toslet.setOohour(subrs1.getInt("oo_hour"));
					toslet.setNf2fhour(subrs1.getInt("nf2f_hour"));
					tosletList.add(toslet);
				}
				course.setCourseSLTDist2(tosletList);
				
//				//caslet
				ArrayList<CASAndSLT> casletList = new ArrayList<CASAndSLT>();
				String subquery2 = "SELECT * FROM CA_SLT WHERE COURSE_CODE = ?";
				PreparedStatement subps2 = conn.prepareStatement(subquery2);
				subps2.setString(1, rs.getString("COURSE_CODE"));
				ResultSet subrs2 = subps2.executeQuery();

				while (subrs2.next()) {
					
					System.out.println("getting caslet...: " + subrs2.getString("asst"));
					CASAndSLT caslet = new CASAndSLT();
					caslet.setAsst(subrs2.getString("asst"));
					caslet.setWeightage(subrs2.getString("weightage"));
					caslet.setPhour(subrs2.getString("phour"));
					caslet.setOhour(subrs2.getString("ohour"));
					caslet.setNf2fhour(subrs2.getString("nf2fhour"));
					casletList.add(caslet);
				}
				course.setCourseCasletDist(casletList);
				
				//faslet
				ArrayList<FASAndSLT> fasletList = new ArrayList<FASAndSLT>();
				String subquery3 = "SELECT * FROM FA_SLT WHERE COURSE_CODE = ?";
				PreparedStatement subps3 = conn.prepareStatement(subquery3);
				subps3.setString(1, rs.getString("COURSE_CODE"));
				ResultSet subrs3 = subps3.executeQuery();

				while (subrs3.next()) {

					System.out.println("getting faslet...: " + subrs3.getString("asst"));
					FASAndSLT faslet = new FASAndSLT();
					faslet.setAsst(subrs3.getString("asst"));
					faslet.setWeightage(subrs3.getString("weightage"));
					faslet.setPhour(subrs3.getString("phour"));
					faslet.setOhour(subrs3.getString("ohour"));
					faslet.setNf2fhour(subrs3.getString("nf2fhour"));
					fasletList.add(faslet);
				}
				course.setCourseFasletDist(fasletList);
				courseList.add(course);
			}
			

		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return courseList;
	}

	protected InputStream getTemplateFile(String templateId) throws IOException, SQLException {

		InputStream file = null;

		try {
			String query = "SELECT FILE FROM TEMPLATE WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, templateId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				file = rs.getBinaryStream("file");
				System.out.println("successfully retrieved template from db");
			}

		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return file;
	}

	protected TopicAndSLTAnalysis getSLTByMode(String courseCode) throws IOException, SQLException {

		TopicAndSLTAnalysis toslet = new TopicAndSLTAnalysis();
		ArrayList<String> topics = new ArrayList<String>();
		ArrayList<Integer> pl_hours = new ArrayList<Integer>();
		ArrayList<Integer> pt_hours = new ArrayList<Integer>();
		ArrayList<Integer> pp_hours = new ArrayList<Integer>();
		ArrayList<Integer> po_hours = new ArrayList<Integer>();
		ArrayList<Integer> ol_hours = new ArrayList<Integer>();
		ArrayList<Integer> ot_hours = new ArrayList<Integer>();
		ArrayList<Integer> op_hours = new ArrayList<Integer>();
		ArrayList<Integer> oo_hours = new ArrayList<Integer>();
		ArrayList<Integer> nf2f_hours = new ArrayList<Integer>();

		try {

			String query = "SELECT outline, pl_hour, pt_hour, pp_hour, po_hour, ol_hour, ot_hour, op_hour, oo_hour, nf2f_hour "
					+ "FROM `topic_slt` " + "WHERE COURSE_CODE = ? " + "ORDER BY outline;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, courseCode);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				topics.add(rs.getString("outline"));
				System.out.println("test check receive hours at dao: " + rs.getString("outline"));
				pl_hours.add(rs.getInt("pl_hour"));
				pt_hours.add(rs.getInt("pt_hour"));
				pp_hours.add(rs.getInt("pp_hour"));
				po_hours.add(rs.getInt("po_hour"));
				ol_hours.add(rs.getInt("ol_hour"));
				ot_hours.add(rs.getInt("ot_hour"));
				op_hours.add(rs.getInt("op_hour"));
				oo_hours.add(rs.getInt("oo_hour"));
				nf2f_hours.add(rs.getInt("nf2f_hour"));
			}

			toslet.setTopics(topics);
			toslet.setPl_hours(pl_hours);
			toslet.setPt_hours(pt_hours);
			toslet.setPp_hours(pp_hours);
			toslet.setPo_hours(po_hours);
			toslet.setOl_hours(ol_hours);
			toslet.setOt_hours(ot_hours);
			toslet.setOp_hours(op_hours);
			toslet.setOo_hours(oo_hours);
			toslet.setNf2f_hours(nf2f_hours);

		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return toslet;
	}

	protected Course getTopicAndSLT(String courseCode) throws ServletException, IOException, SQLException {

		try {
			Course course = new Course();
			ArrayList<TopicAndSLT> tosletList = new ArrayList<TopicAndSLT>();
			String query2 = "SELECT * FROM TOPIC_SLT WHERE COURSE_CODE = ?";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setString(1, courseCode);
			ResultSet rs2 = ps2.executeQuery();

			while (rs2.next()) {

				TopicAndSLT toslet = new TopicAndSLT();
				toslet.setOutline(rs2.getString("outline"));
				toslet.setClo(rs2.getString("clo"));
				toslet.setPlhour(rs2.getInt("pl_hour"));
				toslet.setPthour(rs2.getInt("pt_hour"));
				toslet.setPphour(rs2.getInt("pp_hour"));
				toslet.setPohour(rs2.getInt("po_hour"));
				toslet.setOlhour(rs2.getInt("ol_hour"));
				toslet.setOthour(rs2.getInt("ot_hour"));
				toslet.setOphour(rs2.getInt("op_hour"));
				toslet.setOohour(rs2.getInt("oo_hour"));
				toslet.setNf2fhour(rs2.getInt("nf2f_hour"));
				tosletList.add(toslet);
			}
			course.setCourseSLTDist2(tosletList);
			return course;

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected ArrayList<CourseAndPLOAnalysis> getCapList() throws ServletException, IOException, SQLException {
		ArrayList<CourseAndPLOAnalysis> capList = new ArrayList<CourseAndPLOAnalysis>();
		DAO dao = new DAO();
		List<Course> courseList = dao.getCourseList();

		for (Course c : courseList) {
			CourseAndPLOAnalysis cap = new CourseAndPLOAnalysis();
			cap.setCourseCode(c.getCourseCode());
			cap.setCourseName(c.getCourseName());
			cap.setCourseCredit(c.getCourseCredit());

			ArrayList<String> cpmapping = c.getCourseCLOPLOMapping();

			for (String s : cpmapping) {

				if (s.contains("PLO01")) {
					cap.setPlo1("/");
				} else if (s.contains("PLO02")) {
					cap.setPlo2("/");
				} else if (s.contains("PLO03")) {
					cap.setPlo3("/");
				} else if (s.contains("PLO04")) {
					cap.setPlo4("/");
				} else if (s.contains("PLO05")) {
					cap.setPlo5("/");
				} else if (s.contains("PLO06")) {
					cap.setPlo6("/");
				} else if (s.contains("PLO07")) {
					cap.setPlo7("/");
				} else if (s.contains("PLO08")) {
					cap.setPlo8("/");
				} else if (s.contains("PLO09")) {
					cap.setPlo9("/");
				} else if (s.contains("PLO10")) {
					cap.setPlo10("/");
				} else if (s.contains("PLO11")) {
					cap.setPlo11("/");
				}
			}
			capList.add(cap);
		}
		return capList;
	}

	protected int getCourseCountForPLO(String plo) throws SQLException {
		try {
			List<Course> courseList = new ArrayList<Course>();
			String query = "SELECT * FROM COURSE";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourseAcadStaff(rs.getString("COURSE_ACAD_STAFFS"));
				course.setCourseClassification(rs.getString("COURSE_CLASSIFICATION"));
				course.setCourseCode(rs.getString("COURSE_CODE"));
				course.setCourseCredit(rs.getString("COURSE_CREDIT"));
				course.setCourseDatesApproval(rs.getString("COURSE_DATES_APPROVAL"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setCourseOtherInfo(rs.getString("COURSE_OTHER_INFO"));
				course.setCoursePrerequisite(rs.getString("COURSE_PREREQUISITE"));
				course.setCourseLearningOutcomes(rs.getString("COURSE_LEARNING_OUTCOMES"));
				course.setCourseReferences(rs.getString("COURSE_REFERENCES"));
				course.setCourseSemYearOffered(rs.getString("COURSE_SEMYEAR_OFFERED"));
				course.setCourseSLTDist(rs.getString("COURSE_SLT_DIST"));
				course.setCourseSpecialReq(rs.getString("COURSE_SPECIAL_REQ"));
				course.setCourseSynopsis(rs.getString("COURSE_SYNOPSIS"));
				course.setCourseTransSkills(rs.getString("COURSE_TRANS_SKILLS"));
				course.setCourseCLOPLOMapping(stringToArrayList(rs.getString("COURSE_CLO_PLO_MAPPING")));
				course.setAssessmentMethodsForCLO1(rs.getString("COURSE_AM_FOR_CLO1"));
				course.setAssessmentMethodsForCLO2(rs.getString("COURSE_AM_FOR_CLO2"));
				course.setAssessmentMethodsForCLO3(rs.getString("COURSE_AM_FOR_CLO3"));
				course.setTeachingMethodsForCLO1(rs.getString("COURSE_TM_FOR_CLO1"));
				course.setTeachingMethodsForCLO2(rs.getString("COURSE_TM_FOR_CLO2"));
				course.setTeachingMethodsForCLO3(rs.getString("COURSE_TM_FOR_CLO3"));
				course.setMQFLOforPLO(stringToArrayList(rs.getString("COURSE_MQFLO_PLO_MAPPING")));

				courseList.add(course);
			}

			int ploCount = 0;

			for (Course c : courseList) {

				ArrayList<String> CLOPLOMapping = c.getCourseCLOPLOMapping();

				for (String s : CLOPLOMapping) {

					if (s.contains(plo)) {
						ploCount++;
						System.out.println(plo + " for " + c.getCourseName() + " found");
					} else {
						System.out.println(plo + " for " + c.getCourseName() + " not found");
					}
				}
			}
			return ploCount;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (plo.equals("PLO11")) {
				conn.close();
			}
		}
	}

	protected List<Course> getCourseList() throws SQLException {

		try {
			List<Course> courseList = new ArrayList<Course>();
			String query = "SELECT * FROM COURSE";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList<TopicAndSLT> tosletList = new ArrayList<TopicAndSLT>();
				TopicAndSLT toslet = new TopicAndSLT();
				toslet.setOutline("null");
				tosletList.add(toslet);

				Course course = new Course();
				course.setCourseAcadStaff(rs.getString("COURSE_ACAD_STAFFS"));
				course.setCourseClassification(rs.getString("COURSE_CLASSIFICATION"));
				course.setCourseCode(rs.getString("COURSE_CODE"));
				course.setCourseCredit(rs.getString("COURSE_CREDIT"));
				course.setCourseDatesApproval(rs.getString("COURSE_DATES_APPROVAL"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setCourseOtherInfo(rs.getString("COURSE_OTHER_INFO"));
				course.setCoursePrerequisite(rs.getString("COURSE_PREREQUISITE"));
				course.setCourseLearningOutcomes(rs.getString("COURSE_LEARNING_OUTCOMES"));
				course.setCourseReferences(rs.getString("COURSE_REFERENCES"));
				course.setCourseSemYearOffered(rs.getString("COURSE_SEMYEAR_OFFERED"));
				course.setCourseSLTDist2(tosletList);
				course.setCourseSpecialReq(rs.getString("COURSE_SPECIAL_REQ"));
				course.setCourseSynopsis(rs.getString("COURSE_SYNOPSIS"));
				course.setCourseTransSkills(rs.getString("COURSE_TRANS_SKILLS"));
				course.setCourseCLOPLOMapping(stringToArrayList(rs.getString("COURSE_CLO_PLO_MAPPING")));
				course.setAssessmentMethodsForCLO1(rs.getString("COURSE_AM_FOR_CLO1"));
				course.setAssessmentMethodsForCLO2(rs.getString("COURSE_AM_FOR_CLO2"));
				course.setAssessmentMethodsForCLO3(rs.getString("COURSE_AM_FOR_CLO3"));
				course.setTeachingMethodsForCLO1(rs.getString("COURSE_TM_FOR_CLO1"));
				course.setTeachingMethodsForCLO2(rs.getString("COURSE_TM_FOR_CLO2"));
				course.setTeachingMethodsForCLO3(rs.getString("COURSE_TM_FOR_CLO3"));
				course.setMQFLOforPLO(stringToArrayList(rs.getString("COURSE_MQFLO_PLO_MAPPING")));

				courseList.add(course);
			}
			return courseList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected ArrayList<String> stringToArrayList(String s) {

		char openBracket = '[';
		char closeBracket = ']';
		char delimiter = ',';
		char[] charArray = {};

		try {
			charArray = s.toCharArray();
		} catch (NullPointerException ex) {
			System.out.println(
					"Database returns null value to converting from string to arraylist. course code or name received could be null/mismatched somewhere"
							+ "\n " + ex);
		}

		ArrayList<Character> charArrayList = new ArrayList<Character>();
		ArrayList<String> arrayList = new ArrayList<String>();
		String temp = "";

		for (char c : charArray) {
			charArrayList.add(c);
		}

		for (int i = 0; i < charArrayList.size(); i++) {
			char c = charArrayList.get(i);
			if (c != delimiter && c != openBracket && c != closeBracket) {
				temp = temp + String.valueOf(c);
			}

			if (c == delimiter || i == charArrayList.size() - 2) {
				arrayList.add(temp);
				temp = "";
			}
		}

		return arrayList;
	}

}
