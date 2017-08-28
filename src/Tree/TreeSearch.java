package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TNode{
	
	TNode left;
	TNode right;
	int data;
	
	TNode(int data){
		this.data=data;
	}
}


public class TreeSearch {
	
	TNode root;
	TNode parent;
	LinkedList<TNode> pList= new LinkedList<TNode>();
	
	public void createTree(int[] a){

		root=new TNode(a[0]);
		pList.add(root);
		
		for(int i=0;i<a.length/2;i++){
			
			parent=pList.poll();
			
			parent.left=new TNode(a[2*i+1]);
			
			if(2*i+2<a.length)
			parent.right=new TNode(a[2*i+2]);
			
			pList.add(parent.left);
			pList.add(parent.right);
			//i=i+2;
			
		}
	}
	
	
	public void inorder(TNode n){
		if(n==null)
			return;
		
		inorder(n.left);
		System.out.println(n.data);
		inorder(n.right);
	}
	
	public boolean dfs(int a){
		return dfs(root,a);
	}
	
	public boolean bfs(int a){
		return bfs(root,a);
	}
	
	private boolean dfs(TNode node,int a){
		
		if(node==null)
			return false;
		
		if(node.data==a){
			return true;
		}
		
		boolean left= dfs(node.left,a);
		boolean right=dfs(node.right,a);	
		return left||right;
		
	}

	
	private boolean bfs(TNode root,int a){
		
		if(root==null)
			return false;
		
		LinkedList<TNode> visited= new LinkedList<TNode>();
		visited.add(root);
		
		while(!visited.isEmpty()){
			TNode node=visited.poll();
			
			if(node.data==a){
				return true;
			}
			if(node.left!=null)
				visited.add(node.left);
			
			if(node.right!=null)
				visited.add(node.right);
		}
		return false;
	}
	
	public static void main(String[] args){
		TreeSearch t= new TreeSearch();
		int[] a= {1,2,3,4,5};
		t.createTree(a);
		//t.inorder(t.root);
		
		//System.out.println(t.root.data);
		
		System.out.println(t.dfs(1));
		System.out.println(t.bfs(3));
	}
}

