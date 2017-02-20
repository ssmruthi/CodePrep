import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ListMan  implements Runnable{
	
	
	static List<Integer> arr= new ArrayList<Integer>();
	
	public void run(){
		
		arr.add(2);
		arr.add(20);
		arr.add(24);
			
		Iterator it= arr.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}

}

public class ListManipulation{
	public static void main(String[] args) throws InterruptedException{
		
		Thread t1= new Thread(new ListMan());
		t1.start();
		Thread t2= new Thread(new ListMan());
		t2.start();
	}
	}