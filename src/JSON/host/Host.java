package json.host;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import json.switches.OFEdge;

import network.NetworkInformation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Host {

	private List<AttachmentPoint> attachmentPoint = new ArrayList<AttachmentPoint>();
	private String entityClass;
	private String ipv4;
	private Long lastSeen;
	private List<String> mac = new ArrayList<String>();
	private List<String> vlan = new ArrayList<String>();
	private String dhcpClientName;
	private HashMap<String, OFEdge> edges = new HashMap<String, OFEdge>();
	
	public Host(JSONObject obj) {
		entityClass = (String) obj.get("entityClass");
		lastSeen = (Long) obj.get("lastSeen");
		dhcpClientName = (String) obj.get("dhcpClientName");
		JSONArray aps = (JSONArray) obj.get("attachmentPoint");

		for (int i = 0; i < aps.size(); i++) {
			attachmentPoint.add(new AttachmentPoint((JSONObject) aps.get(i)));
		}

		String temp;
		JSONArray ipv4_array = (JSONArray) obj.get("ipv4");
		for (int i = 0; i < ipv4_array.size(); i++) {
			temp = ipv4_array.get(i).toString();

			if (temp.contains(NetworkInformation.SearchIP)) {
				ipv4 = temp;
				break;
			}
		}

		JSONArray mac_array = (JSONArray) obj.get("mac");
		for (int i = 0; i < mac_array.size(); i++) {
			mac.add(mac_array.get(i).toString());
		}

		JSONArray vlan_array = (JSONArray) obj.get("vlan");
		for (int i = 0; i < vlan_array.size(); i++) {
			vlan.add(vlan_array.get(i).toString());
		}

	}

	public List<AttachmentPoint> getAttachmentPoint() {
		return attachmentPoint;
	}

	public void setAttachmentPoint(List<AttachmentPoint> attachmentPoint) {
		this.attachmentPoint = attachmentPoint;
	}

	public Host withAttachmentPoint(List<AttachmentPoint> attachmentPoint) {
		this.attachmentPoint = attachmentPoint;
		return this;
	}

	public String getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}

	public Host withEntityClass(String entityClass) {
		this.entityClass = entityClass;
		return this;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public Host withIpv4(String ipv4) {
		this.ipv4 = ipv4;
		return this;
	}

	public Long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Long lastSeen) {
		this.lastSeen = lastSeen;
	}

	public Host withLastSeen(Long lastSeen) {
		this.lastSeen = lastSeen;
		return this;
	}

	public List<String> getMac() {
		return mac;
	}

	public void setMac(List<String> mac) {
		this.mac = mac;
	}

	public Host withMac(List<String> mac) {
		this.mac = mac;
		return this;
	}

	public List<String> getVlan() {
		return vlan;
	}

	public void setVlan(List<String> vlan) {
		this.vlan = vlan;
	}

	public Host withVlan(List<String> vlan) {
		this.vlan = vlan;
		return this;
	}

	public String getDhcpClientName() {
		return dhcpClientName;
	}

	public void setDhcpClientName(String dhcpClientName) {
		this.dhcpClientName = dhcpClientName;
	}

	public Host withDhcpClientName(String dhcpClientName) {
		this.dhcpClientName = dhcpClientName;
		return this;
	}

	public HashMap<String, OFEdge> getEdges() {
		return edges;
	}

	public void setEdges(HashMap<String, OFEdge> edges) {
		this.edges = edges;
	}

}