package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class KeyboardRow {
	public static String[] findWords(String[] words) {
		String[] keyboardButtons = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		ArrayList<String> resultList = new ArrayList<String>();


		for( String eachWord: words ){

			System.out.println("====================================");
			System.out.println("Checking word: "+ eachWord);

			for(String eachBottonLine: keyboardButtons){
				boolean isOneRowWord = true;
				
				for(int i=0; i< eachWord.length(); i++){
					
					System.out.println("checking " + eachWord + " using BottonLine "+ eachBottonLine );
					System.out.println("checking each word: " + eachWord.charAt(i) );
					
					if(!eachBottonLine.contains(Character.toString(eachWord.charAt(i)).toUpperCase())) isOneRowWord = false;
				}

				System.out.println("--> "+ isOneRowWord);
				if(isOneRowWord){
					resultList.add(eachWord);
				}
			}
		}

		String[] array = resultList.toArray(new String[resultList.size()]);
		return array;
	}

	public static void main(String[] args){
		String[] result = KeyboardRow.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
		
		for( String eachWord: result ){
			System.out.println("===> result: " + eachWord);
		}
		


	}

}
