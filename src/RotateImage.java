
/*
 * Arrays and Strings
 * Rotate image by 90 clockwise
 * image represented by int value
 */
public class RotateImage {
	
	public static int[][] rotateImage (int[][] a){
		
		int top=0;
		int left=0;
		int bottom=a.length-1;
		int right=a.length-1;
		int N=a.length;
		
		while(N>1){
			int i=0,j=bottom;

			while(i<=N-1){
				int temp = a[top][i]; // 8
				
				a[top][i]=a[j][left]; //5
				a[j][left]=a[bottom][j]; //0
				a[bottom][j]=a[i][right]; //1
				a[i][right]=temp; //8
				
				i++;
				j--;
			}
			
			top++;left++;
			bottom--;right--;
			N=N-2;
		}
		
		
		return a;
		
	}
	
	
}