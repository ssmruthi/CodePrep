import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Graph {

	Map<Integer, HashSet<Node>> graphMap = new HashMap<Integer, HashSet<Node>>();
	ArrayList<Integer> visited = new ArrayList<Integer>();
	StringBuilder sb = new StringBuilder();

	class Node {
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void addPath(int source, int destination) {

		Node dest = new Node(destination);
		HashSet<Node> hs;
		hs = graphMap.get(source);

		if (hs == null)
			hs = new HashSet<Node>();

		hs.add(dest);
		graphMap.put(source, hs);

	}

	public void printGraph() {

		for (int x : graphMap.keySet()) {
			System.out.print("\n" + x + "-->");

			for (Node n : graphMap.get(x)) {
				System.out.print(n.data + ",");
			}
		}
	}

	public String dfs(int source, int destination) {

		HashSet<Node> neighbours = graphMap.get(source);
		visited.add(source);

		if (neighbours != null) {
			for (Node node : neighbours) {
				sb.append("-> " + node.data);

				if (!visited.contains(node.data)) {
					if (node.data != destination) {
						dfs(node.data, destination);
					}
				}
				sb.append("\n");
			}
		}

		return sb.toString();

	}

	public void bfs(int source, int destination) {

		HashSet<Node> neighbours = graphMap.get(source);
		java.util.List<Integer> nodes = new java.util.ArrayList<Integer>();

		sb = new StringBuilder();
		nodes.add(source);
		for (int i = 0; i < nodes.size(); i++) {
			int x = nodes.get(i);
			sb.append(x + ",");
			neighbours = graphMap.get(x);

			if (neighbours != null)
				for (Node node : neighbours) {
					if (node.data == destination) {
						sb.append(node.data);
						//break;
					} else {
						if(!nodes.contains(node.data))
						nodes.add(node.data);
					}

				}
		}

		System.out.println(sb.toString());

	}
}