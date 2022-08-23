// https://leetcode.com/problems/maximum-erasure-value/

// Time - O(N)
// Space - O(num of unique numbers) 
// same logic as - Longest Substring Without Repeating Characters
class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int maxSum = 0;
    int runningSum = 0;
    
    while(right < nums.length) {
      if(map.containsKey(nums[right])) {
        while(left < map.get(nums[right])) {
          runningSum -= nums[left];
          map.remove(nums[left]);
          left++;
        }
        runningSum -= nums[left];
        left++;
      }
      
      map.put(nums[right], right);
      runningSum += nums[right];
      maxSum = Math.max(maxSum, runningSum);
      right++;
    }
    
    return maxSum;
  }
}

// using hashset
class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int left = 0;
    int right = 0;
    int maxSum = 0;
    int runningSum = 0;
    
    while(right < nums.length) {
      // substract till we pass the duplicate value
      while(set.contains(nums[right])) {
        runningSum -= nums[left];
        set.remove(nums[left]);
        left++;
      }
      
      runningSum += nums[right];
      set.add(nums[right]);
      maxSum = Math.max(maxSum, runningSum);
      right++;
    }
    
    return maxSum;
  }
}
