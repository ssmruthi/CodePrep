import java.text.ParseException;

public class MainClass {

	public static void main(String[] args) {

		/*UniqueString uniqueString= new UniqueString();
		System.out.println(uniqueString.isUniqueString("xyt"));
		*/
		
		/*PermutationString ps= new PermutationString();
		System.out.println(ps.isPermuation("abxxb", "axxbb"));
	*/
		
		/*URLfy url= new URLfy();
		url.replaceSpace("abc d", 4);*/
		/*
		PalindromePermutation palinPer= new PalindromePermutation();
		System.out.println(palinPer.isPalinPermutation("aabbcddee"));*/
		
		try {
			new DateConversion().convert("9:12:12AM");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
