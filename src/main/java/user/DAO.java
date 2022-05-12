/*
 * Controller
 * 
 * v1.0
 * 
 * Author: Basyir Zainuddin
 * 
 * Purpose: This Java Source File ...
 */

package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

import connector.ConnectionManager;


public class DAO {
	
	private static Connection conn = null;
	
	public DAO() {
		conn = ConnectionManager.getConnection();
	}

    protected void add(User user) throws SQLException {
    	
    	try {
            String query = "INSERT INTO "
        				 + "USER(USER_EMAIL, USER_ID, USER_PASSWORD, "
        				 + "USER_NAME, USER_ROLE, SEND_EMAIL) "
                         + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUserEmail());
            ps.setString(2, user.getUserID());
            ps.setString(3, user.getUserPassword());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getUserRole());
            ps.setString(6, user.getSendEmail());
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
        	conn.close();
        }
    }

    private HashMap<String, String> getLoginsHashMap() throws SQLException {
    	
    	HashMap<String, String> userLoginsHashMap = null;
    	try {
    		String query = "SELECT USER_EMAIL, USER_PASSWORD FROM USER";
    		PreparedStatement ps = conn.prepareStatement(query);
    		ResultSet rs = ps.executeQuery();
    		userLoginsHashMap = new HashMap<String, String>();
    		String authKey = null;
    		String authValue = null;
    		while (rs.next()) {
    			authKey = rs.getString(1);
    			authValue = rs.getString(2);
    			userLoginsHashMap.put(authKey, authValue);   
    		}
    		return userLoginsHashMap;
    	} catch (SQLException e) {
    		throw new SQLException(e);
        } finally {
        	conn.close();
        }
    }
    
    protected boolean isLoginCorrect(String tryEmail, String hashedTryPassword) 
    		throws SQLException {
    	
    	boolean isLoggedIn = false;
    	HashMap<String, String> userCredentialHashMap = null;
		userCredentialHashMap = getLoginsHashMap();
		String hashMapPassword = String.valueOf(userCredentialHashMap.get(tryEmail));
		if (hashMapPassword != null) {
			if (hashedTryPassword.equals(hashMapPassword)) {
				isLoggedIn = true;
			} else {
				isLoggedIn = false;
			}
		} else {
			isLoggedIn = false;
		}
		return isLoggedIn;
    }
    /*
    protected List<Customer> getList() 
    		throws SQLException {
    	
    	try {
    		List<Customer> customersList = new ArrayList<Customer>();
    		String query = "SELECT * FROM CUSTOMER";
    		PreparedStatement ps = conn.prepareStatement(query);
    		ResultSet rs = ps.executeQuery();
    		while (rs.next()) {
    			Customer customer = new Customer();
    			customer.setEmail(rs.getString("CUSTOMER_EMAIL"));
    			customer.setPassword(rs.getString("CUSTOMER_PWD"));
    			customer.setName(rs.getString("CUSTOMER_NAME"));
    			customer.setPhone(rs.getString("CUSTOMER_PHONE"));
    			customer.setFullAddress(rs.getString("CUSTOMER_ADDR"));
    			customer.setPostcode(rs.getString("CUSTOMER_PCODE"));
    			customer.setCity(rs.getString("CUSTOMER_CITY"));
    			customer.setState(rs.getString("CUSTOMER_STATE"));
    			customersList.add(customer);
    		}
    		return customersList;
    	} catch (SQLException e) {
    		throw new SQLException(e);
    	} finally {
            conn.close();
        }
    }*/
    
    
    protected User getAttributes(HttpSession loggedIn) 
    		throws SQLException {
    	
    	try {
	    	String query = "SELECT * FROM USER WHERE USER_EMAIL = ?";
	    	PreparedStatement ps = conn.prepareStatement(query);
	    	String userEmail = String.valueOf(loggedIn.getAttribute("userEmail"));
	    	ps.setString(1,  userEmail);
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
    /*
    protected Customer update(HttpSession loggedIn, Customer customerEdit, String updateType) 
    		throws SQLException {
    	
    	try {
	    	switch (updateType) {
	    		case "identification" : {
	    	    	String query = "UPDATE CUSTOMER SET "
		    				     + "CUSTOMER_EMAIL = ?, "
	    		    			 + "CUSTOMER_PWD = ?, "
	    		    			 + "CUSTOMER_NAME = ?, "
	    		    			 + "CUSTOMER_PHONE = ? "
	    		    			 + "WHERE CUSTOMER_EMAIL = ?";
	    	    	PreparedStatement ps = conn.prepareStatement(query);
	    	    	ps.setString(1, customerEdit.getEmail());
	    	    	ps.setString(2, customerEdit.getPassword());
	    	    	ps.setString(3, customerEdit.getName());
	    	    	ps.setString(4, customerEdit.getPhone());
	    	    	ps.setString(5, String.valueOf(loggedIn.getAttribute("email")));
	    	    	if (ps.executeUpdate() != 0) {
	    	    		return customerEdit;
	    	    	} else {
	    	    		return null;
	    	    	}
	    		} 
	    		case "address" : {
	    	    	String query = "UPDATE CUSTOMER SET "
		    				     + "CUSTOMER_ADDR = ?, "
	    		    			 + "CUSTOMER_PCODE = ?, "
	    		    			 + "CUSTOMER_CITY = ?, "
	    		    			 + "CUSTOMER_STATE = ? "
	    		    			 + "WHERE CUSTOMER_EMAIL = ?";
	    	    	PreparedStatement ps = conn.prepareStatement(query);
	    	    	ps.setString(1, customerEdit.getFullAddress());
	    	    	ps.setString(2, customerEdit.getPostcode());
	    	    	ps.setString(3, customerEdit.getCity());
	    	    	ps.setString(4, customerEdit.getState());
	    	    	ps.setString(5, String.valueOf(loggedIn.getAttribute("email")));
	    	    	if (ps.executeUpdate() != 0) {
	    	    		return customerEdit;
	    	    	} else {
	    	    		return null;
	    	    	}
	    		} 
	    		default : return null;
	    	}
    	} catch (SQLException e) {
    		throw new SQLException(e);
    	} finally {
    		conn.close();
    	}    	
    }
    
    protected int delete(HttpSession loggedIn, Customer customer) 
    		throws SQLException {
    	
    	try {
    		int deleteResult;
    		String query = "DELETE FROM CUSTOMER WHERE CUSTOMER_EMAIL = ?";
    		PreparedStatement ps = conn.prepareStatement(query);
    		ps.setString(1, String.valueOf(loggedIn.getAttribute("email")));
    		
    		if (ps.executeUpdate() != 0) {
    			deleteResult = 1;
    		} else {
    			deleteResult = -1;
    		}
    		return deleteResult;
    	} catch (SQLException e) {
    		throw new SQLException(e);
    	} finally {
            conn.close();
        }
    }*/
}
