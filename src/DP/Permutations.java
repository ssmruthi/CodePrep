package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations{

	
	public List<String> permutations(String input){
		 
		 Map<String,List<String>> m= new HashMap<String, List<String>>(); 
		 List<String> x=permutations(input, m);
		 
		// System.out.println(m);
		 return x;
		 
	 }
    public List<String> permutations(String input, Map<String, List<String>> m){

      List<String> result= new ArrayList<String>();

      if(input==null || input.isEmpty()){
        result.add("");
        return result;
      }

      if(m.containsKey(input))
    	  return m.get(input);
      
      for(int i=0;i<input.length();i++){
      
        char prefix = input.charAt(i);
        int index=input.indexOf(prefix);

        String newInput=input.substring(0,index)+input.substring(index+1);
        
        List<String> subResult=permutations(newInput,m);
       
        
        for(String temp:subResult){
          temp=prefix+temp;
          
          if(!result.contains(temp))
          result.add(temp);
    
        }
        m.put(input, result);
      }

      return result;
    
    }

    public static void main(String[] args){
    	
    	Permutations p=new Permutations();
    	
    	long start= System.currentTimeMillis();
    	System.out.println(p.permutations("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    	long end=System.currentTimeMillis()-start;
    	
    	System.out.println(end);
    	
    }

}