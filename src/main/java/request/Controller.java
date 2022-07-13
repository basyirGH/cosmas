package request;

import java.io.IOException;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.Course;
import user.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "request", urlPatterns = { "/request" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String servletInfo = request.getSession().getServletContext().getMajorVersion() + "."
				+ request.getSession().getServletContext().getMinorVersion();
		System.out.println("Servlet Info" + servletInfo);

		String command = request.getParameter("command");
		if (command != null) {
			try {
				switch (command) {
				case "Submit":
					addRequest(request, response);
					break;

				case "hop-get-requests":
					getRequests(request, response);
					break;

				case "use-permission":
					usePermission(request, response);
					break;

				case "update-request-status":
					updateReqStatus(request, response);
					break;

				default:

					break;
				}
			} catch (SQLException e) {
				throw new SQLException(e);
			}
		}

	}
	
	protected void updateReqStatus(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String requestId = request.getParameter("requestId");
		
		DAO dao = new DAO();
		
	}

	protected void usePermission(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String courseCode = request.getParameter("courseCode");
		String courseCodeOld = request.getParameter("courseCodeOld");
		String permission = request.getParameter("permission");

		System.out.println("checking parameters...: " + courseCode + courseCodeOld);

		if (!permission.equals("") && !courseCode.equals("")) {

			DAO dao = new DAO();
			request.getSession().setAttribute("course", dao.getCourse(courseCode));
			request.getSession().setAttribute("courseCodeOld", courseCodeOld);
			request.getRequestDispatcher("edit-course.jsp").forward(request, response);

		} else {
			System.out.println("course code unknown. course code: " + courseCode);
			System.out.println("permission cannot be accepted. permission: " + permission);
		}

	}

	protected void sendEmail(String to, User user, Request req) throws MessagingException {

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.required", "false");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		final String username = "noreply.cosmas@gmail.com";
		final String password = "bsgoskfcgbfbeumb";

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("noreply.cosmas@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
		msg.setSubject("[COSMAS] : New Change Request For Course " + req.getCourseCode());
		msg.setText("A Lecturer or Staff has made a request to modify the following course information: " + "\n\n"
				+ "COURSE CODE: " + req.getCourseCode() + "\nACTION: " + req.getRequestAction() + "\nREQUEST MADE ON: "
				+ req.getRequestMadeOn() + "\n\nYou might find a message and additional info from the Staff below. "
				+ "If it's blank then no message was submitted with this request." + "\n\n" + "\""
				+ req.getRequestMessage() + "\"" + "\nFrom Staff: " + req.getUserId() + "\n"
				+ "\nThis request is pending your approval/rejection because you have registered as a Head of Programme"
				+ "\nin COSMAS. Kindly make a prompt status update to this request."
				+ "\n\n--This message is auto-generated by COSMAS. Please do not reply to this email.--");

		msg.setSentDate(new Date());
		Transport.send(msg);
		System.out.println("Message sent.");
	}

	protected void getRequests(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		List<Request> requestList = new ArrayList<Request>();
		DAO dao = new DAO();
		User user = (User) request.getSession().getAttribute("loggedIn");

		requestList = dao.getRequests(user.getUserID());
		request.getSession().setAttribute("requestList", requestList);
		request.getSession().setAttribute("loggedIn", user);

		RequestDispatcher rd = request.getRequestDispatcher("hopmode-requests.jsp");
		rd.forward(request, response);
	}

	protected boolean idIsTaken(String id) throws SQLException, ServletException, IOException {

		DAO dao = new DAO();
		List<String> idList = dao.getAllRequestId();

		for (String e : idList) {
			if (e.equals(id)) {
				return true;
			}
		}

		return false;

	}

	protected String generateRandom(int n) {
		String AlphaNumericString = "0123456789";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	protected String getNewId(int n) throws SQLException, ServletException, IOException {

		String id = "REQ";
		id = id.concat(generateRandom(n));

		while (idIsTaken(id)) {
			id = id.concat(generateRandom(n));
		}

		return id;

	}

	protected void addRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		if (request.getSession() != null && request.getSession().getAttribute("isLoggedIn").equals(true)) {
			long millis = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(millis);

			String requestId = getNewId(7);
			String requestAction = request.getParameter("requestAction");
			String requestMessage = request.getParameter("requestMessage");
			Timestamp requestMadeOn = timestamp;
			String requestStatus = "PENDING";

			User user = new User();
			user = (User) request.getSession().getAttribute("loggedIn");
			System.out.println("test user at request page: " + user.getUserID() + user.getUserRole()
					+ user.getSendEmail() + user.getUserPassword());
			String userId = user.getUserID();

			Course course = new Course();
			course = (Course) request.getSession().getAttribute("course");
			System.out.println("test course at request page: " + course.getCourseName());
			String courseCode = course.getCourseCode();

			Request req = new Request();
			req.setRequestId(requestId);
			req.setRequestAction(requestAction);
			req.setRequestMadeOn(requestMadeOn);
			req.setRequestMessage(requestMessage);
			req.setRequestStatus(requestStatus);
			req.setUserId(userId);
			req.setCourseCode(courseCode);

			System.out.println(req.getRequestId());

			DAO dao = new DAO();
			dao.add(req);

			String sendEmail = user.getSendEmail();

			if (sendEmail.equals("YES")) {
				try {
					sendEmail("S55688@ocean.umt.edu.my", user, req);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("courses.jsp");
			rd.forward(request, response);

		} else {
			throw new ServletException("Please login first.");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doCommand(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doCommand(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
