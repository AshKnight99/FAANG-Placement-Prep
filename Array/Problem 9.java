/*
560. Subarray Sum Equals K
Medium

5826

193

Add to List

Share
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int i = 0,j = 0,sum = 0,cnt = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        //map.put(0,1);
        for (i = 0;i < nums.length;i ++){
            sum += nums[i];
            if(sum == k)
                cnt ++;
            if(map.containsKey(sum - k)){
                cnt += map.get(sum - k);
            }if(map.containsKey(sum))
                map.put(sum,map.get(sum) + 1);
            
            else
                map.put(sum,1);            
        }
        return cnt;
    }
}

