import java.util.Arrays;

public class MaxHeap {

int[] arr;
int heapSize;
int heapIndex=1;

MaxHeap(int size){
	heapSize=size;
	arr=new int[size+1];
}

public void insert(int data){
	
	arr[heapIndex]=data;
	
	int insertIndex=heapIndex;
	while(arr[insertIndex] > arr[insertIndex/2]){	
			swap(insertIndex,insertIndex/2);
		insertIndex=insertIndex/2;
	}
	
	heapIndex++;
}

public void removeMax(){

	arr[1]=arr[arr.length-1];
	
	
	int removeIndex=1;
	while(2*removeIndex < arr.length && (arr[removeIndex] < arr[(2*removeIndex)+1] || arr[removeIndex] < arr[(2*removeIndex)])){	
		
		if(arr[(2*removeIndex)+1] < arr[(2*removeIndex)]){
			swap(removeIndex,2*removeIndex);
			removeIndex=2*removeIndex;
		}else{ 
			swap(removeIndex,(2*removeIndex + 1));
			removeIndex=2*removeIndex +1;
		}		
		
	}

	arr=Arrays.copyOf(arr, arr.length-1);
	
}

private void swap(int sourceIndex, int destIndex){
	
	int temp= arr[sourceIndex];
	arr[sourceIndex]=arr[destIndex];
	arr[destIndex]=temp;
}

public void printHeap(){
	
	for(int a:arr){
		System.out.print(a+",");
	}
}
}
