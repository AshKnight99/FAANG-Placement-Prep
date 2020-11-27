/*
InterviewBit
Triplets with Sum between given range
Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
*/
public class Solution {
    public int solve(ArrayList<String> A) {
        double max1 = Double.parseDouble(A.get(0)), max2 = Double.parseDouble(A.get(1));
        double max3 = Double.parseDouble(A.get(2));
        
        for(int i = 3;i < A.size();i++){
            double val = Double.parseDouble(A.get(i));
            
            if(max1 + max2 + max3 > 1 && max1 + max2 + max3 < 2)
                return 1;
            if(max1 + max2 + max3 > 2){
                if(max1 > max2 && max1 > max3)
                max1 = val;
                else if(max2 > max1 && max2 > max3)
                max2 = val;
                else
                max3 = val;
            }
            else{
                //sum less then 1
                //replace the min val
                if(max1 < max2 && max1 < max3)
                max1 = val;
                else if(max2 < max1 && max2 < max3)
                max2 = val;
                else
                max3 = val;
            }
        }
        
        if(max1 + max2 + max3 > 1 && max1 + max2 + max3 < 2)
                return 1;
        else
                return 0;
    }
}