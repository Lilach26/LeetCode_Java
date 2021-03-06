/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

import java.util.HashMap;

public class MajorityElement 
{
	public int majorityElement(int[] nums)
	{
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		int i, size = nums.length, majority = size / 2, result = 0;
		
		for (i = 0; i < size; i++)
		{
			if (counts.containsKey(nums[i]))
				counts.replace(nums[i], counts.get(nums[i]) + 1);
			else
				counts.put(nums[i], i);
		}
		
		for (i = 0; i < size; i++)
		{
			if (counts.get(nums[i]) >= majority)
			{
				result = nums[i];
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		MajorityElement sol = new MajorityElement();
		int[] num = new int[] {3,2,3};
		System.out.print(sol.majorityElement(num));
	}
}
