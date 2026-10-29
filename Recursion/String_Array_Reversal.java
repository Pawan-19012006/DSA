// 344. Reverse String
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.
// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

class Solution {
    public void reverseString(char[] s) {
        swap(s, 0); //giving just the string and the initial i value to the function
    }
    public void swap(char[] s, int i){
        int n = s.length;
        if(i>=n/2){ //base case, when the i value exceeds the middle value ie, n/2, then we need to stop the recursion and swapping
            return;
        }

        char temp = s[i]; //basic swapping of values
        s[i] = s[n-i-1];
        s[n-i-1] = temp;
        swap(s,i+1); //making a recursive call with the updated i value
    }
}

