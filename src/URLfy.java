public class URLfy {

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
}
