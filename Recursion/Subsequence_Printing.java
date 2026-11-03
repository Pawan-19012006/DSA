// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

// Link : https://leetcode.com/problems/subsets/description/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(); //main list to return
        List<Integer> l = new ArrayList<>(); //list in which the array elements be added
        int n = nums.length; 
        int index = 0; // to keep track of the current index and use to print the value
        subset(nums, l, list, n, index); 
        return list;

    }
    public void subset(int[] nums, List<Integer> l, List<List<Integer>> list, int n, int index){
        if(index>=n){ //until the index value equals/exceeds the length of array, we can continue
            list.add(new ArrayList<>(l)); // if condition true, add the current element list to main list
            return;
        }

        l.add(nums[index]); //if condition false, then add the current i value to the list
        subset(nums, l, list, n, index+1); // call the function again, goes on till all the elements are added to the list
        l.remove(l.size()-1); // now, once the recursion returns, need to remove the last element added in the list, then continue the not take approach
        subset(nums, l, list, n, index+1);// again call the recursion for the not take approach
    }
}