import java.util.ArrayList;
import java.util.List;

public class MatrixSpiral {
	
	
	public static List<Integer> printSpiralMatrix(int[][] mat){
		
		List<Integer> result= new ArrayList<Integer>();
		
		int beginR=0;
		int beginC=0;
		int endC=mat[0].length-1;
		int endR=mat.length-1;
		
		
		//else
		while(beginR<=endR || beginC<=endC){
			
			
			//one column
			if(beginC==endC){		
					printColumn(mat,endC,beginR,endR,result);			
					return result;
			}
		
			//one Row
			if(beginR==endR){
				while(beginC<=endC){
					result.add(mat[beginR][beginC]);
					beginC++;
				}
				return result;
			}
						
			printRow(mat,beginR,beginC,endC-1,result);
			printColumn(mat,endC,beginR,endR-1,result);			
			printRowReverse(mat,endR,beginC+1,endC,result);
			printColumnReverse(mat,beginC,beginR+1,endR,result);
			
			endR--;
			endC--;
			beginR++;
			beginC++;

		}
			
		return result;
		
	}
	
	private static void printRow(int[][] mat,int row, int startColumn, int endColumn, List<Integer> result){
		
		while(startColumn<=endColumn){
			result.add(mat[row][startColumn]);
			startColumn++;			
		}
		
	}
	
	private static void printRowReverse(int[][] mat,int row, int startColumn, int endColumn, List<Integer> result){
		while(endColumn>=startColumn){
			result.add(mat[row][endColumn]);	
			endColumn--;
		}
	}
	
	private static void printColumn(int[][] mat,int column, int startRow, int endRow, List<Integer> result){
		
		while(startRow<=endRow){
			result.add(mat[startRow][column]);	
			startRow++;
		}
		
	}
	
	private static void printColumnReverse(int[][] mat,int column, int startRow, int endRow, List<Integer> result){
		
		while(endRow>=startRow){
			result.add(mat[endRow][column]);
			endRow--;
		}
	}
	
}