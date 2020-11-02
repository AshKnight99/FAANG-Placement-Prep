/*
152. Maximum Product Subarray
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return -1;
        if(n == 1)
            return nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        int finalProduct = nums[0];
        int temp = 1;
        for(int i = 1;i < n;i++){
            temp = currMax;
            currMax = Math.max(nums[i],Math.max(temp * nums[i],currMin * nums[i]));   
            currMin = Math.min(Math.min(temp * nums[i],currMin * nums[i]),nums[i]);
            finalProduct = Math.max(finalProduct,currMax);
        }
        
        return finalProduct;       
            
    }
}