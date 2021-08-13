package algo.string_and_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TwoSum_DataStructure {
/*
设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。

实现 TwoSum 类：

TwoSum() 使用空数组初始化 TwoSum 对象
void add(int number) 向数据结构添加一个数 number
boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
 

示例：

输入：
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
输出：
[null, null, null, null, true, false]

解释：
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4，返回 true
twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-iii-data-structure-design
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public void add(int val){
		if(map.containsKey(val)) return;
		else map.put(val, 1);
	}
	
	public boolean find(int k){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		
		while(it.hasNext()){
			Integer curKey = it.next();
			Integer diff = k - curKey;
			if(map.containsKey(diff)) return true;	
		}
		return false;
	}

	
	public static void main(String args[]){
		TwoSum_DataStructure twoSum = new TwoSum_DataStructure();
		twoSum.add(1);
		twoSum.add(2);
		twoSum.add(3);
		
		
		System.out.println(twoSum.find(3));

	}
}
