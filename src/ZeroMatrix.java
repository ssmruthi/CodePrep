
public class ZeroMatrix {


	public static int[][] zeromatrix(int[][] m){
		
		boolean firstRow=false;
		boolean firstCol=false;
		
		for(int x=0;x<m.length;x++){
			if(m[x][0]==0){
				firstCol=true;
				break;
			}						
		}
		

		for(int x=0;x<m[0].length;x++){
			if(m[0][x]==0){
				firstRow=true;
				break;
			}
		}
		
		
		
		for(int i=1;i<m.length;i++){
			for(int j=1;j<m[i].length;j++){
			
				if(m[i][j]==0){
					m[0][j]=0;
					m[i][0]=0;
				}
			}
			
		}
		
		for(int x=0;x<m.length;x++){
			if(m[x][0]==0){
				nullifyRow(x, m);
			}						
		}
		
		for(int x=0;x<m[0].length;x++){
			if(m[0][x]==0){
				nullifyCol(x, m);
			}						
		}
		
		if(firstRow)
			nullifyRow(0,m);
		if(firstCol)
			nullifyCol(0, m);
		
		return m;
		
	}
	
	private static void nullifyRow(int i, int[][]m){
		
		//set row to zero

		for(int x=0;x<m[i].length;x++){
			m[i][x]=0;
		}
		
	}
	

	private static void nullifyCol(int j, int[][]m){
		
		//set column to zero
		for(int x=0;x<m.length;x++){
			m[x][j]=0;
		}
		
	}
	
	
	
}