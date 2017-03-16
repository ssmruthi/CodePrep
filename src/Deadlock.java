public class Deadlock {
	
	public static void main(String[] args){
		
		String first="first";
		String second="second";
		
		Thread t1= new Thread(new SampleThread(first,second));
		Thread t2= new Thread(new SampleThread(second,first));
		
		t1.start();
		t2.start();
	}
	
}

class SampleThread implements Runnable{
	
	
	String resourceOne;
	String resourceSecond;
	
	SampleThread(String resourceOne,String resourceSecond){
		this.resourceOne=resourceOne;
		this.resourceSecond=resourceSecond;
	}
	
	@Override
	public void run() {
		
		synchronized(resourceOne){
			System.out.println(Thread.currentThread()+"---"+resourceOne);
			synchronized(resourceSecond){
				System.out.println(Thread.currentThread()+"---"+resourceSecond);
			}
		}
		
	}
}