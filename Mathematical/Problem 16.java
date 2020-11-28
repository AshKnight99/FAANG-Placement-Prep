/*
238. Product of Array Except Self
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pro = 1,zcnt = 0;
        for(int i = 0;i < nums.length;i ++){
           if(nums[i] != 0)
               pro *= nums[i];
            else
                zcnt ++;
        }
        for (int i = 0;i < nums.length;i ++){
            if(zcnt > 1){
                nums[i] = 0;               
            }
            else if(zcnt == 1){
            if(nums[i] == 0)
                nums[i] = pro;
            else
                nums[i] = 0;
            }
            else
            nums[i] = pro / nums[i];
        }       
        return nums;         
    }
}