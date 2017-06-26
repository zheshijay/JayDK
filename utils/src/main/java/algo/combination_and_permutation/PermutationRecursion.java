package algo.combination_and_permutation;

public class PermutationRecursion {
	 static void swap(char[] chars, int index1, int index2){
		char tmp;
		tmp=chars[index1];
		chars[index1] = chars[index2];
		chars[index2] = tmp;
	}

	public void permute(char[] chars, int start){
		//print 
		if(start == chars.length) {
			System.out.println(chars);
		}else{
			for( int i=start; i<chars.length; i++ ){
				swap(chars, start, i );     //swap 
				
				permute(chars, start+1);   //now we have fixed head, then permute the rest of the chars
				
				swap(chars, start, i );    //restore the modified chars for next i loop
			}
		}
	}

   public static void main(String[] args){
	   PermutationRecursion test = new PermutationRecursion();
	   test.permute(new char[]{'a', 'b','c'}, 0);
   }
}
