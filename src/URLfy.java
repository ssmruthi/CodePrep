public class URLfy {

	//O(n) space and O(n) Time
	public String replaceSpace(String input, int trueLen){
			
		char[] newString1 = new char[trueLen*3];
		for(int i=0,j=0;i<trueLen;i++){				
						
			if(input.charAt(i)==' '){
				newString1[j++] = '%';
				newString1[j++] = '2';
				newString1[j++] = '0';
			}else{
				newString1[j++]=input.charAt(i);
			}
			
		}
		System.out.println(new String(newString1));
		return newString1.toString();
	}
	
	public static String replace20(String input, int truelen){
		
		char[] inp=input.toCharArray();
		int start=truelen-1;
		int end=inp.length-1;	
		
		while(start!=end){
			
			if(inp[start]==' '){
				inp[end--]='0';
				inp[end--]='2';
				inp[end--]='%';
				start--;
			}else{
				inp[end--]=inp[start--];
			}
		}
		
		return new String(inp);		
	}
}
