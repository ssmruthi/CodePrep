import java.util.Scanner;

public class AlternatingChar {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
       // Scanner sc= new Scanner(System.in);
        int n=2;
        StringBuilder[] str= new StringBuilder[n];
        int[] count=new int[n];
            
        /*for(int i=0;i<n;i++){
            count[i]=0;
            str[i]=sc.next();                       
        }*/
        
        str[0]=new StringBuilder("AAAA");
        str[1]=new StringBuilder("ABAB");
        int j=0;
        for(StringBuilder s: str){
          
            for(int i=1;i<s.length();i++){
                if(s.charAt(i)==s.charAt(i-1)){
                  // s=s.deleteCharAt(i);
                  // i--;                   
                   count[j]++;
                    System.out.print(s+"  ");
                    System.out.println(i);
                }
            }
            j++;
        }
        for(int k=0;k<n;k++)
        System.out.println(count[k]);
    }
}