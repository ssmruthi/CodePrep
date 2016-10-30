import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonDominatedPairs {

     static long min=0;
     static long max=0;
    
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        Long[][] ab= new Long[n][2];
                
        for(int i=0;i<n;i++){
        	ab[i][0]=sc.nextLong(); sc.nextLine();
        	ab[i][1]=sc.nextLong(); sc.nextLine();
        }
        
        
        for(int i=0;i<n ;i++)
        	System.out.println(ab[i][0]+" "+ab[i][1]);
        
        java.util.Arrays.sort(ab, new java.util.Comparator<Long[]>() {
        	  public int compare(Long[] a, Long[] b) {
        	    return (a[0] > b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
        	  }
        	});
 
        long bMax=0;
        long aPrev=ab[0][0];
        List<String> answer= new ArrayList<String>();
        
        for(int i=0;i<n ;i++){
        	if(ab[i][1] > bMax || ab[i][0] == aPrev){        		
        		answer.add(" ("+ab[i][0]+","+ab[i][1]+") ");       	
        		bMax=ab[i][1];
        	}
        	aPrev=ab[i][0];
        }
        
        System.out.println(answer);
    }
}