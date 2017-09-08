package DP;

import java.util.Arrays;

public class TripleStep {

	/*
	 * Without Memoization O(3^n)
	 */
	public int countWays(int n) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		else
			return (countWays(n - 1) + countWays(n - 2) + countWays(n - 3));

	}

	/*
	 * With Memoization
	 */
	public int countWaysWithMem(int n) {
		
		int[] mem = new int[n+1];
		Arrays.fill(mem, -1);
		return countWaysWithMem(n, mem);
	}
	public int countWaysWithMem(int n, int[] mem) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		else if (mem[n] != -1) {
			return mem[n];
		} else {

			mem[n] = (countWaysWithMem(n - 1, mem) + countWaysWithMem(n - 2, mem) + countWaysWithMem(n - 3, mem));
			return mem[n];
		}

	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

	//	System.out.print(new TripleStep().countWays(40));

		long end = System.currentTimeMillis() - start;
		System.out.println("----"+end);
		start = System.currentTimeMillis();

		System.out.print(new TripleStep().countWaysWithMem(40));

		end = System.currentTimeMillis() - start;
		System.out.println("----"+end);

	}
}