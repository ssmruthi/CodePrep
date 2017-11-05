package JAVA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ComparatorExample {

	public static void sortEmployee(Employee[] employeeList){
		Arrays.sort(employeeList, new Comparator<Employee>(){
			
			public int compare(Employee e1, Employee e2){
				return e1.employeeName.compareTo(e2.employeeName);
			}
		});
		System.out.println(employeeList);
	}
	
	public static Map<Integer,String> sortHashMap(Map<Integer,String> map){
		
		List<Map.Entry<Integer,String>> valueList=new ArrayList<Map.Entry<Integer,String>>(map.entrySet());
		
		Collections.sort(valueList, new Comparator<Map.Entry<Integer,String>>(){

			@Override
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		Map<Integer,String> newMap= new LinkedHashMap<Integer,String>();
		for(Map.Entry<Integer, String> entry: valueList){			
			System.out.println(entry);
			newMap.put(entry.getKey(), entry.getValue());
		}
		
		return newMap;
		
	}
	
	

	
	//Integer[] desc
	
	public static Integer[] sortDescInteger(Integer[] array){
		
		Arrays.sort(array, new Comparator<Integer>(){
			
			public int compare(Integer a1, Integer a2){
							
				
				// return positive number if you want to swap order,else return negative number
				if(a1<a2){
					return 1;
				}else{
					return -1;
				}
			}
		});
		
		return array;
	}
	
	//Sort a list desc
	public static List<String> sortDescList(List<String> stringList){
		
		Collections.sort(stringList, new Comparator<String>(){
			
			public int compare(String s1, String s2){
				
				return s2.compareTo(s1);
			}
		});
				
		return stringList;		
		
	}
	
	// sort 2D array rowwise and columnwise descending
	
	/*
	1 2 3 4					8 7 6 5
	5 6 7 8   	becomes		4 3 2 1 */
	
		
	public static Integer[][] sort2DArray(Integer[][]arr){
		
		//sort the rows desc first
		for(Integer[] a: arr){
			sortDescInteger(a);
		}
		
		//sort columns
		Arrays.sort(arr, new Comparator<Integer[]>(){
			
			public int compare(Integer[] a1, Integer[] a2){
				
				return a2[0].compareTo(a1[0]);
			}
		});
		
		return arr;
	}
	
	
	public static Map<String,Integer> sortHashMapByValues(Map<String,Integer> map){
		
		List<Map.Entry<String,Integer>> valueList= new ArrayList<Map.Entry<String,Integer>>( map.entrySet());
		
		Collections.sort(valueList, new Comparator<Map.Entry<String,Integer>>() {
			
			@Override
			public int compare(Map.Entry<String,Integer> s1, Map.Entry<String,Integer> s2){
				//return s2.getValue().compareTo(s1.getValue());
				return s2.getKey().compareTo(s1.getKey());
			}
		});
		
		Map<String,Integer> newMap= new LinkedHashMap<String,Integer>();
		
		for(Map.Entry<String,Integer> value:valueList){			
			newMap.put(value.getKey(), value.getValue());
		}
		return newMap;
		
	}


}

class Employee{
	
	Employee(int id, String name){
		this.employeeId=id;
		this.employeeName=name;
	}
	
	int employeeId;
	String employeeName;
}
