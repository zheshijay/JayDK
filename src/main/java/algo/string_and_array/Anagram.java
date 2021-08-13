package algo.string_and_array;

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
    		if(!appeard[s2.charAt(j)]) return false;
    	}
    	return true;
    }
    
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }



    
	public static void main(String[] args)
	{
//		String s1 = "abcde";
//
//		int[] appeard = new int[256];
//		
//		
//		appeard['a'] = 1;
		
		
		
//		System.out.println((int) 'a');
		System.out.println( myAnagram("aacc", "acac") );
//		System.out.println( myAnagram("abcde", "edcba") );
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
