package course;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.rowset.serial.SerialBlob;

public class Course implements java.io.Serializable{

	private String courseCode;
	private String courseName;
	private String courseClassification;
	private String courseSynopsis;
	private String courseAcadStaff;
	private String courseSemYearOffered;
	private String courseCredit;
	private String coursePrerequisite;
	private String courseLearningOutcomes;
	private ArrayList<String> courseCLOPLOMapping = new ArrayList<String>();
	private String teachingMethodsForCLO1;
	private String teachingMethodsForCLO2;
	private String teachingMethodsForCLO3;
	private String assessmentMethodsForCLO1;
	private String assessmentMethodsForCLO2;
	private String assessmentMethodsForCLO3;
	private ArrayList<String> MQFLOforPLO = new ArrayList<String>();
	private String courseTransSkills;
	private String courseSLTDist;
	private ArrayList<TopicAndSLT> courseSLTDist2;
	private ArrayList<CASAndSLT> courseCasletDist;
	private ArrayList<FASAndSLT> courseFasletDist;
	private String courseSpecialReq;
	private String courseReferences;
	private String courseOtherInfo;
	private String courseDatesApproval;
	private int totalToslet;
	private int totalCaslet;
	private int totalFaslet;
	private int grandTotalSLT;
	
	
	

	public int getGrandTotalSLT() {
		return grandTotalSLT;
	}

	public void setGrandTotalSLT(int grandTotalSLT) {
		this.grandTotalSLT = grandTotalSLT;
	}

	public int getTotalToslet() {
		return totalToslet;
	}

	public void setTotalToslet(int totalToslet) {
		this.totalToslet = totalToslet;
	}

	public int getTotalCaslet() {
		return totalCaslet;
	}

	public void setTotalCaslet(int totalCaslet) {
		this.totalCaslet = totalCaslet;
	}

	public int getTotalFaslet() {
		return totalFaslet;
	}

	public void setTotalFaslet(int totalFaslet) {
		this.totalFaslet = totalFaslet;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseClassification() {
		return courseClassification;
	}

	public void setCourseClassification(String courseClassification) {
		this.courseClassification = courseClassification;
	}

	public String getCourseSynopsis() {
		return courseSynopsis;
	}

	public void setCourseSynopsis(String courseSynopsis) {
		this.courseSynopsis = courseSynopsis;
	}

	public String getCourseAcadStaff() {
		return courseAcadStaff;
	}

	public void setCourseAcadStaff(String courseAcadStaff) {
		this.courseAcadStaff = courseAcadStaff;
	}

	public String getCourseSemYearOffered() {
		return courseSemYearOffered;
	}

	public void setCourseSemYearOffered(String courseSemYearOffered) {
		this.courseSemYearOffered = courseSemYearOffered;
	}

	public String getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(String courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getCoursePrerequisite() {
		return coursePrerequisite;
	}

	public void setCoursePrerequisite(String coursePrerequisite) {
		this.coursePrerequisite = coursePrerequisite;
	}

	public String getCourseLearningOutcomes() {
		return courseLearningOutcomes;
	}

	public void setCourseLearningOutcomes(String courseLearningOutcomes) {
		this.courseLearningOutcomes = courseLearningOutcomes;
	}

	public ArrayList<String> getCourseCLOPLOMapping() {
		return courseCLOPLOMapping;
	}

	public void setCourseCLOPLOMapping(ArrayList<String> courseCLOPLOMapping) {
		this.courseCLOPLOMapping = courseCLOPLOMapping;
	}

	public String getTeachingMethodsForCLO1() {
		return teachingMethodsForCLO1;
	}

	public void setTeachingMethodsForCLO1(String teachingMethodsForCLO1) {
		this.teachingMethodsForCLO1 = teachingMethodsForCLO1;
	}

	public String getTeachingMethodsForCLO2() {
		return teachingMethodsForCLO2;
	}

	public void setTeachingMethodsForCLO2(String teachingMethodsForCLO2) {
		this.teachingMethodsForCLO2 = teachingMethodsForCLO2;
	}

	public String getTeachingMethodsForCLO3() {
		return teachingMethodsForCLO3;
	}

	public void setTeachingMethodsForCLO3(String teachingMethodsForCLO3) {
		this.teachingMethodsForCLO3 = teachingMethodsForCLO3;
	}

	public String getAssessmentMethodsForCLO1() {
		return assessmentMethodsForCLO1;
	}

	public void setAssessmentMethodsForCLO1(String assessmentMethodsForCLO1) {
		this.assessmentMethodsForCLO1 = assessmentMethodsForCLO1;
	}

	public String getAssessmentMethodsForCLO2() {
		return assessmentMethodsForCLO2;
	}

	public void setAssessmentMethodsForCLO2(String assessmentMethodsForCLO2) {
		this.assessmentMethodsForCLO2 = assessmentMethodsForCLO2;
	}

	public String getAssessmentMethodsForCLO3() {
		return assessmentMethodsForCLO3;
	}

	public void setAssessmentMethodsForCLO3(String assessmentMethodsForCLO3) {
		this.assessmentMethodsForCLO3 = assessmentMethodsForCLO3;
	}

	public ArrayList<String> getMQFLOforPLO() {
		return MQFLOforPLO;
	}

	public void setMQFLOforPLO(ArrayList<String> mQFLOforPLO) {
		MQFLOforPLO = mQFLOforPLO;
	}

	public String getCourseTransSkills() {
		return courseTransSkills;
	}

	public void setCourseTransSkills(String courseTransSkills) {
		this.courseTransSkills = courseTransSkills;
	}

	public String getCourseSLTDist() {
		return courseSLTDist;
	}

	public void setCourseSLTDist(String courseSLTDist) {
		this.courseSLTDist = courseSLTDist;
	}

	public ArrayList<TopicAndSLT> getCourseSLTDist2() {
		return courseSLTDist2;
	}

	public void setCourseSLTDist2(ArrayList<TopicAndSLT> courseSLTDist2) {
		this.courseSLTDist2 = courseSLTDist2;
	}

	public String getCourseSpecialReq() {
		return courseSpecialReq;
	}

	public void setCourseSpecialReq(String courseSpecialReq) {
		this.courseSpecialReq = courseSpecialReq;
	}

	public String getCourseReferences() {
		return courseReferences;
	}

	public void setCourseReferences(String courseReferences) {
		this.courseReferences = courseReferences;
	}

	public String getCourseOtherInfo() {
		return courseOtherInfo;
	}

	public void setCourseOtherInfo(String courseOtherInfo) {
		this.courseOtherInfo = courseOtherInfo;
	}

	public String getCourseDatesApproval() {
		return courseDatesApproval;
	}

	public void setCourseDatesApproval(String courseDatesApproval) {
		this.courseDatesApproval = courseDatesApproval;
	}

	public ArrayList<CASAndSLT> getCourseCasletDist() {
		return courseCasletDist;
	}

	public void setCourseCasletDist(ArrayList<CASAndSLT> courseCasletDist) {
		this.courseCasletDist = courseCasletDist;
	}

	public ArrayList<FASAndSLT> getCourseFasletDist() {
		return courseFasletDist;
	}

	public void setCourseFasletDist(ArrayList<FASAndSLT> courseFasletDist) {
		this.courseFasletDist = courseFasletDist;
	}
	
	
	

}
