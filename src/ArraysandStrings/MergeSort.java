package ArraysandStrings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort{
	
public static void main(String[] args) {
	int[] arr={12,5,56};
	arr=new MergeSort().mergeSort(arr,0,arr.length-1);
	
	System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
}
private int[] mergeSort(int[] arr, int start, int end){

	if(start<end){
	
		int mid=(start+end)/2;
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1,end);
		merge(arr, start,mid,end);
	
	}
	return arr;
}

private int[] merge(int[] arr, int start, int mid, int end){

	
	int[] left= new int[mid-start+1];
	int[] right= new int[end-mid];
	
	int i=0,j=0,k=start;
	
	while(i<left.length){
		left[i]=arr[start+i];
		i++;
	}
	while(j<right.length){
		right[j]=arr[mid+1+j];
		j++;
	}
	
	i=0;j=0;k=start;
	
	while(i<left.length && j<right.length){

		if(left[i] < right[j]){
			arr[k++]=left[i];
			i++;
		} else{
			arr[k++]=right[j];
			j++;
		}
	}

	while(i<left.length){
		arr[k++]=left[i++];
		
	}


	while(j<right.length){
		arr[k++]=right[j++];
		
	}

	return arr;
	
}
}