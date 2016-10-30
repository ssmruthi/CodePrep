import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicatesRegex {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String[] s= new String[n];
        
        for(int i=0;i<n;i++){
          s[i]=sc.next();
            char[] tempC=s[i].toCharArray();
          Arrays.sort(tempC);
            s[i]=new String(tempC);
            s[i]=s[i].replaceAll("(.)(?=.*\\1)","");                    
        }
       
        Map<Character,Integer> counter= new HashMap<Character,Integer>();
        int finalCount=0;
        
        for (int k=0;k<n;k++){
            int value=0;
            for(int j=0;j<s[k].length();j++){
                char key=s[k].charAt(j);
               
                if(counter.containsKey(key))
                   value= counter.get(key);
                else
                    value=0;
                
                counter.put(key,++value);
                if (value>=n){
                    finalCount++;
                }
            }
        }
        
        System.out.println(finalCount);
        
      
    }
}