package ArraysandStrings;

public class TimePlanner {

 static int[] meetingPlanner(int[][] A, int[][] B, int dur) {

    if(A==null || B==null)
      return null;

    int i=0;
    int j=0;

    while(i<A.length && j<B.length){

      int maxStart= Math.max(A[i][0],B[j][0]);
      int minEnd= Math.min(A[i][1],B[j][1]);

      if(minEnd-maxStart >=dur && maxStart <=minEnd){

          int[] result={maxStart,maxStart+dur};
          return result;
      }else{

        if(A[i][1] <B[j][1])
          i++;
        else
          j++;
       }
    }
    int [] r={};
    return r;
 }

  public static void main(String[] args) {

	  int[][] A={{10,50},{60,120},{140,210}};
	    int[][] B={{0,15},{60,70}};
	    
	    int[] x=meetingPlanner(A,B,8);
	    
	    System.out.println(x[0]+":"+x[1]);
  }

}