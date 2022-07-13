package request;
import java.sql.Timestamp;
import user.*;
import course.*;

public class Request implements java.io.Serializable {

	private String requestId;
	private String requestAction;
	private String requestMessage;
	private Timestamp requestMadeOn;
	private String requestStatus;
	private String userId;
	private String courseCode;
	//private String attrId;
	
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestAction() {
		return requestAction;
	}
	public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}
	public String getRequestMessage() {
		return requestMessage;
	}
	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}
	public Timestamp getRequestMadeOn() {
		return requestMadeOn;
	}
	public void setRequestMadeOn(Timestamp requestMadeOn) {
		this.requestMadeOn = requestMadeOn;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
	
	
}
