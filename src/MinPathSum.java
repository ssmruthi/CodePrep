public class MinPathSum{
	
	int[][] mem= new int[1000][1000];

	public MinPathSum() {
	
		
	}
	
	public int minpathsumWithMem(int[][] path,int row, int column){
		
		int down=0;
		int right=0;
		
		if(mem[row][column] >0){
			//System.out.println("from mem");
			return mem[row][column];
		}
		
		if(row==path.length-1 && column<path[row].length-1){
			
			mem[row][column]=minpathsumWithMem(path,row,column+1)+path[row][column];
		
		}else if(row<path.length-1 && column==path[row].length-1){
			
			mem[row][column]=minpathsumWithMem(path,row+1,column)+path[row][column];
			
		}else if(row==path.length-1 && column==path[row].length-1){ 
			
			mem[row][column]= path[row][column];
			
		}else if(row <path.length-1 && column<path[row].length-1){
			
			right= minpathsumWithMem(path,row,column+1)+path[row][column];
			down = minpathsumWithMem(path,row+1,column)+path[row][column];
			mem[row][column]=Math.min(down,right);
			
			
		}
			
		return mem[row][column];
			
	}
	
	
public int minpathsum(int[][] path,int row, int column){
		
		int down=0;
		int right=0;
		
		if(row==path.length-1 && column<path[row].length-1){
			return minpathsum(path,row,column+1)+path[row][column];
			
		}else if(row<path.length-1 && column==path[row].length-1){
			return minpathsum(path,row+1,column)+path[row][column];
			
		}else if(row==path.length-1 && column==path[row].length-1){ 
			return path[row][column];
			
		}else if(row <path.length-1 && column<path[row].length-1){
			
			right= minpathsum(path,row,column+1)+path[row][column];
			down = minpathsum(path,row+1,column)+path[row][column];
			return Math.min(down,right);
			
		}
			
		return 0;
			
	}
}