/*
N/3 Repeat Number
Asked in: Google
You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 
*/
public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    //Boyers - Moores Algorithm
	    int count1 = 0, count2 = 0;
	    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
	    for(int i = 0;i < a.size(); i++){
	        if(first == a.get(i))
	            count1++;
	        else if(second == a.get(i))
	            count2++;
	        else if(count1 <= 0){
	        count1 = 1;
	        first = a.get(i);
	        }
	        else if(count2 <= 0){
	        count2 = 1;
	        second = a.get(i);
	        }
	        else{
	            count1 --;
	            count2 --;
	        }
	    }
	    count1 = 0;
	    count2 = 0;
	    int n = a.size();
	    for(int i = 0;i < a.size(); i++){
	        if(first == a.get(i))
	            count1++;
	        else if(second == a.get(i))
	            count2++;
	        if(count1 > n / 3 )
	            return first;
	        else if(count2 > n / 3)
	            return second;
	    }
	    return -1;
	}
}