package JAVA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLambdas {

	public static void main(String[] args) {

		int[] a= {1,2,3,4};
		
		List<Integer> l=Arrays.stream(a).boxed().collect(Collectors.toList());
		int[] b=l.stream().mapToInt(i->i).toArray();
	
	
	}	
}
