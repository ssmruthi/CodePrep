import java.util.*;

/*
 * Input: 2 differenet strings
 * Output : Longest common substring between the 2
 * Eg: str1= abcde, str 2= xxxaabcdfyy, output=bcd, length 3 
 * 
 * */

public class LongestCommonSubstring {
	
	public static String longestCommonSubstring(String input1,String input2){
		
		int max=0;
		char[] string1=input1.toCharArray();
		char[] string2=input2.toCharArray();
		int[][] result=new int[string1.length+1][string2.length+1];
		String resultString=null;
		
		for(int i=0;i<string1.length;i++){
			for(int j=0;j<string2.length;j++){
				
				if(string1[i]==string2[j]){
					
					if(i==0 || j==0){
						result[i][j]=1;
					}
					else{
						result[i][j]=result[i-1][j-1]+1;
					}
					
					if(max<result[i][j]){
						max=Math.max(max, result[i][j]);
						resultString=input1.substring(i-max+1, i+1);
					}
					
				}
			}
		}
		return resultString;
	}
	
	
	
	   
}