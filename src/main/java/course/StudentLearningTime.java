package course;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentLearningTime extends Course{

	private String courseCode;
	private String topic;
	private ArrayList<Float> clo;
	private HashMap<String, Float> physicalHours = new HashMap<String, Float>();
	private HashMap<String, Float> onlineHours = new HashMap<String, Float>();
	private float asyncHours;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public ArrayList<Float> getClo() {
		return clo;
	}
	public void setClo(ArrayList<Float> clo) {
		this.clo = clo;
	}
	public HashMap<String, Float> getPhysicalHours() {
		return physicalHours;
	}
	public void setPhysicalHours(HashMap<String, Float> physicalHours) {
		this.physicalHours = physicalHours;
	}
	public HashMap<String, Float> getOnlineHours() {
		return onlineHours;
	}
	public void setOnlineHours(HashMap<String, Float> onlineHours) {
		this.onlineHours = onlineHours;
	}
	public float getAsyncHours() {
		return asyncHours;
	}
	public void setAsyncHours(float asyncHours) {
		this.asyncHours = asyncHours;
	}
	
	
}
