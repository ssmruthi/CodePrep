package ArraysandStrings;

import java.util.Arrays;
import java.util.HashMap;

public class FourSum {
	public Integer[][] foursum(int[]a, int val){
	
		HashMap<Integer,String> sum= new HashMap<Integer,String>();
		
		for(int i=0;i<a.length;i++){
		
			for(int j=i+1;j<a.length;j++){
				
				String m=i+","+j;
				sum.put(a[i]+a[j], m);
	
			}
		
		}
		
		
		for(int key: sum.keySet()){
		
			int comp=val-key;
			
			if(sum.containsKey(comp)){
			
				String sumPair=sum.get(key);
				String compPair=sum.get(comp);
	
				if(!sumPair.equals(compPair)){
					
					String[] pair1=sumPair.split(",");
					String[] pair2=compPair.split(",");
					
					Integer[][] r= {
							{a[Integer.valueOf(pair1[0])],a[Integer.valueOf(pair1[1])]},
							{a[Integer.valueOf(pair2[0])],a[Integer.valueOf(pair2[1])]}
							};
					
					return r;
					
				}
				
			}
		
		}
	
		return null;
	
	}
	
	public static void main(String[] args) {
		
		int[] a= {1,2,3,4,5,6,7,8};
		Integer[][] x=new FourSum().foursum(a, 20);
		
		
		for(Integer[] z:x){
			System.out.println(Arrays.asList(z));
		}
	}
}

