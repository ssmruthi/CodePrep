package ArraysandStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoSum {
	// Hash Set with all the arrays

	// {1,2,3,5,4} 7
	// {2,5,5} 7
	// {2,5(2)}, 7
	public List<String> twosumallpairs(int[] arr, int val) {

		List<String> result = new ArrayList<String>();
		Map<Integer, Integer> inp = new HashMap<Integer, Integer>();
		Set<Integer> comp = new HashSet<Integer>();

		for (int a : arr) {
			int c = 0;
			if (inp.containsKey(a))
				c = inp.get(a);

			inp.put(a, c + 1);
		}

		for (int a : arr) {

			if (comp.contains(val - a)) {

				for (int i = 0; i < inp.get(val - a); i++)
					result.add(a + ":" + (val - a));
			} else
				comp.add(a);

		}

		return result;

	}

	public int countsumallpairs(int[] arr, int val) {

		Map<Integer, Integer> inp = new HashMap<Integer, Integer>();

		for (int x : arr) {
			int c = 0;
			if (inp.containsKey(x))
				c = inp.get(x);

			inp.put(x, c + 1);

		}

		HashSet<Integer> comp = new HashSet<Integer>(); // 5
		int count = 0;

		for (Integer x : inp.keySet()) { // 2,5

			if (comp.contains(x)) { //
				count = count + (inp.get(x) * inp.get(val - x)); // 2
			} else {
				comp.add(val - x);
			}

		}

		return count;
	}

	public int[] twosum(int[] arr, int val) {

		Set<Integer> input = new HashSet<Integer>();
		
		for (int a : arr) {
			if (input.contains(val - a)) {
				int[] x = { a, val - a };
				return x;
			}
			input.add(a);
		}

		return null;
	}

	public static void main(String[] args) {
		int[] a = { 2, 5, 5, 2 };
		Integer[] b = { 2, 5, 5, 2 };

		int val = 10;
		
		int[] x=new TwoSum().twosum(a, val);
		
		System.out.println(Arrays.asList(b));
		System.out.println(Arrays.stream(x).boxed().collect(Collectors.toList()));

	}

}
