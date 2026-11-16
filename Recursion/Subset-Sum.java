// Given an array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.

// Examples:

// Input: arr[] = [2, 3]
// Output: [0, 2, 3, 5]
// Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
// Input: arr[] = [1, 2, 1]
// Output: [0, 1, 1, 2, 2, 3, 3, 4]
// Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the element 2), and their combinations.
// Input: arr[] = [5, 6, 7]
// Output: [0, 5, 6, 7, 11, 12, 13, 18]
// Explanation: The possible subset sums are 0 (no elements), 5, 6, 7, and their combinations.
// Constraints:

// 1 ≤ arr.size() ≤ 15
// 0 ≤ arr[i] ≤ 105

//Link : https://www.geeksforgeeks.org/problems/subset-sums2234/1

class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        int sum = 0;
        int index = 0;
        ArrayList<Integer> main = new ArrayList<>();
        subsum(arr, sum, index, main);
        return main;
    }
    
    public void subsum(int[] arr, int sum, int index, ArrayList<Integer> main){
        
        if(index==arr.length){ //if its the final index, ie after that no number is present in the array and has reached the max size of array, then we need to stop and add the val to the main list
            main.add(sum); 
            return;
        }
        
        subsum(arr, sum+arr[index], index+1, main); //pick
        subsum(arr, sum, index+1, main); //not pick
    }
}