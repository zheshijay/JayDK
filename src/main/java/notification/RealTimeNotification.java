package notification;

import java.util.HashMap;
import java.util.Map;

public class RealTimeNotification {
	
	protected String fName;
	protected String fEmail;
	protected String app;
	protected String replyTo;
	protected String to;
	protected String subject;
	protected String templateid;
	protected Map<String, String> vars;
	protected String carrier;
	protected String type;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfEmail() {
		return fEmail;
	}
	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public Map<String, String> getVars() {
		return new HashMap<String, String>(vars);
	}
	public void setVars(Map<String, String> vars) {
		this.vars = new HashMap<String, String>(vars);
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}