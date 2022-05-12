package request;
import java.sql.Date;
import user.*;
import course.*;
import attribute.*;

public class Request {

	private String requestId;
	private String requestAction;
	private String requestMessage;
	private Date requestMadeOn;
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
	public Date getRequestMadeOn() {
		return requestMadeOn;
	}
	public void setRequestMadeOn(Date requestMadeOn) {
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
