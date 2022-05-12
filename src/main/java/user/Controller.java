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


@WebServlet("/ControllerUser")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public Controller() {
        super();
    }
    
    protected void doCommand(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException, SQLException {
		
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	String serverInfo=request.getSession().getServletContext().getServerInfo();
        System.out.println("Server Info" + serverInfo);
        String servletInfo= request.getSession().getServletContext().getMajorVersion() + "." +  request.getSession().getServletContext().getMinorVersion();
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
                    	             
                	default:
                		break;
                }
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
	}
    
    protected void signUpUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        String userEmail = request.getParameter("userEmail");
        String userPassword = AES.encrypt(request.getParameter("userPassword"), "baby_piglin");
        String userName = request.getParameter("userName");
        String userRole = request.getParameter("userRole");
        String sendEmail = request.getParameter("sendEmail");
        
        User user = new User();
        user.setUserEmail(userEmail);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        user.setUserRole(userRole);
        user.setSendEmail("YES");
        user.setUserID("U0008");
       
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
        String tryPassword =  AES.encrypt(request.getParameter("userPassword"), "baby_piglin");
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
    		System.out.println("user role at controller: "+user.getUserRole());
    		request.getSession().setAttribute("loggedIn", user);
    		//System.out.println("email: " + user.getUserEmail() + customer.getPostcode());
    		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
    		rd.forward(request, response);
    	} else {
    		throw new ServletException("Please login first.");
    	}
    }
    
    /*
    protected void logOut(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException, SQLException {
    	
    	request.getSession().invalidate();
    	request.getSession(true).setAttribute("cause", "loggedOut");
    	RequestDispatcher rd = request.getRequestDispatcher("/customer/login.jsp");
    	rd.forward(request, response);
    }*/
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            doCommand(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            doCommand(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	} 
}
