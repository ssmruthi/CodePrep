import java.util.Arrays;

/*
 * Given a n*n matrix where numbers all numbers are distinct and are distributed from range 1 to n2, 
 * find the maximum length path (starting from any cell) such that all cells along the path are increasing order with a difference of 1.
 * We can move in 4 directions from a given cell (i, j), i.e., 
 * we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent
 * 
 * http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 */
	
public class ConsecutiveSequencein2DArray {

    public static int lengthofConsecutiveSeq(int[][] arr){
    	int[][] dp= new int[arr.length][arr[0].length];
    	
    	for(int x[]: dp)
    		Arrays.fill(x,-1);
    	
    	int max=0;
    
    	for(int i=0;i<arr.length;i++){
    		for(int j=0;j<arr[i].length;j++){
    			
    				max=Math.max(max,lengthofSequence(arr,i,j,dp));
    				System.out.print(dp[i][j]+",");
    		}
    		System.out.println();
    	}
    	
    	return max;
    	
    }
    
    private static int lengthofSequence(int[][] arr, int row, int column, int[][] dp){
    	
    	if(dp[row][column] != -1)
    		return dp[row][column];
    	
    	if(column< arr[row].length-1 && arr[row][column+1]- arr[row][column] ==1 ){
    		dp[row][column]=Math.max(lengthofSequence(arr, row, column+1, dp),dp[row][column])+1;
    	}
    	
    	if(column>0 && arr[row][column-1]- arr[row][column] ==1 ){
    		dp[row][column]=Math.max(lengthofSequence(arr, row, column-1, dp),dp[row][column])+1;
    	}
    	
    	if(row<arr.length-1 && arr[row+1][column]- arr[row][column] ==1 ){
    		dp[row][column]=Math.max(lengthofSequence(arr, row+1, column, dp),dp[row][column])+1;
    	}
    	
    	if(row>0 && arr[row-1][column]- arr[row][column] ==1 ){
    		dp[row][column]=Math.max(lengthofSequence(arr, row-1, column, dp),dp[row][column])+1;
    	}
    	
    	if(dp[row][column]==-1)
    		dp[row][column]=1;
    	
    	return dp[row][column];
    	
    }
}