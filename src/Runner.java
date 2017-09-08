import LinkedListPackage.LinkedList;
import LinkedListPackage.Node;
import LinkedListPackage.RemoveNthNode;

public class Runner {

	public static void main(String[] args) throws Exception {

		System.out.println(new java.util.LinkedList<Integer>().add(null));
	}
	
	
	private static int[][] autogenerateMatrix(int m, int n){
		
		int[][] a= new int[m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				a[i][j]=(int)(Math.random()*10);
			}
		}
		
		return a;
	}
	
	
	private static void print2DMatrix(int[][] inp){
		for(int[]a:inp)
			printMatrix(a);
		
		System.out.println("-------------------");

	}
	
	private static void printMatrix(int[] inp){
		for(int a: inp){
			System.out.print(a+",");
		}
		System.out.println();
	}

}
