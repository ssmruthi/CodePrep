package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public int[] removeDuplicates(int[] arr, int k) {

		List<Integer> ar = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < ar.size(); i = i + k) {
			int j=(i+k<ar.size())?i+k:(ar.size());
			result.addAll(removeDuplicates(ar.subList(i, j)));
		}

		return result.stream().mapToInt(i -> i).toArray();

	}

	private List<Integer> removeDuplicates(List<Integer> arr) {

		Set<Integer> hset = new LinkedHashSet<Integer>();

		for (int a : arr) {
			hset.add(a);
		}

		return new ArrayList<Integer>(hset);
	}

	public static void main(String[] args) {

		int[] arr= {1,1,2,2,1,1,1,4,4,5};
		arr=new  RemoveDuplicates().removeDuplicates(arr,3);
		
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
	}
}