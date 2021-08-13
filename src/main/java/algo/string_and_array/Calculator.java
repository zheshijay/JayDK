package algo.string_and_array;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;


/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. 

Each operand may be an integer or another expression. For example:


  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class Calculator {

	public boolean isOperator(String str){
		if("+-*/".contains(str)) return true;
		return false;
	}



	//start 4:40
	public  int cal(String[] s){

		int i=0, len =s.length;

		if(isOperator(s[0]) || isOperator(s[1])) return -1;

		Stack<String> stack = new Stack<String>();

		for(String eachStr: s){
			if(!isOperator(eachStr)) stack.push(eachStr);
			else{
				Integer int1 = Integer.parseInt(stack.pop());
				Integer int2 = Integer.parseInt(stack.pop());

				System.out.println( int1 + " " +  eachStr  + " " + int2);

				if(eachStr.equals("+")) stack.push((int2 + int1) + "");
				if(eachStr.equals("-")) stack.push((int2 - int1) + "");
				if(eachStr.equals("*")) stack.push((int2 * int1) + "");
				if(eachStr.equals("/")) stack.push((int2 / int1) + "");
			}

		}

		int res = Integer.parseInt(stack.pop());
		return res;

	}

	public static void main(String args[]){
		String[] str = new String[]{"2", "1", "+", "3", "*"};

		Calculator test = new Calculator();

		int res = test.cal(str);

		System.out.println(res);
	}

	@Test
	public void testMyProgram(){
		Calculator test = new Calculator();

		//case 1
//		String[] str1 = new String[]{"2", "1", "+", "3", "*"};
		String[] str1 = new String[]{"2", "1", "+", "3"};
		assertEquals(test.cal(str1),9);

		//case 2
//		String[] str2 = new String[]{"4", "13", "5", "/", "+"};
//		assertEquals(test.cal(str2),6);

	}


}
