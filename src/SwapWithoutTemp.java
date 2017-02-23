public class SwapWithoutTemp {

	public int[] swap(int[] a){
		
		a[0]=a[0]+a[1];
		a[1]=a[0]-a[1];
		a[0]=a[0]-a[1];
		
		/*
		 * a=a+b
		 * b=a-b
		 * a=a-b
		 */
		return a;
	}
	
}
