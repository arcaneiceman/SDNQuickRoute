
import network.NetworkInformation;

import org.json.simple.parser.ParseException;

import json.JSONType;
import json.Parser;

/**
 * The purpose of this program is to monitor openflow networks and dynamically
 * route flows for optimal efficency
 * 
 * @author cloud: Wali, Mutahir, Wajahat
 * 
 */

public class MainFile implements Runnable {

	private static NetworkInformation network;

	public static void main(String[] args) throws ParseException,
			InterruptedException {
		// SINGELTON INSANCE
		network = NetworkInformation.getInstance();

		// GET INITIAL INFORMATION OF THE NETWORK
		String json_switch = "[{\"actions\": 4095, \"attributes\": {\"FastWildcards\": 4194303, \"supportsNxRole\": true, \"supportsOfppFlood\": true, \"supportsOfppTable\": true}, \"buffers\": 256, \"capabilities\": 199, \"connectedSince\": 1390034975239, \"description\": {\"datapath\": \"None\", \"hardware\": \"Open vSwitch\", \"manufacturer\": \"Nicira Networks, Inc.\", \"serialNum\": \"None\", \"software\": \"1.4.0+build0\"}, \"dpid\": \"00:00:00:01:6c:92:ce:d7\", \"harole\": \"MASTER\", \"inetAddress\": \"/10.10.1.4:60908\", \"ports\": [{\"advertisedFeatures\": 655, \"config\": 0, \"currentFeatures\": 520, \"hardwareAddress\": \"b0:48:7a:82:17:af\", \"name\": \"eth2\", \"peerFeatures\": 0, \"portNumber\": 3, \"state\": 0, \"supportedFeatures\": 655}, {\"advertisedFeatures\": 655, \"config\": 0, \"currentFeatures\": 520, \"hardwareAddress\": \"b0:48:7a:82:17:b2\", \"name\": \"eth1\", \"peerFeatures\": 0, \"portNumber\": 2, \"state\": 0, \"supportedFeatures\": 655}, {\"advertisedFeatures\": 0, \"config\": 0, \"currentFeatures\": 0, \"hardwareAddress\": \"00:01:6c:92:ce:d7\", \"name\": \"br-int\", \"peerFeatures\": 0, \"portNumber\": 65534, \"state\": 0, \"supportedFeatures\": 0}, {\"advertisedFeatures\": 1727, \"config\": 0, \"currentFeatures\": 640, \"hardwareAddress\": \"00:01:6c:92:ce:d7\", \"name\": \"eth0\", \"peerFeatures\": 0, \"portNumber\": 1, \"state\": 1, \"supportedFeatures\": 703}]}, {\"actions\": 4095, \"attributes\": {\"FastWildcards\": 4194303, \"supportsNxRole\": true, \"supportsOfppFlood\": true, \"supportsOfppTable\": true}, \"buffers\": 256, \"capabilities\": 199, \"connectedSince\": 1390034981664, \"description\": {\"datapath\": \"None\", \"hardware\": \"Open vSwitch\", \"manufacturer\": \"Nicira Networks, Inc.\", \"serialNum\": \"None\", \"software\": \"1.4.0+build0\"}, \"dpid\": \"00:00:00:60:08:e3:59:3f\", \"harole\": \"MASTER\", \"inetAddress\": \"/10.10.1.2:58666\", \"ports\": [{\"advertisedFeatures\": 655, \"config\": 0, \"currentFeatures\": 520, \"hardwareAddress\": \"b0:48:7a:82:08:0d\", \"name\": \"eth4\", \"peerFeatures\": 0, \"portNumber\": 3, \"state\": 0, \"supportedFeatures\": 655}, {\"advertisedFeatures\": 655, \"config\": 0, \"currentFeatures\": 520, \"hardwareAddress\": \"b0:48:7a:82:5d:eb\", \"name\": \"eth0\", \"peerFeatures\": 0, \"portNumber\": 2, \"state\": 0, \"supportedFeatures\": 655}, {\"advertisedFeatures\": 0, \"config\": 0, \"currentFeatures\": 0, \"hardwareAddress\": \"00:60:08:e3:59:3f\", \"name\": \"br-int\", \"peerFeatures\": 0, \"portNumber\": 65534, \"state\": 0, \"supportedFeatures\": 0}, {\"advertisedFeatures\": 655, \"config\": 0, \"currentFeatures\": 513, \"hardwareAddress\": \"00:60:08:e3:59:3f\", \"name\": \"eth1\", \"peerFeatures\": 0, \"portNumber\": 1, \"state\": 1, \"supportedFeatures\": 655}]}]";
		String json_host = "[{\"attachmentPoint\": [{\"errorStatus\": null, \"port\": 3, \"switchDPID\": \"00:00:00:60:08:e3:59:3f\"}], \"dhcpClientName\": \"CloudSwitch3\", \"entityClass\": \"DefaultEntityClass\", \"ipv4\": [\"10.10.1.51\"], \"lastSeen\": 1390056412320, \"mac\": [\"b0:48:7a:82:17:b2\"], \"vlan\": []}, {\"attachmentPoint\": [{\"errorStatus\": null, \"port\": 3, \"switchDPID\": \"00:00:00:60:08:e3:59:3f\"}], \"entityClass\": \"DefaultEntityClass\", \"ipv4\": [], \"lastSeen\": 1390056380541, \"mac\": [\"b0:48:7a:82:17:af\"], \"vlan\": []}, {\"attachmentPoint\": [{\"errorStatus\": null, \"port\": 1, \"switchDPID\": \"00:00:00:01:6c:92:ce:d7\"}], \"entityClass\": \"DefaultEntityClass\", \"ipv4\": [\"169.254.160.16\", \"10.10.1.50\"], \"lastSeen\": 1390056419018, \"mac\": [\"00:23:8b:58:61:a5\"], \"vlan\": []}, {\"attachmentPoint\": [{\"errorStatus\": null, \"port\": 3, \"switchDPID\": \"00:00:00:01:6c:92:ce:d7\"}], \"entityClass\": \"DefaultEntityClass\", \"ipv4\": [], \"lastSeen\": 1390056380973, \"mac\": [\"b0:48:7a:82:55:f4\"], \"vlan\": []}]";
		String json_links = "[{\"direction\": \"bidirectional\", \"dst-port\": 2, \"dst-switch\": \"00:00:00:60:08:e3:59:3f\", \"src-port\": 2, \"src-switch\": \"00:00:00:01:6c:92:ce:d7\", \"type\": \"internal\"}]";
		Parser.ToSwitchInfo(json_switch);
		Parser.ToLinkInfo(json_links);
		Parser.ToHostInfo(json_host);

		// START MAKING THE TOPOLOGY GRAPH
		new Thread() {
			public void run() {
				network.network_graph.display();
				network.AddSwitchesAndHostsToGraph();
				network.AddLinksToClassesAndGraph();
			}
		}.start();

		System.out.println(Parser.getJSON(JSONType.Host));
		
	}

	@Override
	public void run() {
	}
}
