package leetcode;

public class HammingDistance {

public static int getStringHammingDistance(String sequenceX, String sequenceY) {
    int a = 0;
   // String sequenceX = sequence1.toLowerCase();
    //String sequenceY = sequence2.toLowerCase();
    if (sequenceX.length() != sequenceY.length()) {
        return -1; //input strings should be of equal length
    }

    for (int i = 0; i < sequenceX.length(); i++) {
        if (sequenceX.charAt(i) != sequenceY.charAt(i)) {
            a++;
        }
    }
    return a;
}

public static int hammingDistance(int x, int y) {
    int z = x^y;             // use exclusive-or ("xor") operation to get the different and then calculate the 1s
    int hamDis = 0;
    
    System.out.println(" z is : " + z);
    
// Method 1
    String xor = Integer.toBinaryString(z);
    
    for(char eachChar: xor.toCharArray()){
    	if(eachChar == '1') hamDis ++;
    }
    
// Method 2
//    while(z != 0) {           
//        if (z%2 == 1) {
//        	hamDis++;
//        }
//        z = z/2;
//    }
    return hamDis;
}



	public static void main(String[] args){

//		System.out.println(Integer.toBinaryString(1));
		
//		System.out.println(HammingDistance.getStringHammingDistance("abce", "abcd"));
		System.out.println(HammingDistance.hammingDistance(1, 4));
	}
	
}
