// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?

 

// Example 1:

// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
// Example 2:

// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
 

// Constraints:

// 1 <= k <= nums.length <= 105
// -104 <= nums[i] <= 104

class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int num : nums){ 
            if(pq.size()<k){ // we creat a small pq of maximum size k, so that we can easily pop out the smaller elements from the top and then keep adding the larger elements into the pq 
                pq.offer(num);
            }

            else if(pq.peek()<num){ // if the topmost value is smaller than the number we gonna add, we must pop that out and then add our number
                pq.poll();
                pq.offer(num);
            }
       }

       return pq.poll();
    }
}

//more detailed notes in the DSA Note (Gold)