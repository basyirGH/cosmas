package course;

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
						System.out.println(plo + " for " + s + " found");
					}
					else {
						System.out.println(plo + " for " + s + " not found");
					}
				}
			}
			return ploCount;
		}
		catch (SQLException e) {
            throw new SQLException(e);
        } finally {
        	if (plo.equals("PLO11")) {
            	conn.close();
        	}
        }
	}

    protected void add(Course course) throws SQLException {
    	
    	try {
            String query = "INSERT INTO "
        				 + "COURSE("
        				 + "COURSE_CODE, COURSE_NAME, COURSE_CLASSIFICATION, "
        				 + "COURSE_SYNOPSIS, COURSE_ACAD_STAFFS, COURSE_SEMYEAR_OFFERED, "
        				 + "COURSE_CREDIT, COURSE_PREREQUISITE, COURSE_LEARNING_OUTCOMES, "
        				 + "COURSE_TRANS_SKILLS , COURSE_SLT_DIST, COURSE_SPECIAL_REQ, "
        				 + "COURSE_REFERENCES, COURSE_OTHER_INFO, COURSE_DATES_APPROVAL, "
        				 + "COURSE_CLO_PLO_MAPPING, "
           				 + "COURSE_TM_FOR_CLO1, "
           				 + "COURSE_TM_FOR_CLO2, "
           				 + "COURSE_TM_FOR_CLO3, "
           				 + "COURSE_AM_FOR_CLO1, "
           				 + "COURSE_AM_FOR_CLO2, "
           				 + "COURSE_AM_FOR_CLO3, "
           				 + "COURSE_MQFLO_PLO_MAPPING) "
                         + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
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
           
            ps.execute();
            
            System.out.println("test receive at dao mqflo: " + course.getMQFLOforPLO().toString());
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
        	conn.close();
        }
    }

    protected List<Course> getList() 
    		throws SQLException {
    	
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
    		return courseList;
    	} catch (SQLException e) {
    		throw new SQLException(e);
    	} finally {
            conn.close();
        }
    }
    
    protected Course getCourse(String courseCode) 
    		throws SQLException {
    	
    	try {
	    	String query = "SELECT * FROM COURSE WHERE COURSE_CODE = ?";
	    	PreparedStatement ps = conn.prepareStatement(query);
	    	ps.setString(1,  courseCode);
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
	    	}
	    	return course;
    	} catch (SQLException e) {
    		throw new SQLException(e);
    	} finally {
        	conn.close();
        }
    }
    
    protected int update(Course course, String courseCodeOld) //new and old course code conflict
    		throws SQLException {
    	
    	try {
    		String query = "UPDATE COURSE SET "
   				 + "COURSE_CODE=?, COURSE_NAME=?, COURSE_CLASSIFICATION=?, "
   				 + "COURSE_SYNOPSIS=?, COURSE_ACAD_STAFFS=?, COURSE_SEMYEAR_OFFERED=?, "
   				 + "COURSE_CREDIT=?, COURSE_PREREQUISITE=?, COURSE_LEARNING_OUTCOMES=?, "
   				 + "COURSE_TRANS_SKILLS=?, COURSE_SLT_DIST=?, COURSE_SPECIAL_REQ=?, "
   				 + "COURSE_REFERENCES=?, COURSE_OTHER_INFO=?, COURSE_DATES_APPROVAL=?, "
   				 + "COURSE_CLO_PLO_MAPPING = ?, "
   				 + "COURSE_TM_FOR_CLO1 = ?, "
   				 + "COURSE_TM_FOR_CLO2 = ?, "
   				 + "COURSE_TM_FOR_CLO3 = ?, "
   				 + "COURSE_AM_FOR_CLO1 = ?, "
   				 + "COURSE_AM_FOR_CLO2 = ?, "
   				 + "COURSE_AM_FOR_CLO3 = ?, "
   				 + "COURSE_MQFLO_PLO_MAPPING = ? "
                 + "WHERE COURSE_CODE=?";
       
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
		    
		    System.out.println("check receive value old course code: "  + courseCodeOld);
		    System.out.println("check receive values at dao" + courseCodeOld + course.getCourseCode() + course.getCourseCLOPLOMapping().toString() + course.getMQFLOforPLO().toString());
		    
	    	if (ps.executeUpdate() != 0) {
	    		return 1;
	    	} 
	    	else {
	    		return 0;
	    	}
	    	
    	} catch (SQLException e) {
    		throw new SQLException(e);
    	} finally {
    		conn.close();
    	}    	
    }
 
    protected int delete(String courseCode) 
    		throws SQLException {
    	
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
	    		String query = "INSERT INTO "
       				 + "COURSE(COURSE_CODE, " 
       				 + "COURSE_CLO_PLO_MAPPING, "
       				 + "COURSE_TM_FOR_CLO1, "
       				 + "COURSE_TM_FOR_CLO2, "
       				 + "COURSE_TM_FOR_CLO3, "
       				 + "COURSE_AM_FOR_CLO1, "
       				 + "COURSE_AM_FOR_CLO2, "
       				 + "COURSE_AM_FOR_CLO3, "
       				 + "COURSE_MQFLO_PLO_MAPPING) "
                     + "VALUES(?,?,?,?,?,?,?,?,?)";
	            
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
	    	ps.setString(1,  courseCode);
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
    		String query = "UPDATE COURSE SET "
   				 + "COURSE_CLO_PLO_MAPPING = ?, "
   				 + "COURSE_TM_FOR_CLO1 = ?, "
   				 + "COURSE_TM_FOR_CLO2 = ?, "
   				 + "COURSE_TM_FOR_CLO3 = ?, "
   				 + "COURSE_AM_FOR_CLO1 = ?, "
   				 + "COURSE_AM_FOR_CLO2 = ?, "
   				 + "COURSE_AM_FOR_CLO3 = ?, "
   				 + "COURSE_MQFLO_PLO_MAPPING = ? "
                 + "WHERE COURSE_CODE = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, course.getCourseCLOPLOMapping().toString());
            ps.setString(2, course.getTeachingMethodsForCLO1());
            ps.setString(3, course.getTeachingMethodsForCLO2());
            ps.setString(4, course.getTeachingMethodsForCLO3());
            ps.setString(5, course.getAssessmentMethodsForCLO1());
            ps.setString(6, course.getAssessmentMethodsForCLO2());
            ps.setString(7, course.getAssessmentMethodsForCLO3());
            ps.setString(8,  course.getMQFLOforPLO().toString());
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
		}
		catch (NullPointerException ex) {
			System.out.println("Database returns null value to converting from string to arraylist. course code or name received could be null/mismatched somewhere" + "\n " + ex);
		}
		
    	ArrayList<Character> charArrayList = new ArrayList<Character>();
    	ArrayList<String> arrayList = new ArrayList<String>();
    	String temp = "";
    	
    	for (char c : charArray) {
    		charArrayList.add(c);
    	}
    	
    	for (int i=0; i<charArrayList.size(); i++) {
    		char c = charArrayList.get(i);
    		if (c != delimiter && c != openBracket && c != closeBracket) {
    			temp = temp + String.valueOf(c);
    		}
    		
    		if (c == delimiter || i == charArrayList.size()-2) {
    			arrayList.add(temp);
    			temp = "";
    		}
    	}
    	
    
    	return arrayList;
	}
}
