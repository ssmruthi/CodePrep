import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArraysHeap {

		
	public static void operations(int[][] a){
	
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		List<Integer> sort= new ArrayList<Integer>();
		
		int j=0;
		int n=a[0].length;
		
		while(j<n){		
			for(int i=0;i<a.length;i++){				
				pq.offer(a[i][j]);
			}				
			sort.add(pq.remove());
			j++;
		}
		
		while(!pq.isEmpty()){
			sort.add(pq.remove());
		}
		
		
		System.out.println(sort);
	}
	
	

	

}
