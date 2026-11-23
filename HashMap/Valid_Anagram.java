// Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

// Two strings are anagrams if they contain the same characters, with each character appearing the same number of times, regardless of order.


// Example 1:

// Input: s = "racecar", t = "carrace"

// Output: true

// Example 2:

// Input: s = "jar", t = "jam"

// Output: false

// Example 3:

// Input: s = "x", t = "x"

// Output: true

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sm = new HashMap<>();
        HashMap<Character, Integer> tm = new HashMap<>();
        for(char chs: s.toCharArray()){
            sm.put(chs, sm.getOrDefault(chs,0)+1); 
        }

        for(char cht : t.toCharArray()){
            tm.put(cht, tm.getOrDefault(cht,0)+1);
        }

        // calculating the frequency of each character in the strings, storing in the hashmaps respectively, then comparing whether both the hashmaps are equal or not, if equal then they have same characters present in it but in different form, therefore it is an anagram

        if(sm.equals(tm)){ //function to check whether two hashmaps are equal
            return true;
        }else{
            return false;
        }
    }
}