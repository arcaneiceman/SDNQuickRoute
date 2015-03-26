package json.switches;

import org.json.simple.JSONObject;

public class Port {

	private Long advertisedFeatures;
	private Long config;
	private Long currentFeatures;
	private String hardwareAddress;
	private String name;
	private Long peerFeatures;
	private Long portNumber;
	private Long state;
	private Long supportedFeatures;

	public Port(Object object) {
		JSONObject obj = (JSONObject) object;
		hardwareAddress = (String) obj.get("hardwareAddress");
		name = (String) obj.get("name");
		advertisedFeatures = (Long) obj.get("advertisedFeatures");
		config = (Long) obj.get("config");
		currentFeatures = (Long) obj.get("currentFeatures");
		peerFeatures = (Long) obj.get("peerFeatures");
		portNumber = (Long) obj.get("portNumber");
		state = (Long) obj.get("state");
		supportedFeatures = (Long) obj.get("supportedFeatures");
	}

	public Long getAdvertisedFeatures() {
		return advertisedFeatures;
	}

	public void setAdvertisedFeatures(Long advertisedFeatures) {
		this.advertisedFeatures = advertisedFeatures;
	}

	public Port withAdvertisedFeatures(Long advertisedFeatures) {
		this.advertisedFeatures = advertisedFeatures;
		return this;
	}

	public Long getConfig() {
		return config;
	}

	public void setConfig(Long config) {
		this.config = config;
	}

	public Port withConfig(Long config) {
		this.config = config;
		return this;
	}

	public Long getCurrentFeatures() {
		return currentFeatures;
	}

	public void setCurrentFeatures(Long currentFeatures) {
		this.currentFeatures = currentFeatures;
	}

	public Port withCurrentFeatures(Long currentFeatures) {
		this.currentFeatures = currentFeatures;
		return this;
	}

	public String getHardwareAddress() {
		return hardwareAddress;
	}

	public void setHardwareAddress(String hardwareAddress) {
		this.hardwareAddress = hardwareAddress;
	}

	public Port withHardwareAddress(String hardwareAddress) {
		this.hardwareAddress = hardwareAddress;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Port withName(String name) {
		this.name = name;
		return this;
	}

	public Long getPeerFeatures() {
		return peerFeatures;
	}

	public void setPeerFeatures(Long peerFeatures) {
		this.peerFeatures = peerFeatures;
	}

	public Port withPeerFeatures(Long peerFeatures) {
		this.peerFeatures = peerFeatures;
		return this;
	}

	public Long getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(Long portNumber) {
		this.portNumber = portNumber;
	}

	public Port withPortNumber(Long portNumber) {
		this.portNumber = portNumber;
		return this;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Port withState(Long state) {
		this.state = state;
		return this;
	}

	public Long getSupportedFeatures() {
		return supportedFeatures;
	}

	public void setSupportedFeatures(Long supportedFeatures) {
		this.supportedFeatures = supportedFeatures;
	}

	public Port withSupportedFeatures(Long supportedFeatures) {
		this.supportedFeatures = supportedFeatures;
		return this;
	}

}
