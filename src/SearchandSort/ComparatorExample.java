package SearchandSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ComparatorExample {


	private static Map<String,Integer> sortMapbyValues(Map<String, Integer> input){
	
		List<Map.Entry<String,Integer>> valuesList= new ArrayList<Map.Entry<String,Integer>>(input.entrySet());
		
		Collections.sort(valuesList,new Comparator<Map.Entry<String, Integer>>() {
			
			public int compare(Map.Entry<String,Integer> s1, Map.Entry<String,Integer> s2){
				return s1.getValue().compareTo(s2.getValue());
			}
		});
		
		
		Map<String,Integer> newMap= new LinkedHashMap<String,Integer>();
		
		for(Map.Entry<String,Integer> value:valuesList){			
			newMap.put(value.getKey(), value.getValue());
		}
		
		return newMap;
	}
	
	public static void main(String[] args) {
		Map<String,Integer> x= new HashMap<>();
		x.put("ab", 20);
		x.put("bc", 10);
		x.put("cd", 2);
		x.put("de", 12);
		x.put("ef", 5);
		
		
		System.out.println(sortMapbyValues(x));
		//cd ef bc de ab
	}
}

