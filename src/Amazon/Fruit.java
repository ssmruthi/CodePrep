package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fruit {

	public static void main(String[] args) {

		List<List<String>> cList1= new ArrayList<List<String>>();
		List<List<String>> cList2= new ArrayList<List<String>>();
		
		
		String[][] codeList1 = {{"apple", "apple"},{"orange", "banana", "orange"}};
		String[] shoppingList1 = {"orange", "apple", "apple", "orange", "banana", "orange"};
		 
		String[][] codeList2     = {{"apple", "apple","orange"}, {"banana","orange", "apple"}}    ;
		String[] shoppingList2 = {"xxxx","apple","apple", "orange", "banana", "orange","yyyy","apple"};
		
		

		List<String> sList1= Arrays.asList(shoppingList1);
		List<String> sList2= Arrays.asList(shoppingList2);
		
		for(String[] s: codeList1){
			cList1.add(Arrays.asList(s));
		}
		
		for(String[] s: codeList2){
			cList2.add(Arrays.asList(s));
		}

		//System.out.println(shopList(cList1, sList1));
		System.out.println(shopList(cList2, sList2));
	}


	private static int shopList(List<List<String>> codeList, List<String> shoppingList){

		int len_code=codeList.size();
		int len_shop=shoppingList.size();

		if(len_code<1)
			return 1;
		if(len_shop<1)
			return 0;
			
		int i_shop=0;
		int i_code=0;
		int i_curr=0;
		
		while(i_shop<len_shop){
		
			// i_curr=0;

			List<String> currentList= codeList.get(i_code);
				
			while(currentList.get(i_curr).equals("anything") || currentList.get(i_curr).equals(shoppingList.get(i_shop))){
				i_curr++;
				
				if(i_curr==currentList.size()){
					i_curr=0;
					i_code++;			
					break;
				}
					
				i_shop++;
				
				if(i_shop==len_shop)
					break;		
			}
			
			i_shop++;
			
			if(i_code==len_code)
				return 1;
		
		}

		return 0;

	}
}
