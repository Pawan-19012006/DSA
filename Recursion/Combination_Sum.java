// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []
 

// Constraints:

// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// All elements of candidates are distinct.
// 1 <= target <= 40
 
// Link : https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int sum = 0; // need a sum variable to store the sum of the values at each recursive call
        int n = candidates.length;
        int index = 0;
        subsum(candidates, list, l, sum, n, target, index);
        return list;
    }
    public void subsum(int[] candidates, List<List<Integer>> list, List<Integer> l, int sum, int n, int target, int index){

        if(sum==target){ // if we reach the target we can add the number list to the main list and return
            list.add(new ArrayList(l));
            return;
        }

        if(sum>target || index>=n){ // if not, ie the final sum does not correspond to our target sum, then return
            return;
        }

        l.add(candidates[index]); // add the initial element
        sum = sum + candidates[index]; // find the sum of the element, by adding the current sum value with the actual element of the array
        subsum(candidates, list, l, sum, n, target, index); // calling the recursive function, we dont use index+1 becoz, it is given that the same value could be choosen unlimited times, so we stay on the same value, until it satisfies/exceeds our base condition
        l.remove(l.size()-1);// if the base condition satisfied/exceeded, then we have to remove the last element from the list
        sum = sum - candidates[index]; // we dont only remove the last element but also its value from the sum
        subsum(candidates, list, l, sum, n, target, index+1); //perform the operation again, but here we dont use index+1 since we have tested with that branch completely and now we need to move to a newer branch
    }
}