package src.Problem1;

import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		int [] testcase1 = {-5, 6, 7, 8, -11, 2};
		int target1 = 9;
		
		int [] res = findTwoSum(testcase1, target1);
		
		System.out.println("First Index is : " + res[0]);
		System.out.println("Second Index is : " + res[1]);
	}
	
	public static int[] findTwoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> accessoryHashMap = new HashMap<Integer, Integer>();
		
		for (int i=0; i < nums.length; i++) {
			if ( accessoryHashMap.containsKey(target-nums[i]) ) {
				return new int[] { accessoryHashMap.get(target - nums[i]), i };
			}
			
			accessoryHashMap.put(nums[i], i);
		}
		
		return new int[]{-1, -1};
	}
}
