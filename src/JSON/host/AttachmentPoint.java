package json.host;

import org.json.simple.JSONObject;

public class AttachmentPoint {

	private Object errorStatus;
	private Long port;
	private String switchDPID;
	
	public AttachmentPoint(JSONObject obj){
		port= (Long) obj.get("port");
		switchDPID= (String) obj.get("switchDPID");
		
	}
	
	public Object getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(Object errorStatus) {
		this.errorStatus = errorStatus;
	}

	public AttachmentPoint withErrorStatus(Object errorStatus) {
		this.errorStatus = errorStatus;
		return this;
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public AttachmentPoint withPort(Long port) {
		this.port = port;
		return this;
	}

	public String getSwitchDPID() {
		return switchDPID;
	}

	public void setSwitchDPID(String switchDPID) {
		this.switchDPID = switchDPID;
	}

	public AttachmentPoint withSwitchDPID(String switchDPID) {
		this.switchDPID = switchDPID;
		return this;
	}

}