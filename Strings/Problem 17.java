/*
Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
*/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0)
            return "";
        String palindrome = new String();
        String s1 = "", s2 = ""; 
        for(int i = 0;i < n;i++){
            s1 = longestPal(s,i,i);
            if(s1.length() > palindrome.length())
                palindrome = s1;
            
            s2 = longestPal(s,i,i + 1);
            if(s2.length() > palindrome.length())
                palindrome = s2;
            
        } 
        return palindrome;
        
    }
    
    private String longestPal(String s, int left, int right){
          while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
              left --;
              right ++;
          }  
        return s.substring(left + 1,right);
    }
}