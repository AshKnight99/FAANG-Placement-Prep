/*
680. Valid Palindrome II
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/
class Solution {
    public boolean validPalindrome(String s) {
        //boolean delete = false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci != cj) {
                return (palindrome(s, i + 1, j) || palindrome(s, i , j - 1));
            }
            i ++;
            j --;
        }
        return true;
    }
    
    private boolean palindrome(String s, int i, int j) {
        while ( i < j) {
            char ci =s.charAt(i ++);
            char cj = s.charAt(j --);
            if (ci != cj) {
                return false;
            }
        }
        return true;        
    }
}

/*
With recursion
class Solution {
    public boolean validPalindrome(String s) {
         if(s != null && s.length() > 0){
            return isValid(s, 0, s.length() - 1, 0);
        }
        return false;
    }
    
    private boolean isValid (String s, int start, int end, int count){
        if(count > 1)
            return false;
        if(start > end)
            return true;
        
        if(s.charAt(start) == s.charAt(end))
            return isValid(s, start + 1, end - 1, count);
        else{
            return isValid(s, start + 1, end , count + 1) || isValid(s, start, end - 1, count + 1);
        }            
    }    
}
*/