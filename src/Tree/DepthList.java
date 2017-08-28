package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DepthList {

	public Map<Integer, LinkedList<TreeNode>> dfs(TreeNode root) {

		int d = 0;
		Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();
		return dfs(root, map, d);
	}

	private Map<Integer, LinkedList<TreeNode>> dfs(TreeNode root, Map<Integer, LinkedList<TreeNode>> map, int d) {

		if (root != null) {

			LinkedList<TreeNode> list;

			if (map.containsKey(d))
				list = map.get(d);
			else
				list = new LinkedList<TreeNode>();

			list.add(root);
			map.put(d, list);

			dfs(root.left, map, d + 1);
			dfs(root.right, map, d + 1);
		}

		return map;
	}

	public Map<Integer, LinkedList<TreeNode>> bfs(TreeNode root) {

		Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();
		LinkedList<TreeNode> children = new LinkedList<TreeNode>();


		int depth = 0;

		if (root != null) {

			children.add(root);
			while (!children.isEmpty()) {
			
				map.put(depth++, children);
				LinkedList<TreeNode> visited= ( LinkedList<TreeNode>)map.get(depth-1).clone();
				children = new LinkedList<TreeNode>();

				while (!visited.isEmpty()) {
					TreeNode node = visited.poll();
					if(node.left!=null)
						children.add(node.left);
					
					if(node.right!=null)
						children.add(node.right);
				}
			}

		}
		return map;

	}

	private void mapPrint(Map<Integer, LinkedList<TreeNode>> map) {

		for (Integer key : map.keySet()) {
			LinkedList<TreeNode> n = map.get(key);

			while (n.peek() != null) {
				System.out.print("::"+ n.poll().data);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] a = { 6, 2, 1, 4, 3, 5 };

		MinimalBTree b= new MinimalBTree();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n3.left = n5;
		n3.right = n6;

		DepthList d = new DepthList();
		d.mapPrint(d.bfs(b.createTree(a)));
	//	d.mapPrint(d.dfs(b.createTree(a)));
		
		//d.mapPrint(d.dfs(n1));
		d.mapPrint(d.bfs(n1));

	}

}