package DP;

import java.util.ArrayList;
import java.util.List;

/*
 * A[i]==i 
 * Return all Magic Indices
 */
public class MagicIndexA {

  public List<Integer> magicIndex(int[] arr){

	  List<Integer> a= new ArrayList<Integer>();
     magicIndex(arr,0,arr.length-1,a);
    return a;
  }

  /*
   * O(logN);
   */
  private void magicIndex(int[] arr, int start, int end,List<Integer> res){

    if(arr==null || end<start)
      return;

    int mid= (start+end)/2;

    if(arr[mid]==mid){
    	res.add(mid);
    }
      
    magicIndex(arr, mid+1, end,res);      
    magicIndex(arr,start,mid-1,res);
    
  }
  
  
  public static void main(String[] args){
	  
	  int[] arr={-1,-2,1,2,4,5,6};
	  
	  System.out.println(new MagicIndexA().magicIndex(arr));
	  
	  
  }
	
	
}