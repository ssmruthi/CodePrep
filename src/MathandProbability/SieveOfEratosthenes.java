package MathandProbability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {

	private static List<Integer> generatePrime(int n){
	
		List<Integer> result= new ArrayList<Integer>();
		boolean[] prime= new boolean[n+1];
		
		Arrays.fill(prime, true);
		prime[0]=false;
		prime[1]=false;
		
		for(int i=2;i<=n;i++){
			
			for(int j=i+1;j<prime.length;j++){
				
				if(prime[j] && j%i==0){
					prime[j]=false;
				}
			}
		}
		
		for(int i=1;i<prime.length;i++){
			
			if(prime[i]){
				result.add(i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(generatePrime(10));
		System.out.println(generatePrime(20));
		System.out.println(generatePrime(50));
		System.out.println(generatePrime(100));

	}

}
