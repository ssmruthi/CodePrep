public class SearchRotatedArray {

	
	public static int search(int[] arr, int x){
		return search(arr,x,0,arr.length-1);
	}
	//no duplicates
	public static int search(int[] arr, int x,int start, int end){
		
		
		int mid= (start+end)/2;
		
		if(arr[mid]==x)
			return mid;
		
		if(start>=end)
			return -1;
		
		if(x> arr[start]){
			
			
		}else{
			
		}
		
		/*
		if(x < arr[mid]){
			
			if(arr[start] < arr[mid] && x > arr[start])				
				return search(arr,x, start, mid);
			else
				return search(arr,x, mid+1, end);
			
			
		}else if(x > arr[mid]){
			if(arr[mid] < arr[end] &&  x < arr[end])
				return search(arr,x, mid+1, end);
			else
				return search(arr,x, start, mid);
		}*/
		
		return -1;
		
	}
	
	
	
}
