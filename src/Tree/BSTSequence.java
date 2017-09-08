package Tree;

import java.util.ArrayList;
import java.util.List;

public class BSTSequence {
	
	public void weaveTwoLists(List<Integer> list1,List<Integer> list2,List<String> res){
	
	    if(list1.size()==0 || list2.size()==0){
	      res.add(list1.toString());
	      res.add(list2.toString());
	      return;
	    }
	
	    
	}
	
	
	public static void main(String[] args){
		
		List<Integer> list1= new ArrayList<Integer>();
		List<Integer> list2= new ArrayList<Integer>();
		List<String> res= new ArrayList<String>();

		list1.add(1);
		
		list2.add(4);
		list2.add(5);
		
		new BSTSequence().weaveTwoLists(list1, list2, res);
		
		System.out.println(res);
	
	}
}

