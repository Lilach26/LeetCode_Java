/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Example 3:
Input: nums = [0]
Output: [0]

Example 4:
Input: nums = [1]
Output: [1]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/

class Solution 
{
    public void sortColors(int[] nums) 
    {
        int[] counter = new int[3];
        int j = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            counter[nums[i]]++;
        }
        
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < counter[i]; k++)
            {
                nums[j + k] = i;
            }
            
            j += counter[i];
        }
    }
}

// another solution:

class Solution 
{
    public void sortColors(int[] nums) 
    {
        int first = 0, current = 0, last = nums.length - 1, temp;
        
        while (current <= last)
        {
            if (nums[current] == 0)
            {
                temp = nums[current];
                nums[current++] = nums[first];
                nums[first++] = temp;
            }
            else if (nums[current] == 2)
            {
                temp = nums[current];
                nums[current] = nums[last];
                nums[last--] = temp;
            }
            else
            {
                current++;
            }
        }
    }
}
