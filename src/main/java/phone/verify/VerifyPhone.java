package phone.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerifyPhone {
	
	public String getVerifyCode(){
		List<Integer> numbers = new ArrayList<>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }

	    Collections.shuffle(numbers);
	    
	    String result = "";
	    for(int i = 0; i < 4; i++){
	        result += numbers.get(i).toString();
	    }
	    return result;
	}
	
	public static void main(String[] args){
		VerifyPhone vp = new VerifyPhone();
		System.out.println(vp.getVerifyCode());
		
	}
}
