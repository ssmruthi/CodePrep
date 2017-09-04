package DP;

/*
 * A[i]==i
 */
public class MagicIndex {

  public int magicIndex(int[] arr){

    return magicIndex(arr,0,arr.length-1);
  }

  /*
   * O(logN);
   */
  private int magicIndex(int[] arr, int start, int end){

    if(arr==null || end<start)
      return -1;

    int mid= (start+end)/2;

    if(arr[mid]==mid)
      return mid;

    if(mid>arr[mid]){
      return magicIndex(arr, mid+1, end);      
    }else{
      return magicIndex(arr,start,mid-1);
    }
  }
  
  
  public static void main(String[] args){
	  
	  int[] arr={-1,-2,1,2,4,5,6};
	  
	  System.out.println(new MagicIndex().magicIndex(arr));
	  
  }
	
	
}