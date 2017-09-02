package MathandProbability;

import java.util.Random;

public class Rand7{
	
	
	public int getRand7(){ //between 1 to 7
		
		
		while(true){
			int a=getRand5();
			int b=getRand5();
			
			int c=5*b+a;		 // uniform generated between 0-24

			if(c<22){  //if 23 and 24 are included increases probaility of 2 and 3
				return c%7+1;
			}
		}
	}
	

private int getRand5(){
	return new Random().nextInt(4);
}

}


