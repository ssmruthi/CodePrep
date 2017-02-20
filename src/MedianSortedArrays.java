public class MedianSortedArrays {
	
	public int getMedian(int[] arr1, int[] arr2){
		
		return getMedian(arr1, arr2, 0,arr1.length,0,arr2.length); 
	}
	
	
	
	public int getMedian(int[] arr1, int[] arr2, int start1, int end1, int start2, int end2){
		
		
		if(Math.abs(end1-start1) <=2 && Math.abs(end2-start2) <=2){			
			return (Math.max(arr1[start1], arr2[start2])+Math.min(arr1[end2], arr2[end2]))/2;
		} else{
			
			int m1 = (arr1[start1]+arr1[end1])/2;
			int m2 = (arr2[start2]+arr2[end2])/2;
			
			if(m1>m2){			
				return getMedian(arr1,arr2, start1,m1,m2,end2);
				
			}else if(m1 < m2){				
				return getMedian(arr1,arr2, m1,end1, start2,m2);
			}else{
				return m1;
			}
			
		}
			
		
	}
}
