package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a dictionary
 * [i, like, ice],see if it could form a word ilikeice and ice
 */
public class WordPartition {

	private boolean dictionaryContains(Set<String>dict, String word){
		
		if(word.length()==0)
			return true;
		return dict.contains(word);
		
	}
	
	public List<String> wordPartiton(String input,Set<String> dict){
		
		List<String> words= new ArrayList<String>();
		System.out.println(wordPartiton(input,dict,words));
		return words;
	}
	public boolean wordPartiton(String input,Set<String> dict,List<String> words){
		
		
		if(input==null || input.length()==0)
			return true;
		
		if(words.contains(input))
			return true;
		
		for(int i=1;i<=input.length();i++){
			String prefix=input.substring(0,i);
			String suffix=input.substring(i,input.length());
			
			if (dictionaryContains(dict, prefix) && wordPartiton(suffix,dict,words)){
				words.add(input);
				return true;
			}
			
		}
		
		if(words.isEmpty())
			return false;
		else
			return true;
		//return false;
	}
	
	
	public boolean wordPartiton2(String input,Set<String> dict){
	
		boolean dp[]= new boolean[input.length()+1];
		dp[0]=true;
		
		for(int i=1;i<input.length();i++){
			for(int j=0;j<i;j++){
				String prefix= input.substring(j,i);
				
				if(dp[j] && dict.contains(prefix)){
					dp[i]=true;
				}
			}
		}
		
		return dp[input.length()];
	}
	
	public List<String> wordPartiton3(String input,Set<String> dict){
		
		boolean dp[]= new boolean[input.length()+1];
		List<String> words= new ArrayList<String>();
		
		dp[0]=true;
		
		for(int i=1;i<=input.length();i++){
			for(int j=0;j<i;j++){
				String prefix= input.substring(j,i);
				
				if(dp[j] && dict.contains(prefix)){
					dp[i]=true;
					words.add(prefix);
				}
			}
		}
		
		return words;
	}
	
	public static void main(String[] args) {

		Set<String> dict= new HashSet<String>();
		dict.add("ice");
		dict.add("cream");
		dict.add("like");
		dict.add("i");

		
		List<String> words=new WordPartition().wordPartiton3("icecream", dict);
		
		System.out.println(words);
	}

}
