package json.switches;

public class OFEdge {
	private String ipv4;
	private String dpid;
	private boolean IsSwitch;

	public OFEdge(String ipv4, String dpid, boolean isSwitch) {
		this.ipv4 = ipv4;
		this.dpid = dpid;
		this.setIsSwitch(isSwitch);
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public String getDpid() {
		return dpid;
	}

	public void setDpid(String dpid) {
		this.dpid = dpid;
	}

	public boolean isIsSwitch() {
		return IsSwitch;
	}

	public void setIsSwitch(boolean isSwitch) {
		IsSwitch = isSwitch;
	}
}
