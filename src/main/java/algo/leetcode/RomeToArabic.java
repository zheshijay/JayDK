package algo.leetcode;



public class RomeToArabic {
	
	
	
	
	//��������ת���������֣�
	// ��ǰ��������������֣����ĳ������ǰһ����С����Ѹ������뵽����У�
	// ��֮�����ڽ�������μ�ȥǰһ���������ϵ�ǰ�������
	// I��V��X��   L��   C��     D��     M
	// 1��5��10��50��100��500��1000
	private static int r2a(String in){
		int graph[] = new int[400];
		graph['I'] = 1;
		graph['V']=5;
		graph['X']=10;
		graph['L']=50;
		graph['C']=100;
		graph['D']=500;
		graph['M']=1000;
		char[] num = in.toCharArray();
		// �������������sum���ܼƺ�
		int sum = graph[num[0]];
		for(int i=0; i<num.length-1; i++){
			// �����i��i+1��Ļ���ֱ�����
			if(graph[num[i]] >= graph[num[i+1]]){
				sum += graph[num[i+1]];
			}
			// ���i��i+1С�Ļ������ܺ�sum��ȥi����ط�����������ͬʱ����i+1
			// ���൱�ں�ߵ�������ߵ����������ұߵ�������ߵ���
			else{
				sum = sum + graph[num[i+1]] - 2*graph[num[i]];
			}
		}
		return sum;
	}
	// ����������ת�������֣�
	// ������С������ǰ�����Ҳ��Ϊ�������֣�����һ����Ӧ����ֵ��Ϳ��Խ�������ˡ�
	// I��V��X��   L��   C��     D��     M
	// 1��5��10��50��100��500��1000
	private static String a2r(int aNumber){
		if(aNumber < 1 || aNumber > 3999){
			return "-1";
		}
		int[] aArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] rArray = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		String rNumber = "";
		for(int i=0; i<aArray.length; i++){
			while(aNumber >= aArray[i]){
				rNumber += rArray[i];
				aNumber -= aArray[i];
			}
		}
		return rNumber;
	}
	
	
	
	//My Code (another solution)
	private static int charToDigit(char in){
		char[] chars = {'I','V','X','L','C','D','M'};
		int[] digits = {1,5,10,50,100,500,1000};
		
		for(int i=0; i<7; i++){
			System.out.println("i: " + i);
			if(chars[i]== in){
				System.out.println("chars[i]: " + chars[i]);
				return digits[i];
			}
		}
		return 0;
	}
	
	static int findMaxIndex(char str[], int L, int R){
		int max = charToDigit(str[L]);
		int maxIndex = L;
		
		for(int i=L; i<=R; i++){
			int num = charToDigit(str[i]);
			if(num>max){
				max = num;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	static int romanToNum(char str[], int L, int R){
		if(L == R){
			return charToDigit(str[L]);
		}else if(L > R){
			return 0;
		}else{
			int mi = findMaxIndex(str, L, R);
			int max = charToDigit(str[mi]);
			int left = romanToNum(str, L, mi-1);
			int right = romanToNum(str, mi+1, R);
			return max - left + right;
		}
		
	}
	
	public static void main(String[] args) {
		String s = "IV";
//		System.out.println(r2a(s));
//		System.out.println(a2r(4));
		String roma = "MCMLIV";
		char[] chars = roma.toCharArray();
		System.out.println(romanToNum(chars, 0, 5));
	}
}

