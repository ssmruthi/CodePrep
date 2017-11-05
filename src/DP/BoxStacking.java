package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Box{
	int width;
	int height;
	int depth;
	
	Box(int w,int h, int d){
		width=w;
		height=h;
		depth=d;
		
	}
	
	public boolean isStackValid(Box next){
		int width=next.width;
		int height=next.height;
		int depth=next.depth;
		
		return (this.width >width && this.height>height && this.depth>depth);
	}

	@Override
	public String toString() {
		return "Box [width=" + width + ", height=" + height + ", depth=" + depth + "]";
	}
	
	
}


public class BoxStacking {

	public static int getHeight(List<Box> boxes){
		int height=0;
	
		//Sort descending
		Collections.sort(boxes, new Comparator<Box>() {
			
			@Override
			public int compare(Box a, Box b){
				return b.height-a.height;
			}

		});
		
		Map<Integer,List<Box>> resultMap= new HashMap<Integer,List<Box>>();
		int[] stack=new int[boxes.size()];
		
		
		for(int i=0;i<boxes.size();i++){
			List<Box> result= new ArrayList<Box>();
			int h=getStack(boxes, i,result,stack);
			height=Math.max(h, height);
			resultMap.put(h, result);
			
		}
		
		
		System.out.println(resultMap.get(height));
		System.out.println("------------------");

		return height;
		
	}
	
	
	private static int getStack(List<Box> boxes, int index, List<Box> result, int[] stack){
		
		if(stack[index]!=0)
			return stack[index];
		
		int maxHeight=0;
		Box current=boxes.get(index);
		
		for(int i=index+1;i< boxes.size();i++){
			
			Box next=boxes.get(i);
			
			if(current.isStackValid(next)){
				int h=getStack(boxes,i,result,stack);
				maxHeight=Math.max(maxHeight,h);
			}
			
		}
		maxHeight=maxHeight+current.height;
		stack[index]=maxHeight;
		
		//Adding the respective heights
		result.add(current);
		
		return maxHeight;
	
	}
	
	public static void main(String[] args) {
		
		
		Box[] boxList = { new Box(1,3,2), new Box(4,6,5), new Box(7,9,8), new Box(11,10,12), new Box(12,20,14)};
		ArrayList<Box> boxes = new ArrayList<Box>();
		for (Box b : boxList) {
			boxes.add(b);
		}
		
		int height = getHeight(boxes);
		System.out.println(height);
	}
}
