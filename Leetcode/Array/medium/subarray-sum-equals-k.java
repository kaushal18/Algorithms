// https://leetcode.com/problems/subarray-sum-equals-k/

// This solution would not work for zero and negative integers
class Solution {
    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int windowSum = 0;
        
        while(right < nums.length) {
            windowSum += nums[right];
            right++;
            
            while(left < nums.length && windowSum > k) {
                windowSum -= nums[left];
                left++;
            }
            
            if(left < nums.length && windowSum == k) {
                count++;
            }
        }
        return count;
    }
}

// using prefix sum method
// time - O(n) , space - O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        // prefix : count
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int runningSum = 0;
        
        for(int i=0; i<nums.length; i++) {
            runningSum += nums[i];
            if(map.containsKey(runningSum - k)) {
                count += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        
        return count;
    }
}