package MathandProbability;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class ShuffleCards {

	
	private static int[] shuffle(int[] arr){
		
		for(int i=0;i<10;i++){
			
			int rand= new Random().nextInt(10-i);
			
			
			int temp=arr[i];
			arr[i]=arr[rand];
			arr[rand]=temp;
		}
		
		return arr;
	}
	public static void main(String[] args) {
		
		int[] arr=new int[10];
		
		for(int i=1;i<11;i++){
			arr[i-1]=i;
		}
		arr=shuffle(arr);
		
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));

	}

}
