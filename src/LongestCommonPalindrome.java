import java.util.*;

/*
 * Input: 2 differenet strings
 * Output : Longest common substring between the 2
 * Eg: str1= abcde, str 2= xxxaabcdfyy, output=bcd, length 3 
 * 
 * */

public class LongestCommonPalindrome {
	
	public static String longestCommonPalindrome(String input1){
		
		StringBuilder input2= new StringBuilder(input1);		
		return LongestCommonSubstring.longestCommonSubstring(input1, input2.reverse().toString());		
		
	}
	   
}