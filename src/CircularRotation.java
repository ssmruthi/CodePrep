import java.util.Scanner;

public class CircularRotation {

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        
        int[] a = new int[n];
        a[0]=9;
        a[1]=1;
        a[2]=3;
        a[3]=5;
                
        for (int j=0;j<k;j++){            
            for(int i=0;i<n-1;i++){
                swap(i,n,a);
            }
        }        
        
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]);        
     }
    
    private static void swap(int i,int n, int[] a){
        int temp=a[i];
        a[i]=a[n-1];
        a[n-1]=temp;
    }
}
