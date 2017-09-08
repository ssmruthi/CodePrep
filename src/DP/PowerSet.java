package DP;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	public List<ArrayList<Integer>> powerSet(List<Integer> a) {

		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		return powerSet(a, res);
	}

	private List<ArrayList<Integer>> powerSet(List<Integer> a, List<ArrayList<Integer>> res) {

		if (a == null)
			return res;

		if (a.isEmpty()) {
			res.add(new ArrayList<Integer>());
			return res;
		}

		Integer prefix = a.remove(a.size() - 1);
		res = powerSet(a, res);

		res = mergePrefix(prefix, res);

		return res;

	}

	private List<ArrayList<Integer>> mergePrefix(Integer p, List<ArrayList<Integer>> res) {

		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for (List<Integer> x : res) {
			ArrayList<Integer> t = new ArrayList<Integer>();
			t.addAll(x);
			t.add(p);
			result.add(t);
		}
		result.addAll(res);

		return result;

	}

	public static void main(String[] args) {

		List<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);

		System.out.println(new PowerSet().powerSet(x));
	}

}