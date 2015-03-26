package network;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import json.host.Host;
import json.links.Link;
import json.switches.OFEdge;
import json.switches.Switch;

/* This class contains information about the 
 * network including details of switches and topology */

public class NetworkInformation {

	/* GLOBAL VARIABLES */
	public static String ControllerIP = "10.10.1.1";
	public static String Gateway = "10.10.1.0";
	public static String SearchIP;

	/* LOCAL VARIABLES */
	public Graph network_graph;
	public HashMap<String, Switch> switches;
	public HashMap<String, Link> links;
	public HashMap<String, Host> hosts;
	private static NetworkInformation singleton = new NetworkInformation();

	private NetworkInformation() {
		System.setProperty("org.graphstream.ui.renderer",
				"org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		network_graph = new SingleGraph("OpenFlow Network");
		network_graph.addAttribute("ui.quality");
		URL myUrl = null;
		try {
			myUrl = new File("Stylesheet.css").toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		network_graph.addAttribute("ui.stylesheet", "url('" + myUrl.toString()
				+ "')");
		network_graph.setStrict(false);
		network_graph.setAutoCreate(true);
		switches = new HashMap<String, Switch>();
		links = new HashMap<String, Link>();
		hosts = new HashMap<String, Host>();
		SearchIP = NetworkInformation.Gateway;
		SearchIP = SearchIP.substring(0, SearchIP.indexOf(".0"));
	};

	// For adding Node To Graph
	public void AddNodeToGraph(String IP, boolean IsSwitch) {
		String temp;

		if (IsSwitch) {
			temp = "OpenVSwitch";
		} else {
			temp = "EndHost";
		}

		network_graph.addNode(temp + " [" + IP + "]");
		Node node = network_graph.getNode(temp + " [" + IP + "]");
		node.addAttribute("ui.class", temp);
		node.addAttribute("ui.label", node.getId());
	}

	// For adding Edge To Graph
	public void AddEdgeToGraph(String First_IP, String Second_IP,
			String edge_details, boolean IsSwitch_1, boolean IsSwitch_2) {
		try {
			String temp_1 = "OpenVSwitch";
			String temp_2 = "OpenVSwitch";

			if (!IsSwitch_1) {
				temp_1 = "EndHost";
			}

			if (!IsSwitch_2) {
				temp_2 = "EndHost";
			}

			String node_name_1 = temp_1 + " [" + First_IP + "]";
			String node_name_2 = temp_2 + " [" + Second_IP + "]";
			network_graph.addEdge(edge_details, node_name_1, node_name_2);
			Edge edge = network_graph.getEdge(edge_details);
			edge.addAttribute("ui.label", edge.getId());
		} catch (Exception e) {

		}
	}

	// For removing Node From Graph
	public void RemoveNodeAndEdgesFromGraph(String IP, boolean IsSwitch) {
		String temp = "EndHost";

		if (IsSwitch) {
			temp = "OpenVSwitch";
		}

		network_graph.removeNode(temp + " [" + IP + "]");
	}

	// Adding switches and hosts to the network
	public void AddSwitchesAndHostsToGraph() {
		for (Switch switch_ : switches.values()) {
			AddNodeToGraph(switch_.getInetAddress(), true);
		}

		for (Host host_ : hosts.values()) {
			AddNodeToGraph(host_.getIpv4().toString(), false);
		}
	}

	// Adding Links to Classes and Graph
	public void AddLinksToClassesAndGraph() {
		String edgeInfo;
		Switch srcSwitch;
		Switch destSwitch;
		String srcIP = "";
		String destIP = "";

		for (Link link_ : links.values()) {
			edgeInfo = "(" + link_.getDirection() + ") SrcPort: "
					+ link_.getSrc_port() + " => DestPort: "
					+ link_.getDst_port();

			srcSwitch = switches.get(link_.getSrc_switch());
			destSwitch = switches.get(link_.getDst_switch());
			destIP = srcSwitch.getInetAddress();
			srcIP = destSwitch.getInetAddress();

			if (link_.getDirection().equals("bidirectional")) {
				srcSwitch.getEdges().put(destIP,
						new OFEdge(destIP, link_.getDst_switch(), true));
				AddEdgeToGraph(srcIP, destIP, edgeInfo, true, true);
				destSwitch.getEdges().put(srcIP,
						new OFEdge(srcIP, link_.getSrc_switch(), true));
				AddEdgeToGraph(srcIP, destIP, edgeInfo, true, true);

			} else {
				srcSwitch.getEdges().put(destIP,
						new OFEdge(destIP, link_.getDst_switch(), true));
				AddEdgeToGraph(srcIP, destIP, edgeInfo, true, true);
			}
		}

		String swID;
		for (Host host_ : hosts.values()) {
			for (int j = 0; j < host_.getAttachmentPoint().size(); j++) {
				swID = host_.getAttachmentPoint().get(j).getSwitchDPID();
				destSwitch = switches.get(swID);
				edgeInfo = "DestPort: "
						+ host_.getAttachmentPoint().get(j).getPort();
				destSwitch.getEdges().put(host_.getIpv4(),
						new OFEdge(host_.getIpv4(), "", false));

				host_.getEdges().put(destSwitch.getInetAddress(),
						new OFEdge(destSwitch.getInetAddress(), swID, true));

				AddEdgeToGraph(host_.getIpv4(), destSwitch.getInetAddress(),
						edgeInfo, false, true);
			}
		}
	}

	// For Singleton instance
	public static NetworkInformation getInstance() {
		return singleton;
	}

}
