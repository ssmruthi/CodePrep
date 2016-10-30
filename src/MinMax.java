import java.util.Scanner;

public class MinMax {

     static long min=0;
     static long max=0;
    
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter numbers:\n");
        long a= 1;//sc.nextInt(); sc.nextLine();
        long b=1000000000000L;//sc.nextInt();
        
        long result=0;
  
    if(a==b){
    	result=2*minMaxScore(generateIntArray(a));
    }else if(a<b){
	        for(long i=a;i<=b;i++){	        	
	            result+=minMaxScore(generateIntArray(i));
	        }
        }
        	
          
        System.out.print(result);      
        
    }
    
    private static long[] generateIntArray(long s){
    	
    	int len = Long.toString(s).length();
    	long[] x=new long[len];
    	for(int j=len-1;j>=0;j--){
    		x[j]=s%10;
    		s/=10;
    	}
    	return x;
    	
    }
    private static long minMaxScore(long[] a){
       
    	min=0;
    	max=0;
        for(int i=1;i<a.length-1;i++){
            if(a[i]>a[i+1] && a[i]>a[i-1]){
                max++;
            }else if((a[i]<a[i+1] && a[i]<a[i-1]) ||(a[i]==a[i+1] && a[i]==a[i-1])){
                min++;
            }
        }
        
        return min+max;
    }
}