/*
345. Reverse Vowels of a String
Write a function that takes a string as input and reverse only the vowels of a string.
Example 1:
Input: "hello"
Output: "holle"
Example 2:
Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
*/
class Solution {
    public String reverseVowels(String s) {
        char arr[] = s.toCharArray();
        List <Character> vowelList = new ArrayList<>(List.of('a','e','i','o','u','A','E','I','O','U'));
        int i = 0, j = arr.length - 1;
        while(i < j){
            while(!vowelList.contains(arr[i]) && i < j)
                i ++;
            while(!vowelList.contains(arr[j]) && i < j)
                j --;
            //System.out.print(arr[i] + " j: " + arr[j]);
            char temp = arr[i];
            arr[i ++] = arr[j];
            arr[j --] = temp;            
        }
        return String.valueOf(arr);
    }
}