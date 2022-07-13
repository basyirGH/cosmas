package course;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import connector.ConnectionManager;
import request.Request;

public class DAO {

	private static Connection conn = null;

	public DAO() {
		conn = ConnectionManager.getConnection();
	}

	protected List<Request> getRequestsByUserId(String userId) throws SQLException {

		try {
			List<Request> reqList = new ArrayList<Request>();
			String query = "SELECT * FROM REQUEST WHERE USER_ID = ? AND REQUEST_STATUS = 'APPROVED'";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Request req = new Request();
				req.setCourseCode(rs.getString("COURSE_CODE"));
				req.setRequestAction(rs.getString("REQUEST_ACTION"));
				req.setRequestId(rs.getString("REQUEST_ID"));
				req.setRequestMadeOn(rs.getTimestamp("REQUEST_MADE_ON"));
				req.setRequestMessage(rs.getString("REQUEST_MESSAGE"));
				req.setRequestStatus(rs.getString("REQUEST_STATUS"));
				req.setUserId(rs.getString("USER_ID"));
				System.out.println("get user id: " + req.getUserId());

				reqList.add(req);
			}
			return reqList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	void add(Course course) throws SQLException {

		try {
			String query1 = "INSERT INTO " + "COURSE(" + "COURSE_CODE, COURSE_NAME, COURSE_CLASSIFICATION, "
					+ "COURSE_SYNOPSIS, COURSE_ACAD_STAFFS, COURSE_SEMYEAR_OFFERED, "
					+ "COURSE_CREDIT, COURSE_PREREQUISITE, COURSE_LEARNING_OUTCOMES, "
					+ "COURSE_TRANS_SKILLS , COURSE_SLT_DIST, COURSE_SPECIAL_REQ, "
					+ "COURSE_REFERENCES, COURSE_OTHER_INFO, COURSE_DATES_APPROVAL, " + "COURSE_CLO_PLO_MAPPING, "
					+ "COURSE_TM_FOR_CLO1, " + "COURSE_TM_FOR_CLO2, " + "COURSE_TM_FOR_CLO3, " + "COURSE_AM_FOR_CLO1, "
					+ "COURSE_AM_FOR_CLO2, " + "COURSE_AM_FOR_CLO3, " + "COURSE_MQFLO_PLO_MAPPING, TOTAL_TOSLET, TOTAL_CASLET, TOTAL_FASLET, GTSLT) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, course.getCourseCode());
			ps1.setString(2, course.getCourseName());
			ps1.setString(3, course.getCourseClassification());
			ps1.setString(4, course.getCourseSynopsis());
			ps1.setString(5, course.getCourseAcadStaff());
			ps1.setString(6, course.getCourseSemYearOffered());
			ps1.setString(7, course.getCourseCredit());
			ps1.setString(8, course.getCoursePrerequisite());
			ps1.setString(9, course.getCourseLearningOutcomes());
			ps1.setString(10, course.getCourseTransSkills());
			ps1.setString(11, "null");
			ps1.setString(12, course.getCourseSpecialReq());
			ps1.setString(13, course.getCourseReferences());
			ps1.setString(14, course.getCourseOtherInfo());
			ps1.setString(15, course.getCourseDatesApproval());
			ps1.setString(16, course.getCourseCLOPLOMapping().toString());
			ps1.setString(17, course.getTeachingMethodsForCLO1());
			ps1.setString(18, course.getTeachingMethodsForCLO2());
			ps1.setString(19, course.getTeachingMethodsForCLO3());
			ps1.setString(20, course.getAssessmentMethodsForCLO1());
			ps1.setString(21, course.getAssessmentMethodsForCLO2());
			ps1.setString(22, course.getAssessmentMethodsForCLO3());
			ps1.setString(23, course.getMQFLOforPLO().toString());
			ps1.setInt(24, course.getTotalToslet());
			ps1.setInt(25, course.getTotalCaslet());
			ps1.setInt(26, course.getTotalFaslet());
			ps1.setInt(27, course.getGrandTotalSLT());
			ps1.execute();

			// Topic and SLT
			for (TopicAndSLT e : course.getCourseSLTDist2()) {

				String query2 = "INSERT INTO " + "TOPIC_SLT(" + "OUTLINE, CLO, PL_HOUR, "
						+ "PT_HOUR, PP_HOUR, PO_HOUR, " + "OL_HOUR, OT_HOUR, OP_HOUR, "
						+ "OO_HOUR , NF2F_HOUR, COURSE_CODE, TSLT_ID) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement ps2 = conn.prepareStatement(query2);

				ps2.setString(1, e.getOutline());
				ps2.setString(2, e.getClo());
				ps2.setInt(3, e.getPlhour());
				ps2.setInt(4, e.getPthour());
				ps2.setInt(5, e.getPphour());
				ps2.setInt(6, e.getPohour());
				ps2.setInt(7, e.getOlhour());
				ps2.setInt(8, e.getOthour());
				ps2.setInt(9, e.getOphour());
				ps2.setInt(10, e.getOohour());
				ps2.setInt(11, e.getNf2fhour());
				ps2.setString(12, course.getCourseCode());
				ps2.setString(13, e.getTsltId());
				ps2.execute();
			}

			// CA and SLT
			for (CASAndSLT e : course.getCourseCasletDist()) {

				String query3 = "INSERT INTO " + "CA_SLT(" + "CASLET_ID, ASST, WEIGHTAGE, "
						+ "PHOUR, OHOUR, NF2FHOUR, COURSE_CODE) " + "VALUES(?,?,?,?,?,?,?)";

				PreparedStatement ps3 = conn.prepareStatement(query3);

				ps3.setString(1, e.getAsstId());
				ps3.setString(2, e.getAsst());
				ps3.setString(3, e.getWeightage());
				ps3.setString(4, e.getPhour());
				ps3.setString(5, e.getOhour());
				ps3.setString(6, e.getNf2fhour());
				ps3.setString(7, course.getCourseCode());
				ps3.execute();
			}

			// FA and SLT
			for (FASAndSLT e : course.getCourseFasletDist()) {

				String query4 = "INSERT INTO " + "FA_SLT(" + "FASLET_ID, ASST, WEIGHTAGE, "
						+ "PHOUR, OHOUR, NF2FHOUR, COURSE_CODE) " + "VALUES(?,?,?,?,?,?,?)";

				PreparedStatement ps4 = conn.prepareStatement(query4);

				ps4.setString(1, e.getAsstId());
				ps4.setString(2, e.getAsst());
				ps4.setString(3, e.getWeightage());
				ps4.setString(4, e.getPhour());
				ps4.setString(5, e.getOhour());
				ps4.setString(6, e.getNf2fhour());
				ps4.setString(7, course.getCourseCode());
				ps4.execute();
			}

			System.out.println("test receive at dao slt: " + course.getCourseSLTDist2().toString());
			System.out.println("test receive at dao slt: " + course.getCourseCasletDist().toString());
			System.out.println("test receive at dao slt: " + course.getCourseFasletDist().toString());
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected List<Course> getList() throws SQLException {

		try {
			List<Course> courseList = new ArrayList<Course>();
			String query = "SELECT * FROM COURSE ORDER BY COURSE_NAME DESC";
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
				//course.setCourseSLTDist2(rs.get);

				courseList.add(course);
			}
			return courseList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	public Course getCourse(String courseCode) throws SQLException {

		try {
			String query1 = "SELECT * FROM COURSE WHERE COURSE_CODE = ?";
			PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, courseCode);
			ResultSet rs = ps.executeQuery();
			Course course = new Course();
			while (rs.next()) {
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
				// course.setCourseSLTDist(rs.getString("COURSE_SLT_DIST"));
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
				course.setTotalToslet(rs.getInt("TOTAL_TOSLET"));
				course.setTotalCaslet(rs.getInt("TOTAL_CASLET"));
				course.setTotalFaslet(rs.getInt("TOTAL_FASLET"));
				course.setGrandTotalSLT(rs.getInt("GTSLT"));
			}

			// TOSLET
			ArrayList<TopicAndSLT> tosletList = new ArrayList<TopicAndSLT>();
			String query2 = "SELECT * FROM TOPIC_SLT WHERE COURSE_CODE = ? ORDER BY OUTLINE";
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
				//toslet.setTsltId(rs2.getString("tslt_id"));
				tosletList.add(toslet);
			}
			course.setCourseSLTDist2(tosletList);

			// CASLET
			ArrayList<CASAndSLT> casletList = new ArrayList<CASAndSLT>();
			String query3 = "SELECT * FROM CA_SLT WHERE COURSE_CODE = ?";
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setString(1, courseCode);
			ResultSet rs3 = ps3.executeQuery();

			while (rs3.next()) {

				CASAndSLT caslet = new CASAndSLT();
				caslet.setAsst(rs3.getString("asst"));
				caslet.setWeightage(rs3.getString("weightage"));
				caslet.setPhour(rs3.getString("phour"));
				caslet.setOhour(rs3.getString("ohour"));
				caslet.setNf2fhour(rs3.getString("nf2fhour"));
				//caslet.setAsstId(rs3.getString("caslet_id"));
				casletList.add(caslet);
			}
			course.setCourseCasletDist(casletList);

			// FASLET
			ArrayList<FASAndSLT> fasletList = new ArrayList<FASAndSLT>();
			String query4 = "SELECT * FROM FA_SLT WHERE COURSE_CODE = ?";
			PreparedStatement ps4 = conn.prepareStatement(query4);
			ps4.setString(1, courseCode);
			ResultSet rs4 = ps4.executeQuery();

			while (rs4.next()) {

				FASAndSLT faslet = new FASAndSLT();
				faslet.setAsst(rs4.getString("asst"));
				faslet.setWeightage(rs4.getString("weightage"));
				faslet.setPhour(rs4.getString("phour"));
				faslet.setOhour(rs4.getString("ohour"));
				faslet.setNf2fhour(rs4.getString("nf2fhour"));
				//faslet.setAsstId(rs4.getString("faslet_id"));
				fasletList.add(faslet);
			}
			course.setCourseFasletDist(fasletList);
			//course.setTotalFaslet(totalFaslet);
			return course;

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected int update(Course course, String courseCodeOld) // new and old course code conflict
			throws SQLException {

		try {
			String query = "UPDATE COURSE SET " + "COURSE_CODE=?, COURSE_NAME=?, COURSE_CLASSIFICATION=?, "
					+ "COURSE_SYNOPSIS=?, COURSE_ACAD_STAFFS=?, COURSE_SEMYEAR_OFFERED=?, "
					+ "COURSE_CREDIT=?, COURSE_PREREQUISITE=?, COURSE_LEARNING_OUTCOMES=?, "
					+ "COURSE_TRANS_SKILLS=?, COURSE_SLT_DIST=?, COURSE_SPECIAL_REQ=?, "
					+ "COURSE_REFERENCES=?, COURSE_OTHER_INFO=?, COURSE_DATES_APPROVAL=?, "
					+ "COURSE_CLO_PLO_MAPPING = ?, " + "COURSE_TM_FOR_CLO1 = ?, " + "COURSE_TM_FOR_CLO2 = ?, "
					+ "COURSE_TM_FOR_CLO3 = ?, " + "COURSE_AM_FOR_CLO1 = ?, " + "COURSE_AM_FOR_CLO2 = ?, "
					+ "COURSE_AM_FOR_CLO3 = ?, " + "COURSE_MQFLO_PLO_MAPPING = ? " + "WHERE COURSE_CODE=?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, course.getCourseCode());
			ps.setString(2, course.getCourseName());
			ps.setString(3, course.getCourseClassification());
			ps.setString(4, course.getCourseSynopsis());
			ps.setString(5, course.getCourseAcadStaff());
			ps.setString(6, course.getCourseSemYearOffered());
			ps.setString(7, course.getCourseCredit());
			ps.setString(8, course.getCoursePrerequisite());
			ps.setString(9, course.getCourseLearningOutcomes());
			ps.setString(10, course.getCourseTransSkills());
			ps.setString(11, course.getCourseSLTDist());
			ps.setString(12, course.getCourseSpecialReq());
			ps.setString(13, course.getCourseReferences());
			ps.setString(14, course.getCourseOtherInfo());
			ps.setString(15, course.getCourseDatesApproval());
			ps.setString(16, course.getCourseCLOPLOMapping().toString());
			ps.setString(17, course.getTeachingMethodsForCLO1());
			ps.setString(18, course.getTeachingMethodsForCLO2());
			ps.setString(19, course.getTeachingMethodsForCLO3());
			ps.setString(20, course.getAssessmentMethodsForCLO1());
			ps.setString(21, course.getAssessmentMethodsForCLO2());
			ps.setString(22, course.getAssessmentMethodsForCLO3());
			ps.setString(23, course.getMQFLOforPLO().toString());
			ps.setString(24, courseCodeOld);

			//update topicslt
			PreparedStatement ps2 = null;
			String query2 = "DELETE FROM TOPIC_SLT WHERE COURSE_CODE=?";
			ps2 = conn.prepareStatement(query2);
			ps2.setString(1, course.getCourseCode());
			ps2.executeUpdate();

			PreparedStatement ps3 = null;
			for (TopicAndSLT e : course.getCourseSLTDist2()) {

				String query3 = "INSERT INTO TOPIC_SLT(" + "OUTLINE, " + "CLO, " + "PL_HOUR, " + "PT_HOUR, "
						+ "PP_HOUR, " + "PO_HOUR, " + "OL_HOUR, " + "OT_HOUR, " + "OP_HOUR, " + "OO_HOUR, "
						+ "NF2F_HOUR, " + "TSLT_ID," + "COURSE_CODE)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

				ps3 = conn.prepareStatement(query3);
				ps3.setString(1, e.getOutline());
				ps3.setString(2, e.getClo());
				ps3.setInt(3, e.getPlhour());
				ps3.setInt(4, e.getPthour());
				ps3.setInt(5, e.getPphour());
				ps3.setInt(6, e.getPohour());
				ps3.setInt(7, e.getOlhour());
				ps3.setInt(8, e.getOthour());
				ps3.setInt(9, e.getOphour());
				ps3.setInt(10, e.getOohour());
				ps3.setInt(11, e.getNf2fhour());
				ps3.setString(12, e.getTsltId());
				ps3.setString(13, course.getCourseCode());
				ps3.execute();
			}

			//update cas and slt
			PreparedStatement ps4 = null;
			String query4 = "DELETE FROM CA_SLT WHERE COURSE_CODE=?";
			ps4 = conn.prepareStatement(query4);
			ps4.setString(1, course.getCourseCode());
			ps4.executeUpdate();

			PreparedStatement ps5 = null;
			for (CASAndSLT e : course.getCourseCasletDist()) {

				String query5 = "INSERT INTO CA_SLT(caslet_id, asst, weightage, phour, ohour, nf2fhour, course_code) VALUES (?,?,?,?,?,?,?)";

				ps5 = conn.prepareStatement(query5);
				ps5.setString(1, e.getAsstId());
				ps5.setString(2, e.getAsst());
				ps5.setString(3, e.getWeightage());
				ps5.setString(4, e.getPhour());
				ps5.setString(5, e.getOhour());
				ps5.setString(6, e.getNf2fhour());
				ps5.setString(7, course.getCourseCode());
				
				ps5.execute();
			}
			
			//update fas and slt
			PreparedStatement ps6 = null;
			String query6 = "DELETE FROM FA_SLT WHERE COURSE_CODE=?";
			ps6 = conn.prepareStatement(query6);
			ps6.setString(1, course.getCourseCode());
			ps6.executeUpdate();

			PreparedStatement ps7 = null;
			for (FASAndSLT e : course.getCourseFasletDist()) {

				String query7 = "INSERT INTO FA_SLT(faslet_id, asst, weightage, phour, ohour, nf2fhour, course_code) VALUES (?,?,?,?,?,?,?)";

				ps7 = conn.prepareStatement(query7);
				ps7.setString(1, e.getAsstId());
				ps7.setString(2, e.getAsst());
				ps7.setString(3, e.getWeightage());
				ps7.setString(4, e.getPhour());
				ps7.setString(5, e.getOhour());
				ps7.setString(6, e.getNf2fhour());
				ps7.setString(7, course.getCourseCode());
				
				ps7.execute();
			}

			if (ps.executeUpdate() != 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected List<String> getAllTsltId() throws SQLException {

		try {
			String id = "";
			List<String> idList = new ArrayList<String>();
			String query = "SELECT TSLT_ID FROM TOPIC_SLT";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString("TSLT_ID");
				idList.add(id);
			}
			return idList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected List<String> getAllCasletId() throws SQLException {

		try {
			String id = "";
			List<String> idList = new ArrayList<String>();
			String query = "SELECT CASLET_ID FROM CA_SLT";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString("CASLET_ID");
				idList.add(id);
			}
			return idList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected List<String> getAllFasletId() throws SQLException {

		try {
			String id = "";
			List<String> idList = new ArrayList<String>();
			String query = "SELECT FASLET_ID FROM FA_SLT";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString("FASLET_ID");
				idList.add(id);
			}
			return idList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected int delete(String courseCode) throws SQLException {

		try {
			int deleteResult;
			String query = "DELETE FROM COURSE WHERE COURSE_CODE = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, courseCode);

			if (ps.executeUpdate() != 0) {
				deleteResult = 1;
			} else {
				deleteResult = 0;
			}
			return deleteResult;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected void testAddMapping8(Course course) throws SQLException {

		try {
			String query = "INSERT INTO " + "COURSE(COURSE_CODE, " + "COURSE_CLO_PLO_MAPPING, " + "COURSE_TM_FOR_CLO1, "
					+ "COURSE_TM_FOR_CLO2, " + "COURSE_TM_FOR_CLO3, " + "COURSE_AM_FOR_CLO1, " + "COURSE_AM_FOR_CLO2, "
					+ "COURSE_AM_FOR_CLO3, " + "COURSE_MQFLO_PLO_MAPPING) " + "VALUES(?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "COURSE14");
			ps.setString(2, course.getCourseCLOPLOMapping().toString());
			ps.setString(3, course.getTeachingMethodsForCLO1());
			ps.setString(4, course.getTeachingMethodsForCLO2());
			ps.setString(5, course.getTeachingMethodsForCLO3());
			ps.setString(6, course.getAssessmentMethodsForCLO1());
			ps.setString(7, course.getAssessmentMethodsForCLO2());
			ps.setString(8, course.getAssessmentMethodsForCLO3());
			ps.setString(9, course.getMQFLOforPLO().toString());

			ps.execute();
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected Course testReadMapping8(String courseCode) throws SQLException {

		try {
			String query = "SELECT * FROM COURSE WHERE COURSE_CODE = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, courseCode);
			ResultSet rs = ps.executeQuery();
			Course course = new Course();
			while (rs.next()) {
				course.setCourseCode(courseCode);
				course.setCourseCLOPLOMapping(stringToArrayList(rs.getString("COURSE_CLO_PLO_MAPPING")));
				course.setTeachingMethodsForCLO1(rs.getString("COURSE_TM_FOR_CLO1"));
				course.setTeachingMethodsForCLO2(rs.getString("COURSE_TM_FOR_CLO2"));
				course.setTeachingMethodsForCLO3(rs.getString("COURSE_TM_FOR_CLO3"));
				course.setAssessmentMethodsForCLO1(rs.getString("COURSE_AM_FOR_CLO1"));
				course.setAssessmentMethodsForCLO2(rs.getString("COURSE_AM_FOR_CLO2"));
				course.setAssessmentMethodsForCLO3(rs.getString("COURSE_AM_FOR_CLO3"));
				course.setMQFLOforPLO(stringToArrayList(rs.getString("COURSE_MQFLO_PLO_MAPPING")));

			}
			return course;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected int testUpdateMapping8(Course course) throws SQLException {

		try {
			String query = "UPDATE COURSE SET " + "COURSE_CLO_PLO_MAPPING = ?, " + "COURSE_TM_FOR_CLO1 = ?, "
					+ "COURSE_TM_FOR_CLO2 = ?, " + "COURSE_TM_FOR_CLO3 = ?, " + "COURSE_AM_FOR_CLO1 = ?, "
					+ "COURSE_AM_FOR_CLO2 = ?, " + "COURSE_AM_FOR_CLO3 = ?, " + "COURSE_MQFLO_PLO_MAPPING = ? "
					+ "WHERE COURSE_CODE = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, course.getCourseCLOPLOMapping().toString());
			ps.setString(2, course.getTeachingMethodsForCLO1());
			ps.setString(3, course.getTeachingMethodsForCLO2());
			ps.setString(4, course.getTeachingMethodsForCLO3());
			ps.setString(5, course.getAssessmentMethodsForCLO1());
			ps.setString(6, course.getAssessmentMethodsForCLO2());
			ps.setString(7, course.getAssessmentMethodsForCLO3());
			ps.setString(8, course.getMQFLOforPLO().toString());
			ps.setString(9, course.getCourseCode());

			if (ps.executeUpdate() != 0) {
				return 1;
			} else {
				return 0;
			}

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
