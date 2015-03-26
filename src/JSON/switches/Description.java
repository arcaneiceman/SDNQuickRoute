/* This class lists all the description found for the switch */

package json.switches;

public class Description {

	private String datapath;
	private String hardware;
	private String manufacturer;
	private String serialNum;
	private String software;
	
	public String getDatapath() {
		return datapath;
	}

	public void setDatapath(String datapath) {
		this.datapath = datapath;
	}

	public Description withDatapath(String datapath) {
		this.datapath = datapath;
		return this;
	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public Description withHardware(String hardware) {
		this.hardware = hardware;
		return this;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Description withManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Description withSerialNum(String serialNum) {
		this.serialNum = serialNum;
		return this;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public Description withSoftware(String software) {
		this.software = software;
		return this;
	}

}