package JAVA;

import java.util.concurrent.Callable;

class Sample111 implements Runnable{

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class Sample11 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class Sample1 extends Thread{
	
	String s1="";
	String s2="";
	
	Sample1(String s1,String s2){
		this.s1=s1;
		this.s2=s2;
	}
	
		
	@Override
	public void run(){
		
		synchronized(s1){
			System.out.println(s1);
			
			synchronized(s2){
				System.out.println(s2);
			}
		}
	}
}

class Sample2 extends Thread{
	
	String s1="";
	String s2="";
	
	Sample2(String s1,String s2){
		this.s1=s1;
		this.s2=s2;
	}
	
//	ArrayIndexOutOfBoundsException;
	@Override
	public void run(){
		
		synchronized(s2){
			System.out.println(s2);
			
			synchronized(s1){
				System.out.println(s1);
			}
		}
	}
}

public class Multithreading {

	
	public static void main(String[] args) {
		


		String s1="a";
		String s2="b";
		
		Thread sample= new Sample1(s1,s2);
		Thread sample2= new Sample2(s1,s2);
		
		sample.start();
		sample2.start();
		
	}	
}
