package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//           return false;
//        }
//        
//        int[] count = new int[256];
//        
//        for (int i = 0; i < s.length(); i++) {
//            count[(int) s.charAt(i)]++;
//        }
//        
//        for (int i = 0; i < t.length(); i++) {
//            count[(int) t.charAt(i)]--;
//            if (count[(int) t.charAt(i)] < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
    
    public static boolean myAnagram(String s1, String s2){
    	
    	if(s1==null || s2==null ||s1.length() !=s2.length()) return false;
    	
    	//ASCII
    	boolean[] appeard = new boolean[256];
    	
    	//iterate s1 and mark appeared character to true
    	for( int i=0; i<s1.length(); i++){
    		appeard[(char) s1.charAt(i)] = true;
    	}
    	
    	//iterate s2, return false if new character found
    	for( int j=0; j<s2.length(); j++){
    		if(!appeard[s1.charAt(j)]) return false;
    		
    	}
    	return true;
    }

	public static void main(String[] args)
	{
		
		System.out.println( myAnagram("abcde", "edcab") );
//		cba
//		bab
//		aba
//		bac
//		System.out.println(myIsAnagram("bab", "abc"));
				
		
//		isAnagram("Mother In Law", "Hitler Woman");
//
//		isAnagram("keEp", "peeK");
//
//		isAnagram("SiLeNt CAT", "LisTen AcT");
//
//		isAnagram("Debit Card", "Bad Credit");
//
//		isAnagram("School MASTER", "The ClassROOM");
//
//		isAnagram("DORMITORY", "Dirty Room");
//
//		isAnagram("ASTRONOMERS", "NO MORE STARS");
//
//		isAnagram("Toss", "Shot");
//
//		isAnagram("joy", "enjoy");
	}

}
