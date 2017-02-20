public class CheckBalanced {

	public static int sum;

	public static boolean checkBal(TreeNode root){
		
		try{
			getHeight(root);
			return true;
		}catch(Exception e){		
			return false;
		}
		
	}
	private static int getHeight(TreeNode root) throws ArithmeticException {
		
		
		int l=0;
		int r=0;
		if (root == null)			
			return 0;
		else if (root!=null &&(root.left ==null && root.right==null))
			return 1;
		else{
			l=getHeight(root.left)+1;
			r=getHeight(root.right)+1;
		}
				
		if(Math.abs(l-r) >1){

			System.out.println(l);
			System.out.println(r);
			throw new ArithmeticException();
		}
		else{
			if(l>r)
				return l;
			else
				return r;					
		}	
		
		
	}

	
	public static int getNode(TreeNode T,int A, int B) {
	
	 if(T==null)
		return 0;
	 
	 int le=0;
	 int re=0;
	
	 if(T.left!=null){
		 le=getNode(T.left,A,B);		 
	 }
	 
	 if(T.right!=null){
		 re=getNode(T.right,A,B);
		 
	 }
	 
	 if(le !=-1 && re !=-1){
		 sum=sum+le+re;		 
	 }
	 
	 if(T.data <A || T.data > B)
		 return -1;
	 
	 if(T.data >=A && T.data <= B)
		 return 1;


	 
     return sum;
	 }
}
