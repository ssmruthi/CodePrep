public class BinarySearch{
	
	public static int binarySearch(int[]arr, int value,int start, int end){
		
		if(arr.length==0)
			return -1;
		
		int mid=(start+end)/2;
		
		if(start < end){		
			if(arr[mid]==value)
				return mid;
			
			if(arr[mid] > value)
				return binarySearch(arr, value, start, mid);
			else
				return binarySearch(arr, value, mid+1, end);
		}
		
		return -1;
		
	}
	
}

