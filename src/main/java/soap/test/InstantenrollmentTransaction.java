package soap.test;

import java.util.Date;

public class InstantenrollmentTransaction {

    private final String SURNAME_DEFAULT = "ZZ";
    
    private Long id;

    private String transactionId;

    private String clientId;

    private String accountNumber;

    private String enrollment;
       
    private String suffix;
    
    private String surname;
    
    private String flagInd1;

    private String flagLevel1;
    
    private String flagType1;
    
    private String flagNum1;
    
    private String reasonNum1;
    
    private String emailId;

    private boolean isProcessed;
    
    private String statusCode;
    
    private String transactionStatus;

    private Integer retryCount;
    
    private Date createdOn;
    
    private Date updatedOn;

    private String jsonInputPayload;
    
    private String pathwayRequestXml;

    private String pathwayResponseXml;
    
    public InstantenrollmentTransaction() {
    }
    
    public InstantenrollmentTransaction(Long id) {
        this.id = id;
    }

    public InstantenrollmentTransaction(Long id, String clientId, String accountNumber, String enrollment) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.enrollment = enrollment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
    public String getStatusCode(){
    	return statusCode;
    }
    public void setStatusCode(String status){
    	this.statusCode=status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

	public String getEnrollment(){
		return enrollment;
	}
	public void setEnrollment(String enrollment){
		this.enrollment = enrollment;
	}
    
	public String getJsonInputPayload(){
		return jsonInputPayload;
	}
	public void setJsonInputPayload(String rawPayload){
		this.jsonInputPayload = rawPayload;
	}
	
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSurname() {
        return surname;
    }

    public String getSurnameAsDefault() {
    	if (surname!=null){
    		return surname;
    	}else{
    		return SURNAME_DEFAULT;
    	}
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFlagInd1() {
        return flagInd1;
    }

    public void setFlagInd1(String flagSetOrClear) {
        this.flagInd1 = flagSetOrClear;
    }

    public String getFlagLevel1() {
        return flagLevel1;
    }

    public void setFlagLevel1(String flagLevel1) {
        this.flagLevel1 = flagLevel1;
    }

    public String getFlagType1() {
        return flagType1;
    }

    public void setFlagType1(String flagType1) {
        this.flagType1 = flagType1;
    }

    public String getFlagNum1() {
        return flagNum1;
    }

    public void setFlagNum1(String flagNum1) {
        this.flagNum1 = flagNum1;
    }

    public String getReasonNum1() {
        return reasonNum1;
    }

    public void setReasonNum1(String reasonNum1) {
        this.reasonNum1 = reasonNum1;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getEmailIdWithNullCheck() {
    	if (emailId!=null){
    		return emailId;
    	}else{
    		return "";
    	}
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
    public boolean getIsProcessed() {
        return isProcessed;
    }
    public void setIsProcessed(boolean activeFlag) {
        this.isProcessed = activeFlag;
    }
    public String getPathwayResponseXml(){
    	return pathwayResponseXml;
    }
    public void setPathwayResponseXml(String xmlText){
    	pathwayResponseXml = xmlText;
    }
    
    public Integer getRetryCount(){
    	return retryCount;
    }
    public void setRetryCount(Integer count){
    	this.retryCount = count;
    }
    
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof InstantenrollmentTransaction)) {
            return false;
        }
        InstantenrollmentTransaction other = (InstantenrollmentTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	public String toString(){
		return "InstantenrollmentTransaction= [id: " + id +
				", transactionId: " + transactionId +
				", transactionStatus: " + transactionStatus +
				", clientId: " + clientId +
				", accountNumber: " + accountNumber +
				", enrollment: " + enrollment +
				", suffix: " + suffix +
				", surname: " + surname +
				", flagInd1: " + flagInd1 +
				", flagLevel1: " + flagLevel1 +
				", flagType1: " + flagType1 +
				", flagNum1: " + flagNum1 +
				", reasonNum1: " + reasonNum1 +
				", emailId:" + emailId + "]";
	}   
	
	public String toJson(){
		StringBuilder builder = new StringBuilder();
		builder.append("{\"clientId\" : \"");
		builder.append(clientId);
		builder.append("\", \"accountNumber\" : \"");
		builder.append(accountNumber);
		builder.append("\", \"enrollment\" : \"");
		builder.append(enrollment); 
		builder.append("\", \"customAttribs\" : { ");
		builder.append("  \"suffix\" : \"");
		builder.append(suffix); 	
		builder.append("\", \"surname\" : \"" );
		builder.append(surname);			
		builder.append("\", \"flagInd1\" : \"");
		builder.append(flagInd1);			
		builder.append("\", \"flagLevel1\" : \"" );
		builder.append(flagLevel1);	
		builder.append("\", \"flagType1\" : \"" );
		builder.append(flagType1);
		builder.append("\", \"flagNum1\" : \"" );
		builder.append(flagNum1);
		builder.append("\", \"reasonNum1\" : \"" );
		builder.append(reasonNum1);
		builder.append("\", \"emailId\" : \"");
		builder.append(emailId);
		builder.append("\" } }");
		return builder.toString();
	}

	void onCreate() {
	    this.setCreatedOn(new Date() );
    }

	void onBeforeUpdate() {
    	this.setUpdatedOn(new Date());
    }

	public String getPathwayRequestXml() {
		return pathwayRequestXml;
	}

	public void setPathwayRequestXml(String pathwayRequestXml) {
		this.pathwayRequestXml = pathwayRequestXml;
	}
	
	
}
