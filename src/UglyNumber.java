import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class UglyNumber {
	
	//uglynumber is a number divisble by 2 or 3 or 5 and  not anything else
	// Eg: 6, 8 are ugly whereas 14 is not as its divisble by 7
	
	public static boolean isUgly(int num){
		
		
		while(num>1){
					
			if(num%2==0){
				num=num/2;				
			} else if(num%3==0){
				num=num/3;				
			} else if(num%5==0){
				num=num/5;
			} else{
				return false;
			}
			
		}
		
		return true;
	}
	
	public static Integer nthUgly(int n){
		
		SortedSet<Integer> l= new TreeSet<Integer>();
		
		l.add(1);
		int i=1;
		int j=1;
		while(j<=n){
			
			l.add(i*2);
			l.add(i*3);
			l.add(i*5);
					
			i=i+1;
			j=j+3;
		}		

		System.out.println(l);
		Integer[] a= new Integer[n];
		a=l.toArray(a);
		
		return a[n-1];
	}
	
	public static int nthUglyNumber(int n) {
	    if(n<=0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	 
	    int i=0;
	    int j=0;
	    int k=0;
	 
	    while(list.size()<n){
	        int m2 = list.get(i)*2;
	        int m3 = list.get(j)*3;
	        int m5 = list.get(k)*5;
	 
	        int min = Math.min(m2, Math.min(m3, m5));
	        list.add(min);
	 
	        if(min==m2)
	            i++;
	 
	        if(min==m3)
	            j++;
	 
	        if(min==m5)
	            k++;
	    }
	 
	    System.out.println(list);
	    return list.get(list.size()-1);
	}
}