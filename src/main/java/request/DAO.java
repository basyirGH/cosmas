/*
 * Controller
 * 
 * v1.0
 * 
 * Author: Basyir Zainuddin
 * 
 * Purpose: This Java Source File ...
 */

package request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

import connector.ConnectionManager;
import course.Course;
import course.TopicAndSLT;
import user.User;

public class DAO {

	private static Connection conn = null;

	public DAO() {
		conn = ConnectionManager.getConnection();
	}
	
	protected Course getCourse(String courseCode) throws SQLException {

		try {
			System.out.println("getting course details...course code: " + courseCode);
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
				//course.setCourseSLTDist(rs.getString("COURSE_SLT_DIST"));
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
			}

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

	protected void add(Request req) throws SQLException {

		try {
			String query = "INSERT INTO " + "REQUEST(REQUEST_ID, REQUEST_ACTION, REQUEST_MESSAGE, "
					+ "REQUEST_STATUS, USER_ID, REQUEST_MADE_ON, COURSE_CODE) " + "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, req.getRequestId());
			ps.setString(2, req.getRequestAction());
			ps.setString(3, req.getRequestMessage());
			ps.setString(4, req.getRequestStatus());
			ps.setString(5, req.getUserId());
			ps.setTimestamp(6, req.getRequestMadeOn());
			ps.setString(7, req.getCourseCode());
			ps.execute();

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}

	protected List<String> getAllRequestId() throws SQLException {

		try {
			String id = "";
			List<String> idList = new ArrayList<String>();
			String query = "SELECT REQUEST_ID FROM REQUEST";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString("REQUEST_ID");
				idList.add(id);
			}
			return idList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}
	
	protected List<Request> getRequests(String userId) throws SQLException {

		try {
			List<Request> reqList = new ArrayList<Request>();
			String query = "SELECT * FROM REQUEST ORDER BY REQUEST_MADE_ON DESC";
			PreparedStatement ps = conn.prepareStatement(query);
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
				
				reqList.add(req);
			}
			System.out.println("reqlist: " + reqList.toString());
			return reqList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			conn.close();
		}
	}
	
	/*
	 * protected List<Customer> getList() throws SQLException {
	 * 
	 * try { List<Customer> customersList = new ArrayList<Customer>(); String query
	 * = "SELECT * FROM CUSTOMER"; PreparedStatement ps =
	 * conn.prepareStatement(query); ResultSet rs = ps.executeQuery(); while
	 * (rs.next()) { Customer customer = new Customer();
	 * customer.setEmail(rs.getString("CUSTOMER_EMAIL"));
	 * customer.setPassword(rs.getString("CUSTOMER_PWD"));
	 * customer.setName(rs.getString("CUSTOMER_NAME"));
	 * customer.setPhone(rs.getString("CUSTOMER_PHONE"));
	 * customer.setFullAddress(rs.getString("CUSTOMER_ADDR"));
	 * customer.setPostcode(rs.getString("CUSTOMER_PCODE"));
	 * customer.setCity(rs.getString("CUSTOMER_CITY"));
	 * customer.setState(rs.getString("CUSTOMER_STATE"));
	 * customersList.add(customer); } return customersList; } catch (SQLException e)
	 * { throw new SQLException(e); } finally { conn.close(); } }
	 */

	protected User getAttributes(HttpSession loggedIn) throws SQLException {

		try {
			String query = "SELECT * FROM USER WHERE USER_EMAIL = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			String userEmail = String.valueOf(loggedIn.getAttribute("userEmail"));
			ps.setString(1, userEmail);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			while (rs.next()) {
				user.setUserID(rs.getString("USER_ID"));
				user.setUserEmail(rs.getString("USER_EMAIL"));
				user.setUserPassword(rs.getString("USER_PASSWORD"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserRole(rs.getString("USER_ROLE"));
			}
			return user;
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
	/*
	 * protected Customer update(HttpSession loggedIn, Customer customerEdit, String
	 * updateType) throws SQLException {
	 * 
	 * try { switch (updateType) { case "identification" : { String query =
	 * "UPDATE CUSTOMER SET " + "CUSTOMER_EMAIL = ?, " + "CUSTOMER_PWD = ?, " +
	 * "CUSTOMER_NAME = ?, " + "CUSTOMER_PHONE = ? " + "WHERE CUSTOMER_EMAIL = ?";
	 * PreparedStatement ps = conn.prepareStatement(query); ps.setString(1,
	 * customerEdit.getEmail()); ps.setString(2, customerEdit.getPassword());
	 * ps.setString(3, customerEdit.getName()); ps.setString(4,
	 * customerEdit.getPhone()); ps.setString(5,
	 * String.valueOf(loggedIn.getAttribute("email"))); if (ps.executeUpdate() != 0)
	 * { return customerEdit; } else { return null; } } case "address" : { String
	 * query = "UPDATE CUSTOMER SET " + "CUSTOMER_ADDR = ?, " +
	 * "CUSTOMER_PCODE = ?, " + "CUSTOMER_CITY = ?, " + "CUSTOMER_STATE = ? " +
	 * "WHERE CUSTOMER_EMAIL = ?"; PreparedStatement ps =
	 * conn.prepareStatement(query); ps.setString(1, customerEdit.getFullAddress());
	 * ps.setString(2, customerEdit.getPostcode()); ps.setString(3,
	 * customerEdit.getCity()); ps.setString(4, customerEdit.getState());
	 * ps.setString(5, String.valueOf(loggedIn.getAttribute("email"))); if
	 * (ps.executeUpdate() != 0) { return customerEdit; } else { return null; } }
	 * default : return null; } } catch (SQLException e) { throw new
	 * SQLException(e); } finally { conn.close(); } }
	 * 
	 * protected int delete(HttpSession loggedIn, Customer customer) throws
	 * SQLException {
	 * 
	 * try { int deleteResult; String query =
	 * "DELETE FROM CUSTOMER WHERE CUSTOMER_EMAIL = ?"; PreparedStatement ps =
	 * conn.prepareStatement(query); ps.setString(1,
	 * String.valueOf(loggedIn.getAttribute("email")));
	 * 
	 * if (ps.executeUpdate() != 0) { deleteResult = 1; } else { deleteResult = -1;
	 * } return deleteResult; } catch (SQLException e) { throw new SQLException(e);
	 * } finally { conn.close(); } }
	 */
}
