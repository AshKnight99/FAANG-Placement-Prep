/*
1191. K-Concatenation Maximum Sum
Given an integer array arr and an integer k, modify the array by repeating it k times.

For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].

Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.

As the answer can be very large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: arr = [1,2], k = 3
Output: 9
Example 2:

Input: arr = [1,-2,1], k = 5
Output: 2
Example 3:

Input: arr = [-1,-2], k = 7
Output: 0
 Constraints:
1 <= arr.length <= 10^5
1 <= k <= 10^5
-10^4 <= arr[i] <= 10^4
*/
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k == 1)
            return kadanesAlgorithm(arr);
        else{
            long sum = 0;
            for(int num :arr)
              sum += num;  
            
            int kdarr[] = new int[2 * arr.length];
            for(int i = 0;i < kdarr.length;i++){
                kdarr[i] = arr[i % arr.length];
            }     
            long ans = 0;
            if(sum <= 0 )
                ans = kadanesAlgorithm(kdarr);
            else
                ans = kadanesAlgorithm(kdarr) + (k - 2) * sum;
            if(ans < 0)
                return 0;
            return (int) (ans % (1000000007)); 
        }
    }
    public int kadanesAlgorithm(int arr[]){
        int sum = 0, ans = Integer.MIN_VALUE;
		for(int ele:arr){
			sum += ele;
			if(ans < sum)
				ans = sum;
			if(sum < 0)
				sum = 0;
		}
		return ans;
    }
}