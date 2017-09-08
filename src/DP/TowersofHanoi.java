package DP;

import java.util.Stack;

class Tower{
  Stack<Integer> disks;
  int index;

  Tower(){
	  disks=new Stack<Integer>();
  }
}

public class TowersofHanoi{

  public void play(Tower source, Tower buffer, Tower dest, int n){

      if(n==0)
        return;
      
      if(n>1){
        play(source, dest, buffer,n-1);
      }
      //source to destination
      moveDisks(source.disks,dest.disks);
    //  dest.disks.push(source.disks.pop());
      
      // buffer to destination
      play(buffer, source, dest, n-1);
  }

  private void moveDisks(Stack<Integer> start,Stack<Integer> end){
	  
	  if(!start.isEmpty())
		  end.push(start.pop());
		  
	  
  }
  
  private  void printTowers(Tower source, Tower buffer, Tower dest) {

	  for(Integer a:source.disks){
		  System.out.print(a+",");
	  }
	  System.out.print("|");

	  for(Integer a:buffer.disks){
		  System.out.print(a+",");
	  }
	  System.out.print("|");
	  for(Integer a:dest.disks){
		  System.out.print(a+",");
	  }
	  
	  System.out.print("-----");

	  
	}
  public static void main(String[] args){

	  Tower source= new Tower();
	  Tower buffer= new Tower();
	  Tower dest= new Tower();

      Stack<Integer> diskStack= new Stack<Integer>();

      int n=5;

      for(int i=n;i>0;i--){
        diskStack.push(i);
      }

      source.disks=diskStack;
      
      TowersofHanoi t= new TowersofHanoi();
      t.printTowers(source,buffer,dest);

      t.play(source, buffer, dest, n);
      
      
      t.printTowers(source,buffer,dest);
  }


}