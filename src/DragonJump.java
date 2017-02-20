public class DragonJump {

    
    
    public static int minjump(int[] arr){
    	
    	int i=1;
    	int reach=arr[i-1];
    	int max=i;
    	int step=1;
    	
    	
    	while(reach<arr.length-1 && i<=reach){
    	
    		
    		//get max elemnt in the next reach possible
    		if(arr[i+1] > arr[max]){
    			max=i+1;
    		}
    		
    		if(arr[max]==0)
    			return 0;
    		
    		if(i==reach){
    			i=max;
    			reach=i+arr[max];
    			step++;
    			
    		}else{
        		i++;
    		}
    		
    	}   	
    	
    	return step;
    }
}