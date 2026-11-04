// 1004. Count all subsequences with sum K
// Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.

// Example 1:
// Input : nums = [4, 9, 2, 5, 1] , k = 10

// Output : 2

// Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].

// Example 2:
// Input : nums = [4, 2, 10, 5, 1, 3] , k = 5

// Output : 3

// Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5].

// Link : https://takeuforward.org/practice/dsa/count-all-subsequences-with-sum-k

class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int sum = 0;
        int index = 0;
        return subseq(nums, index, sum, k);
    }
    public int subseq(int[] nums, int index, int sum, int k){

        if(index == nums.length){
            if(sum==k){
                return 1;
            }
            return 0;
        }

        int left = subseq(nums, index + 1, sum + nums[index], k);
        int right = subseq(nums, index + 1, sum, k);
        return left+right;
    }
}