package digit;

public class ReadEachDigit {

	public void readEachDigit(){
		int number = 1001;

		while (number > 0) {
			System.out.println(number % 10);
			number = number / 10;
		}
	}
	
	public void readEachDigit2(){
		String strNum = "10010";
		char[] charNums = strNum.toCharArray();
		for(int index = 0; index < charNums.length ; index++){
			System.out.println("-----------------------------------");
			System.out.println("character is: " + charNums[index]);
			System.out.println("index is: " + index);
			
			Character eachChar = charNums[index];
			String strEachDigit = eachChar.toString();
			
			if(strEachDigit.equals("1")){
				for(int i=1; i < charNums.length-index; i ++){
					System.out.println("add zero");
					strEachDigit = strEachDigit.concat("0");
				}
			}
			System.out.println("string to prepare enotice type is: " + strEachDigit);
		}
	}


	public static void main(String[] args){
		ReadEachDigit red = new ReadEachDigit();
		red.readEachDigit2();
	}
}
