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

package user;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user")
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
				case "Sign Up":
					signUpUser(request, response);
					break;

				case "Log In":
					loginUser(request, response);
					break;

				case "Home":
					getUser(request, response);
					break;

				case "logout":
					logOut(request, response);
					break;

				default:
					break;
				}
			} catch (SQLException e) {
				throw new SQLException(e);
			} catch (NullPointerException e) {
				RequestDispatcher rd = request.getRequestDispatcher("log-in.jsp");
				rd.forward(request, response);
				System.out.println("please login first.");
			} 
		}
	}

	protected boolean idIsTaken(String id) throws SQLException, ServletException, IOException {

		DAO dao = new DAO();
		List<String> idList = dao.getAllUserId();

		for (String e : idList) {
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

	protected String getNewId(int n) throws SQLException, ServletException, IOException {

		String id = "USER";
		id = id.concat(generateRandom(n));

		while (idIsTaken(id)) {
			id = id.concat(generateRandom(n));
		}

		return id;

	}

	protected void signUpUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String userEmail = request.getParameter("userEmail");
		String userPassword = AES.encrypt(request.getParameter("userPassword"), "baby_piglin");
		String userName = request.getParameter("userName");
		String userRole = request.getParameter("userRole");
		String sendEmail = request.getParameter("sendEmail");
		String userId = getNewId(5);

		User user = new User();
		user.setUserEmail(userEmail);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setUserRole(userRole);
		user.setSendEmail("YES");
		user.setUserID(userId);

		DAO dao = new DAO();
		dao.add(user);
		HttpSession loggedIn = request.getSession();
		loggedIn.setAttribute("loggedIn", user);
		loggedIn.setAttribute("userEmail", userEmail);
		loggedIn.setAttribute("isLoggedIn", true);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	protected void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String tryEmail = request.getParameter("userEmail");
		String tryPassword = AES.encrypt(request.getParameter("userPassword"), "baby_piglin");
		boolean isLoggedIn = false;
		DAO dao = new DAO();
		isLoggedIn = dao.isLoginCorrect(tryEmail, tryPassword);
		if (isLoggedIn == true) {
			User user = new User();
			user.setUserEmail(tryEmail);
			request.getSession().setAttribute("userEmail", tryEmail);
			request.getSession().setAttribute("isLoggedIn", true);
			getUser(request, response);
		} else {
			request.getSession().setAttribute("cause", "incorrectLogin");
			RequestDispatcher rd = request.getRequestDispatcher("incorrect-login.jsp");
			rd.forward(request, response);
		}
	}

	protected void getUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		if (request.getSession() != null && request.getSession().getAttribute("isLoggedIn").equals(true)) {
			DAO dao = new DAO();
			User user = dao.getAttributes(request.getSession());
			System.out.println("user role at controller: " + user.getUserRole());
			request.getSession().setAttribute("loggedIn", user);
			// System.out.println("email: " + user.getUserEmail() + customer.getPostcode());
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("log-in.jsp");
			rd.forward(request, response);
			throw new ServletException("Please login first.");
		}
	}

	protected void logOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("logging out..session id: " + request.getSession().getId());
		request.getSession().invalidate();
		
		HttpSession session = request.getSession(true);
		System.out.println("Creating new session...: " + session.getId());
		RequestDispatcher rd = request.getRequestDispatcher("log-in.jsp");
		rd.forward(request, response);
		//getUser(request, response);
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
