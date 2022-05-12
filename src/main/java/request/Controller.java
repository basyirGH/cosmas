package request;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

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
@WebServlet(name = "ControllerRequest", urlPatterns = { "/ControllerRequest" })
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
		String serverInfo = request.getSession().getServletContext().getServerInfo();
		System.out.println("Server Info" + serverInfo);
		String servletInfo = request.getSession().getServletContext().getMajorVersion() + "."
				+ request.getSession().getServletContext().getMinorVersion();
		System.out.println("Servlet Info" + servletInfo);

		String command = request.getParameter("command");
		if (command != null) {
			try {
				switch (command) {
				case "Add Request":
					addRequest(request, response);
					break;

				default:

					break;
				}
			} catch (SQLException e) {
				throw new SQLException(e);
			}
		}

	}

	protected void addRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		if (request.getSession() != null && request.getSession().getAttribute("isLoggedIn").equals(true)) {
			String requestId = request.getParameter("requestId");
			String requestAction = request.getParameter("requestAction");
			String requestMessage = request.getParameter("requestMessage");
			//Date requestMadeOn = Date.valueOf(request.getParameter("requestMadeOn"));
			String requestStatus = "pending";
			// String attrId;

			User user = new User();
			user = (User) request.getSession().getAttribute("loggedIn");
			System.out.println("test user at request page: " + user.getUserID());
			String userId = user.getUserID();

			Course course = new Course();
			course = (Course) request.getSession().getAttribute("course");
			System.out.println("test course at request page: " + course.getCourseName());
			String courseCode = course.getCourseCode();

			Request req = new Request();
			req.setRequestId("testaddreq");
			req.setRequestAction("testaddreq");
			req.setRequestMadeOn(null);
			req.setRequestMessage("testaddreq");
			req.setRequestStatus("testaddreq");
			req.setUserId(userId);
			req.setCourseCode(courseCode);

			DAO dao = new DAO();
			dao.add(req);

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
