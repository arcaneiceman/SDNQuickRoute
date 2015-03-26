package json.links;

import org.json.simple.JSONObject;

public class Link {

	private String direction;
	private Long dst_port;
	private String dst_switch;
	private Long src_port;
	private String src_switch;
	private String type;
	
	public Link(JSONObject obj){
		direction= (String) obj.get("direction");
		dst_port= (Long) obj.get("dst-port");
		dst_switch= obj.get("dst-switch").toString();
		src_port= (Long) obj.get("src-port");
		src_switch= obj.get("src-switch").toString();
		type= (String) obj.get("type");
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Link withDirection(String direction) {
		this.direction = direction;
		return this;
	}

	public Long getDst_port() {
		return dst_port;
	}

	public void setDst_port(Long dst_port) {
		this.dst_port = dst_port;
	}

	public Link withDst_port(Long dst_port) {
		this.dst_port = dst_port;
		return this;
	}

	public String getDst_switch() {
		return dst_switch;
	}

	public void setDst_switch(String dst_switch) {
		this.dst_switch = dst_switch;
	}

	public Link withDst_switch(String dst_switch) {
		this.dst_switch = dst_switch;
		return this;
	}

	public Long getSrc_port() {
		return src_port;
	}

	public void setSrc_port(Long src_port) {
		this.src_port = src_port;
	}

	public Link withSrc_port(Long src_port) {
		this.src_port = src_port;
		return this;
	}

	public String getSrc_switch() {
		return src_switch;
	}

	public void setSrc_switch(String src_switch) {
		this.src_switch = src_switch;
	}

	public Link withSrc_switch(String src_switch) {
		this.src_switch = src_switch;
		return this;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Link withType(String type) {
		this.type = type;
		return this;
	}
}
