package algo.string_and_array;

public class ReverseVowelsString {

	public boolean isVowels(Character c){
		if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u' || c == 'A' || c == 'E' ||c == 'I' ||c == 'O' ||c == 'U') return true;

		return false;
	}

	public String reverseVowels(String s) {
		char[] charArray = s.toCharArray();
		int left=0, right = charArray.length-1;
		
		while(left < right){
			if(!isVowels(charArray[left])) left++;
			else if(!isVowels(charArray[right])) right--;
			else{
				char temp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right]= temp;
				left++; right--;
			}
		}
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		ReverseVowelsString test = new ReverseVowelsString();
		String str1 = "leetcode";
		String str2 = "aA";
		System.out.println(test.reverseVowels(str2));

	}

}
