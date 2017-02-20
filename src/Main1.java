import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main1 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
        }
    
        SortedMap<Integer,Integer> count= new TreeMap<Integer,Integer>();
      
        
        for(int a : types){
            
        	if(count.containsKey(a)){
        		int value=count.get(a);
        		count.put(a, value+1);
        	}else{
        		count.put(a, 1);
        	}
        }
        
        //Key key =
        	int key=	Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();

    	System.out.println(key);
    
    }
    
    
    
    public static void main(String[] args) {/*
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();

            char[] input= {'h','a','c','k','e','r','r','a','n','k'};
        int firstIndex=-1; 
        
        for(int i=0;i<input.length; i++){
            
        	s=s.substring(firstIndex+1);
        	firstIndex=s.indexOf(input[i]);
        	
        	System.out.println(s+"---"+input[i]+"---"+firstIndex);
            if(firstIndex < 0){
            	System.out.println("NO");
            	return;
            }            
        }
        
        System.out.println("YES");
          
          
        }
    */
    	System.out.println(buildLowestNumber("11111",3));	
    }
    
    
    public static String buildLowestNumber(String str,int n) {  
       
        int len = str.length();

        if (n == 0)
            return str;

        if (len <= n)
            return "";

        int minIndex = 0;
        for (int i = 1; i<=n ; i++)
            if (str.charAt(i) < str.charAt(minIndex))
                minIndex = i;

        String res = "";
        res+=str.charAt(minIndex);

        String new_str = str.substring(minIndex+1, len);
        res+=buildLowestNumber(new_str, n-minIndex);

        return res;
    }

}
