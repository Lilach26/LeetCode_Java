/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> result = new LinkedList();
        ArrayList<Integer> numsLast = new ArrayList<>();
        int n;
        
        for (int num : nums)
        {
            numsLast.add(num);
        }
        
        n = nums.length;
        backTrack(numsLast, result, 0, n);
        
        return result;
    }
    
    public void backTrack(ArrayList<Integer> nums, List<List<Integer>> output, int first, int n)
    {
        if (first == n)
        {
            output.add(new ArrayList<Integer>(nums));
        }
        
        for (int i = first; i < n; i++)
        {
            Collections.swap(nums, first, i);
            backTrack(nums, output, first + 1, n);
            Collections.swap(nums, first, i);
        }
    }
}
