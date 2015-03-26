/* This class contains all the information regarding a particular switch */

package json.switches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Switch {

	private Long actions;
	private Attributes attributes;
	private Long buffers;
	private Long capabilities;
	private Long connectedSince;
	private Description description;
	private String dpid;
	private String harole;
	private String inetAddress;
	private String inetPort;
	private List<Port> ports = new ArrayList<Port>();
	private HashMap<String, OFEdge> Edges = new HashMap<String, OFEdge>();
	
	public Switch(JSONObject obj_) {
		actions = (Long) obj_.get("actions");
		buffers = (Long) obj_.get("buffers");
		capabilities = (Long) obj_.get("capabilities");
		connectedSince = (Long) obj_.get("connectedSince");
		dpid = obj_.get("dpid").toString();
		harole = obj_.get("harole").toString();

		String temp_string = obj_.get("inetAddress").toString().substring(1);
		int Port_Start = temp_string.indexOf(":");
		inetAddress = temp_string.substring(0, Port_Start);
		setInetPort(temp_string.substring(Port_Start + 1));

		JSONArray portArray = (JSONArray) obj_.get("ports");
		for (int i = 0; i < portArray.size(); i++) {
			ports.add(new Port(portArray.get(i)));
		}

	}

	public Long getActions() {
		return actions;
	}

	public void setActions(Long actions) {
		this.actions = actions;
	}

	public Switch withActions(Long actions) {
		this.actions = actions;
		return this;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Switch withAttributes(Attributes attributes) {
		this.attributes = attributes;
		return this;
	}

	public Long getBuffers() {
		return buffers;
	}

	public void setBuffers(Long buffers) {
		this.buffers = buffers;
	}

	public Switch withBuffers(Long buffers) {
		this.buffers = buffers;
		return this;
	}

	public Long getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Long capabilities) {
		this.capabilities = capabilities;
	}

	public Switch withCapabilities(Long capabilities) {
		this.capabilities = capabilities;
		return this;
	}

	public Long getConnectedSince() {
		return connectedSince;
	}

	public void setConnectedSince(Long connectedSince) {
		this.connectedSince = connectedSince;
	}

	public Switch withConnectedSince(Long connectedSince) {
		this.connectedSince = connectedSince;
		return this;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Switch withDescription(Description description) {
		this.description = description;
		return this;
	}

	public String getDpid() {
		return dpid;
	}

	public void setDpid(String dpid) {
		this.dpid = dpid;
	}

	public Switch withDpid(String dpid) {
		this.dpid = dpid;
		return this;
	}

	public String getHarole() {
		return harole;
	}

	public void setHarole(String harole) {
		this.harole = harole;
	}

	public Switch withHarole(String harole) {
		this.harole = harole;
		return this;
	}

	public String getInetAddress() {
		return inetAddress;
	}

	public void setInetAddress(String inetAddress) {
		this.inetAddress = inetAddress;
	}

	public Switch withInetAddress(String inetAddress) {
		this.inetAddress = inetAddress;
		return this;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	public Switch withPorts(List<Port> ports) {
		this.ports = ports;
		return this;
	}

	public String getInetPort() {
		return inetPort;
	}

	public void setInetPort(String inetPort) {
		this.inetPort = inetPort;
	}

	public HashMap<String, OFEdge> getEdges() {
		return Edges;
	}

	public void setEdges(HashMap<String, OFEdge> edges) {
		Edges = edges;
	}

	
}