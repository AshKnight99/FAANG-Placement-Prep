/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
*/

class Solution {
    public int[] findDuplicate(int[] arr) {
        //Using Floyd cycle detection algorithm
        int slow = arr[0]; 
        int fast = arr[arr[0]]; 
       
        while (fast != slow)  
        { 
            slow = arr[slow];
            fast = arr[arr[fast]]; 
        } 
       
        fast = 0; 
        while (slow != fast) 
        { 
            slow = arr[slow]; 
            fast = arr[fast]; 
        } 
        
        //missing nos
        int sum = Arrays.stream(arr).sum();
        int n = arr.length + 1;
        n = n * (n -1) / 2;
        n = (n - sum + slow );
        
        return new int[]{slow,n}; 
    }
}
