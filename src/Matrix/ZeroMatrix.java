package Matrix;

public class ZeroMatrix {
	
	public static int[][] zeroMatrix (int[][] input){
		
		boolean firstRow=false;
		boolean firstCol=false;
		
		for(int i=0;i<input.length;i++)
			if(input[i][0]==0)
				firstCol=true;
		
		for(int j=0;j<input[0].length;j++)
			if(input[0][j]==0)
				firstRow=true;
		
		
		for(int i=1;i<input.length;i++)
			for(int j=1;j<input[i].length;j++)
				if(input[i][j]==0){
					input[i][0]=0;
					input[0][j]=0;
				}
		
		
		for(int i=1;i<input.length;i++){
			if(input[i][0]==0)
				nullifyRow(input,i);
		}
		
		for(int j=1;j<input[0].length;j++){
			if(input[0][j]==0)
				nullifyCol(input,j);
		}
		
		if(firstRow)
			nullifyRow(input,0);
		
		if(firstCol)
			nullifyCol(input,0);
		return input;
	}
	
	
	private static void nullifyRow(int[][] input, int row){
		
		for(int i=0;i<input[row].length;i++)
			input[row][i]=0;
	}
	
	private static void nullifyCol(int[][] input, int col){
		
		for(int i=0;i<input.length;i++)
			input[i][col]=0;
	}
	
	
}