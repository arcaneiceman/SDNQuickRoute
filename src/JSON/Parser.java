package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import json.host.Host;
import json.links.Link;
import json.switches.*;

import network.NetworkInformation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

	public static String getJSON(JSONType tp) {
		String url = null;
		switch (tp) {
		case Host:
			url = "/wm/device/";
			break;
		case Link:
			url = "/wm/topology/links/json";
			break;
		case Switch:
			url = "/wm/core/controller/switches/json";
			break;
		}

		url = "http://" + NetworkInformation.ControllerIP + ":8080" + url;

		String jsonText = null;
		try {
			InputStream is = new URL(url).openStream();
			try {
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						is, Charset.forName("UTF-8")));
				jsonText = readAll(rd);
			} finally {
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonText;
	}

	private static String readAll(Reader rd) {
		StringBuilder sb = new StringBuilder();
		int cp;
		try {
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void ToSwitchInfo(String json_) throws ParseException {

		NetworkInformation network_info = NetworkInformation.getInstance();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json_);
		JSONArray array = (JSONArray) obj;
		Switch temp_switch;
		for (int i = 0; i < array.size(); i++) {
			temp_switch = new Switch((JSONObject) array.get(i));
			if (!network_info.switches.containsKey(temp_switch.getDpid())) {
				network_info.switches.put(temp_switch.getDpid(), temp_switch);
			}
		}
	}

	public static void ToLinkInfo(String json_) throws ParseException {

		NetworkInformation network_info = NetworkInformation.getInstance();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json_);
		JSONArray array = (JSONArray) obj;
		Link temp_link;
		for (int i = 0; i < array.size(); i++) {
			temp_link = new Link((JSONObject) array.get(i));
			if (!network_info.links.containsKey(temp_link.getSrc_switch())) {
				network_info.links.put(temp_link.getSrc_switch(), temp_link);
			}
		}
	}

	public static void ToHostInfo(String json_) throws ParseException {

		NetworkInformation network_info = NetworkInformation.getInstance();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json_);
		JSONArray array = (JSONArray) obj;
		JSONObject temp_obj;
		JSONArray ipv4Array;
		int size_ipv4_array = 0;
		boolean Host_found = false;
		Host temp_host;
		for (int i = 0; i < array.size(); i++) {
			Host_found = false;
			temp_obj = (JSONObject) array.get(i);
			ipv4Array = (JSONArray) (temp_obj).get("ipv4");
			size_ipv4_array = ipv4Array.size();
			if (size_ipv4_array != 0) {
				for (int j = 0; j < size_ipv4_array; j++) {
					if (network_info.links.containsKey(ipv4Array.get(j)
							.toString())) {
						Host_found = true;
						break;
					}
				}

				if (!Host_found) {
					temp_host = new Host(temp_obj);
					network_info.hosts.put(temp_host.getIpv4(), temp_host);
				}
			}
		}
	}
}
