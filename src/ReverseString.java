
public class ReverseString {

	private static String reverse(String input){
	
		if(null==input || input.isEmpty())
			return input;
		
		char[] inp=input.toCharArray();
		int start=0,end=inp.length-1;
		
		while(start<=end){
			char temp=inp[start];
			inp[start]=inp[end];
			inp[end]=temp;
			
			start++;
			end--;
		}
		
		return String.valueOf(inp);
	}
	
	public static void main(String[] args) {

		System.out.println(reverse("abcd"));
		System.out.println(reverse("abecd"));
		System.out.println(reverse(""));
		System.out.println(reverse(null));
		
	}

}
