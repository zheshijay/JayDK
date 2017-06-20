package json.gson.StrToObj;

import java.lang.reflect.Type;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account{
	private String acctNum;
	private String acctType;
	private String notifyType;
	private String smsNum;
	private String primaryEmail;
	private List<String> emails;
	
	private String newDeliveryPref;
	private String oldDeliveryPref;
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	public String getSmsNum() {
		return smsNum;
	}
	public void setSmsNum(String smsNum) {
		this.smsNum = smsNum;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public String getNewDeliveryPref() {
		return newDeliveryPref;
	}
	public void setNewDeliveryPref(String newDeliveryPref) {
		this.newDeliveryPref = newDeliveryPref;
	}
	public String getOldDeliveryPref() {
		return oldDeliveryPref;
	}
	public void setOldDeliveryPref(String oldDeliveryPref) {
		this.oldDeliveryPref = oldDeliveryPref;
	}
	

	
	
}
