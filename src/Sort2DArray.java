import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArray {

	public static void sort(){
		
		Integer[][] temp ={{3,1},{5,17},{4,8}};
		
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[i].length;j++){
				System.out.print(","+temp[i][j]);
			}
		System.out.println("************");
		}
		
		Arrays.sort(temp, new Comparator<Integer[]>(){
			
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0].compareTo(o2[0]);
			}
		});
		
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[i].length;j++){
				System.out.print(","+temp[i][j]);
			}
		System.out.println();
		}
		
	}
	
	
	public void sort(Integer[][] arr){
		
		Arrays.sort(arr, new Comparator<Integer[]>(){
			
			@Override
			public int compare(Integer[] a1, Integer[] a2){
				return a1[0].compareTo(a2[0]);
			}
		});
	}
	
	public void sort3D(Integer[][][] arr){
		
	for(int i=0;i<arr.length;i++){
			
			Arrays.sort(arr[i], new Comparator<Integer[]>(){
			
			@Override
			public int compare(Integer[] a1, Integer[] a2){
				return a1[0].compareTo(a2[0]);
			}
			});
		}
	}
}
