// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 
// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

// Link : https://leetcode.com/problems/subsets-ii/description/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); //always sort the array before finding subsets
        int index = 0; 
        List<List<Integer>> main = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        subset(nums, index, main, curr);
        return main;

    }

    public void subset(int[] nums, int index, List<List<Integer>> main, List<Integer> curr){
        main.add(new ArrayList<Integer>(curr)); //every list must be added to the main list, since if a list if formed from the recursive call, it means surely it has satisfied the condition required, else it will not even would have been executed

        for(int i = index; i<nums.length; i++){ //running from index value to n-1
            if(i!=index && nums[i]==nums[i-1]){ // we see whether the current index value does not equal the i value and if the duplicate also is found then, it means it has to be skipped
                continue; //this iteration is skipped
            }

            curr.add(nums[i]); //if condition not executed, then add the value to the list
            subset(nums, i+1, main, curr); //recursive call
            curr.remove(curr.size()-1); //removal of the last value, to perform next recursive call
            //we dont add another recursive call for not pick, since every value has to be checked and it is under a for loop so it will obviously start again with the next i value
        }
    }
}
