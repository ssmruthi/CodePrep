package DP;

/*
 * A[i]==i 
 * Return all Magic Indices
 */
public class MagicIndexWithDup {

    public int magicIndex(int[] arr){
        return magicIndex(arr,0,arr.length-1);
    }

    private int magicIndex(int[] arr, int start,int end){

      if(arr==null || start>end)
        return -1;
      
      int mid= (start+end)/2;

      if(arr[mid]==mid)
        return mid;

      
      int left= magicIndex(arr,start,Math.min(mid-1,arr[mid-1]));
      if(left>-1)
        return left;

      int right= magicIndex(arr,Math.max(mid+1,arr[mid+1]),end);

      return right;
        
    }
    
    public static void main(String[] args){
  	  
  	  int[] arr={-1,2,2,2,4,5,6};
  	  
  	  System.out.println(new MagicIndexWithDup().magicIndex(arr));
  	  
  	  
    }

}