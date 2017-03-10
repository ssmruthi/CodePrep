public class UnsortedSubArray {

    public static String unsortedSubArray(int[] arr) {
    	
    	//find window
    	int left=0;
    	int right=arr.length;
    	int min=Integer.MAX_VALUE;
    	int max=Integer.MIN_VALUE;
    	
    	for(int i=0;i<arr.length-1;i++){
    		
    		if(arr[i+1] <arr[i]){
    			left=i;
    			break;
    		}
    	}
    	
    	for(int j=arr.length-1;j>1;j--){
    		
    		if(arr[j-1] > arr[j]){
    			right=j;
    			break;
    		}
    	}
    	
    	for(int i=left;i<right;i++){
    		min=Math.min(min, arr[i]);
    		max=Math.max(max, arr[i]);
    	}
    	
    	for(int i=0;i<left-1;i++){
    		if(arr[i] > min){
    			left=i;
    			break;
    		}
    	}
    	
    	for(int j=arr.length-1;j>right;j--){
    		if(arr[j] <max){
    			right=j;
    			break;
    		}
    	}
    	
    	return left+","+right;
    }
}