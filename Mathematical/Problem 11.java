/*
628. Maximum Product of Three Numbers
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6
Example 2:
Input: nums = [1,2,3,4]
Output: 24
Example 3:
Input: nums = [-1,-2,-3]
Output: -6
Constraints:
3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
*/
public int maximumProduct(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;
        //For positive nos
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        // For negative nos
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; 
        int val = 0;
        for(int i = 0;i < n;i ++){
            val = nums[i];
            if(val > max1){
                max3 = max2;
                max2 = max1;
                max1 = val;
            }
            else if(val > max2){
                max3 = max2;
                max2 = val;
            }
            else if(val > max3)
                max3 = val;
            
            if(val < min1){
                min2  = min1;
                min1 = val;
            }
            else if(val < min2)
                min2 = val;
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);