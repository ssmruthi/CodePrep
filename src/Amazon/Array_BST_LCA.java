package Amazon;

import java.util.HashMap;
import java.util.Map;

class ATree{
	ATree parent;
	ATree left;
	ATree right;
	int val;
	int level;
	
	ATree(int val){
		this.val=val;
	}
}

public class Array_BST_LCA {

	Map<Integer,ATree> map= new HashMap<Integer,ATree>();
	Map<Integer,Integer> depth= new HashMap<Integer,Integer>();
	
	int l=0;
	ATree root=null;
	
	private int distanceTwoNodes(int a1,int b1){
		int dist=0;
				
		ATree a= map.getOrDefault(a1, null);
		ATree b= map.getOrDefault(b1, null);
		
		if(a==null || b==null)
			return -1;
		
		int depth1=depth(a);
		int depth2=depth(b);
		//int lca=findLCAWithParent(a,b,depth1,depth2);
		ATree LCA=lowestCommonAncestor(root,a,b);
		int lca=depth(LCA);
		
		int d1=a.level;
		int d2=b.level;
		int d3=LCA.level;
		
		dist=depth1+depth2-(2*lca);
				
		System.out.println((d1+d2)-(2*d3));
		return dist;
	}
	
	/*
	 * 
	 * LCA without Parent
	 */
	
	 public ATree lowestCommonAncestor(ATree root, ATree p, ATree q){
	        	        
	        if(root==null || root==p || root==q)
	            return root;
	        
	        ATree left=lowestCommonAncestor(root.left,p,q);
	        ATree right=lowestCommonAncestor(root.right,p,q);
	        
	        if(left!=null && right!=null)
	        	return root;
	        else if(left!=null)
	            return left;
	        else if(right!=null)
	            return right;
	            
	        return null;
	    }
	
	
	/*
	 * 
	 * LCA with Parent
	 */
	
	private int findLCAWithParent(ATree a, ATree b,int depth1,int depth2) {
		
		ATree first=depth1>depth2?b:a;
		ATree second=depth1>depth2?a:b;
		
		int diff=Math.abs(depth2-depth1);
		
		int lca=depth1>depth2?depth2:depth1;
		
		while(diff>0){
			
			second=second.parent;
			diff--;
		}
		
		
		while(first!=second && first!=null && second!=null){
			lca--;
			first=first.parent;
			second=second.parent;
		}
		return lca;
	}
	private int depth(ATree node){
		
		int depth=-1;
		while(node!=null && node.parent!=null){
			node=node.parent;
			depth++;
		}
		return depth;
	}
	
	private ATree constructBSTWithoutRebalance(int[] arr){
		
		for(int a: arr)
			root=insert(a,root,root,0);
		
		return root;
	}
	
	private ATree insert(int a,ATree root,ATree parent, int level){
	
		if(root==null){
			ATree node= new ATree(a);
			node.parent=parent;
			node.level=level;
			map.put(a, node);
			depth.put(a, level);
			return node;
		}
		else if(root.val>a)
			root.left=insert(a, root.left,root,level+1);
		else
			root.right=insert(a, root.right,root,level+1);
		
		return root;
	}
	
	
	private ATree constructBST(int[] arr,int start, int end,ATree parent){
		
		if(start>end)
			return null;
		
		int mid=(start+end)/2;
		
		ATree root=new ATree(arr[mid]);

		root.parent=parent;
		root.left =constructBST(arr, start, mid-1,root);
		root.right =constructBST(arr, mid+1, end,root);
		
		map.put(arr[mid], root);
		
		return root;
	}
	
	private void inorder(ATree node){
		if(node==null)
			return;
		
		inorder(node.left);
		System.out.print(node.val+",");
		inorder(node.right);
	}
	
	
	
	public static void main(String[] args) {
	
		int[] a= {5,3,6,1,4,2};
		//Arrays.sort(a);
		Array_BST_LCA aa=new Array_BST_LCA();
		//ATree n=aa.constructBST(a, 0, a.length-1,null);
		ATree n=aa.constructBSTWithoutRebalance(a);
		//aa.inorder(n);
		
		System.out.println(aa.depth);
		
		System.out.println(aa.distanceTwoNodes(2,6));
		System.out.println(aa.distanceTwoNodes(2,1));
		System.out.println(aa.distanceTwoNodes(2,3));
		System.out.println(aa.distanceTwoNodes(2,5));
		System.out.println(aa.distanceTwoNodes(2,2));
		System.out.println(aa.distanceTwoNodes(6,2));
		System.out.println(aa.distanceTwoNodes(12,2));
		
	}
	
	public void printMap(){
	
		for(Integer y: map.keySet()){
			ATree x=map.get(y);
			
			
			System.out.print(x.val+",");
			System.out.print(x.left==null?null:x.left.val+",");
			System.out.print(x.right==null?null:x.right.val);
			System.out.println(x.parent==null?null:x.parent.val);
		}
		
	}
}

