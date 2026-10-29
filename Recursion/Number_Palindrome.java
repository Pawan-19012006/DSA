// 9. Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.
// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

// https://leetcode.com/problems/palindrome-number/description/

class Solution {
    public boolean isPalindrome(int x) {
        return palindrome(x,0);
    }
    public boolean palindrome(int x, int i){
        String s = String.valueOf(x);
        int n = s.length();
        if(i>=n/2){
            return true;
        }

        if(s.charAt(i)==s.charAt(n-i-1)){
            return palindrome(x, i+1);
        }

        return false;
    }
}