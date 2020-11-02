/*
978. Longest Turbulent Subarray
A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
Return the length of a maximum size turbulent subarray of A.
Example 1:

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
Example 2:

Input: [4,8,12,16]
Output: 2
Example 3:

Input: [100]
Output: 1
 
Note:
1 <= A.length <= 40000
0 <= A[i] <= 10^9
*/
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if(n < 2)
            return n;
        
        int right = 1;
        boolean flag = false;
        int curr = 1, global = 1;
        
        if(A[0] < A[1] || A[1] < A[0]){
            global = 2;
        }else{
            global = 1;
        }
        
        for(;right < n - 1; right++ ){
            if((A[right] > A[right - 1] && A[right] > A[right + 1]) || (A[right] < A[right - 1] && A[right] < A[right + 1])){
            flag = true;
            curr ++;
            }
            
            else{
                if(flag)
                    global = Math.max(global,curr + 1);
                else
                    global = Math.max(global,curr);
                curr = 1;
                flag = false;                
            }          
              if(flag)
                    global = Math.max(global,curr + 1);
                else
                    global = Math.max(global,curr);
        }
        return global;        
    }
}