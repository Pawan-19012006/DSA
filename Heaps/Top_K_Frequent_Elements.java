// Given an integer array nums and an integer k, return the k most frequent elements within the array.

// The test cases are generated such that the answer is always unique.

// You may return the output in any order.

// Example 1:

// Input: nums = [1,2,2,3,3,3], k = 2

// Output: [2,3]
// Example 2:

// Input: nums = [7,7], k = 1

// Output: [7]
// Constraints:

// 1 <= nums.length <= 10^4.
// -1000 <= nums[i] <= 1000
// 1 <= k <= number of distinct elements in nums.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1); //calculating the frequency
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(map.get(a),map.get(b))); // we create the priority queue and then use the comparator inside it to compare the frequencies of the elements got from the map, then uses it to arrange the incoming elements based on the freqency

        for(int num : map.keySet()){ // we iterate through all the keys of the map
            if(pq.size()<k){ //checking whether the pq size is less than k, since we need only k elements inside the pq
                pq.offer(num); // if less than pq, then add the newer element into the pq
            }

            else if(map.get(num)>map.get(pq.peek())){ // only if we use map.get(peek), we will be able to access the frequency, if we just put .peek then we will get only the number on top, ex) pq.peek() will return 3, but we dont need 3 we need the frequency of 3, so we use map.get(3), that is nothing but map.get(pq.peek())
                pq.poll();
                pq.offer(num);
            }
        }

        int[] arr = new int[k];
        for(int i = 0; i<k; i++){
            arr[i] = pq.poll();
        }

        return arr;
    }
}

