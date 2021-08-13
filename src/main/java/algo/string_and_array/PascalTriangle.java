package algo.string_and_array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	
	/**
	 * 
	 * 
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]



[
[1],
[1,1],
[1,2,1],
[1,3,3,1],
[1,4,6,4,1]
]

	 * 
	 * @param numRows
	 * @return
	 */	
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
	}

	public static void main(String args[]){
		
		PascalTriangle test = new PascalTriangle();

		System.out.println(test.generate(5));
	}
}
