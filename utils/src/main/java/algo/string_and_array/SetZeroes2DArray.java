package algo.string_and_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetZeroes2DArray {
	/*
	 * ����һ�������������Ŀ��Ŀ�����ȷ������������������Ԫ��Ϊ0���ͰѶ�Ӧ���к��������Ԫ�ض����?0�������������������������?0��ʱ����ֱ�ӰѾ���������ڵ�ǰ����ֱ����?0��������滹û���ʵ��Ļᱻ����ԭ����?0������Ѻܶ಻����?0�����ж���0�ˡ�
һ��ֱ�ӵ��뷨�Ǳ���һ������Ȼ���ڱ��ݾ������жϣ���ԭ��������0��������Ȼ�ǿ��Եģ������ռ临�Ӷ���O(m*n)�����Ǻ����롣
����ķ�������Ż��أ����ǿ�����ʵ�ж�ĳһ���ǲ���0ֻҪ������Ӧ���л�����Ӧ��Ӧ����0�Ϳ��ԣ��������ǿ���ά��һ���к��еĲ������飬Ȼ��ɨ��һ������¼��һ�л������ǲ���Ӧ����0���ɣ����渳ֵ��һ������ʱ����жϡ����ַ����Ŀռ临�Ӷ���O(m+n)��
	 * 
	 * 
	 * 
	 * 1. Copy of array
	 * 
	 * O( m * n)
	 * 
	 * 
	 * 2. use a array to save which row and col need to set to zero
	 * 
	 * O( m + n )
	 */



	public void setZeroes(int[][] matrix) {
		if(matrix.length == 0) return;
		boolean firstRowZero = false, firstColZero = false;
		// ��¼��Щ����Щ����Ҫ��0�����ж����������Ƿ���Ҫ��0
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i != 0 && j != 0 && matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				} else if (matrix[i][j] == 0){
					// ������л����г���?0����������Ҫ��0�����������ϴ�ֵ
					firstRowZero = i == 0 ? true : firstRowZero;
					firstColZero = j == 0 ? true : firstColZero;
				}
			}
		}
		// �����������е�λ����0
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[0][j] == 0 || matrix[i][0] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		// �����Ҫ����������?0
		for(int i = 0; firstColZero && i < matrix.length; i++){
			matrix[i][0] = 0;
		}
		// �����Ҫ����������?0
		for(int j = 0; firstRowZero && j < matrix[0].length; j++){
			matrix[0][j] = 0;
		}
	}

	public void mySetZeros(int[][] matrix){
		HashMap<Integer, Boolean> zeroRow = new HashMap<Integer, Boolean>();
		HashMap<Integer, Boolean> zeroCol = new HashMap<Integer, Boolean>();


		for(int i=0; i< matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0) {
					zeroRow.put(i, true);
					zeroCol.put(j, true);
				}
			}
		}

		//set rows to zero
		Set keySet = zeroRow.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()){
			int row = it.next();
			for(int i =0; i< matrix[0].length; i++){
				matrix[row][i] = 0;
			}
		}

		//set cols to zero
		Set keySet2 = zeroRow.keySet();
		Iterator<Integer> it2 = keySet2.iterator();
		while(it2.hasNext()){
			int col = it.next();
			for(int i =0; i< matrix.length; i++){
				matrix[i][col] = 0;
			}
		}
	}
	
	
	public void printMatrix(int[][] matrix){
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j< matrix[i].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		
		
	}
	
	public static void main(String args[]){
		
		SetZeroes2DArray test = new SetZeroes2DArray();
		
		int[][] matrix = new int[3][3];
		
		matrix[0][0] = 1;
		matrix[0][1] = 1;
		matrix[0][2] = 1;
		
		matrix[1][0] = 1;
		matrix[1][1] = 0;
		matrix[1][2] = 1;
		
		matrix[2][0] = 1;
		matrix[2][1] = 1;
		matrix[2][2] = 1;
		
		System.out.println("---------- before -----------");
		test.printMatrix(matrix);
		
		System.out.println("---------- after -----------");
		
		test.setZeroes(matrix);
		
		test.printMatrix(matrix);
		
		
		
	}
}
