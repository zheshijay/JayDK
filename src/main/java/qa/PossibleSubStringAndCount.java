package qa;

import java.util.HashMap;
import java.util.Map;

public class PossibleSubStringAndCount {

	public static Map getCntOfPossSubStr(String input, int n){
		Map<String,Integer> substrMap=new HashMap<String,Integer>();

		for(int i=0; i+n<=input.length(); i++){

			String substr=input.substring(i, i+n);

			int frequency=1;

			if(substrMap.containsKey(substr)){

				frequency=substrMap.get(substr);
				frequency++;
			}

			substrMap.put(substr, frequency);


		}

		return substrMap;
	}


	public static void main(String[] args) {
		String str = "abcdefg";	
		Map map = getCntOfPossSubStr(str, 2);
		System.out.println(map);


	}

}
