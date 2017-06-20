package oauth2;

/*
 * AccountInfo for enrollment 
 */
public class AccountInfo {
	private static final String INFOIMAGE = "InfoIMAGE";
	private String accountNumber;
	private String clientId;
	private String enrollment;
	private String userId;
	private CustomInformation customAttribs;

	public CustomInformation getCustomAttribs() {
		return customAttribs;
	}

	public void setCustomAttribs(CustomInformation customAttribs) {
		this.customAttribs = customAttribs;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String toJson() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"accountNumber\":\"");
		builder.append(getAccountNumber());
		builder.append("\",\"clientId\":\"");
		builder.append(INFOIMAGE);
		builder.append("_");
		builder.append(getClientId());
		builder.append("\",\"userId\":\"");
		builder.append(getUserId());
		builder.append("\",\"customAttribs\":{");
		if ((getCustomAttribs().getEmailId() != null && getCustomAttribs()
				.getEmailId().trim().length() > 0)
				&& !getCustomAttribs().getEmailId().equalsIgnoreCase("null")) {
			builder.append("\"emailId\":\"");
			builder.append(getCustomAttribs().getEmailId());
			builder.append("\",");
		}
		builder.append("\"flagInd1\":\"");
		builder.append(getCustomAttribs().getFlagInd1());
		if (getCustomAttribs().getFlagLevel1() != null
				&& getCustomAttribs().getFlagLevel1().trim().length() > 0) {
			builder.append("\",\"flagLevel1\":\"");
			builder.append(getCustomAttribs().getFlagLevel1());
		}
		if (getCustomAttribs().getFlagNum1() != null
				&& getCustomAttribs().getFlagNum1().trim().length() > 0) {
			builder.append("\",\"flagNum1\":\"");
			builder.append(getCustomAttribs().getFlagNum1());
		}
		if (getCustomAttribs().getFlagType1() != null
				&& getCustomAttribs().getFlagType1().trim().length() > 0) {
			builder.append("\",\"flagType1\":\"");
			builder.append(getCustomAttribs().getFlagType1());
		}
		if (getCustomAttribs().getReasonNum1() != null
				&& getCustomAttribs().getReasonNum1().trim().length() > 0) {
			builder.append("\",\"reasonNum1\":\"");
			builder.append(getCustomAttribs().getReasonNum1());
		}
		if (getCustomAttribs().getSuffix() != null
				&& getCustomAttribs().getSuffix().trim().length() > 0) {
			builder.append("\",\"suffix\":\"");
			builder.append(getCustomAttribs().getSuffix());
		}
		if (getCustomAttribs().getSurname() != null
				&& getCustomAttribs().getSurname().trim().length() > 0) {
			builder.append("\",\"surname\":\"");
			builder.append(getCustomAttribs().getSurname());
		}
		builder.append("\"},\"enrollment\":\"");
		builder.append(getEnrollment());
		builder.append("\"}");
		return builder.toString();
	}

}

