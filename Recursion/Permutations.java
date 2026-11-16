// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]

//Link : https://leetcode.com/problems/permutations/description/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        perm(nums, main, l);
        return main;
    }

    public void perm(int[] nums, List<List<Integer>> main, List<Integer> l){
        if(l.size()==nums.length){
            main.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(!l.contains(nums[i])){ //if the list does not contain the value that we gonna add, then it is a permutation suitable value, so we can add it
                l.add(nums[i]);
                perm(nums, main, l);
                l.remove(l.size()-1);
            }
        }
    }
}