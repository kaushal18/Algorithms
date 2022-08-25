// https://leetcode.com/problems/longest-consecutive-sequence/

// Brute force solution - for every number we check if a conssecutive sequence starts from it.
// time - O(n^3)
class Solution {
  public int longestConsecutive(int[] nums) {
    int longestStreak = 0;
    
    for(int num : nums) {
      int currNum = num;
      int currStreak = 1;
      
      while(arrayContains(currNum+1, nums)) {
        currStreak++;
        currNum++;
      }
      
      longestStreak = Math.max(longestStreak, currStreak);
    }
    
    return longestStreak;
  }
  
  public boolean arrayContains(int num, int[] arr) {
    for(int arrayNum : arr) {
      if(arrayNum == num) return true;
    }
    return false;
  }
}

// Optimization - can sort the array and check if consecutive nums follow the sequence, time - O(nlogn)

// More Optimized
// time - O(n)
class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int longestStreak = 0;
    
    for(int num : nums) {
      set.add(num);
    }
    
    for(int num : nums) {
      // if num-1 is already in the set then while loop already has counted the sequence, so ignore this num
      // eg - 1,2,3,4 --> at num=2 we already counted the sequence which starts at "1" and includes "2", therefore skip this num
      if(!set.contains(num - 1)) {
        int currNum = num;
        int currStreak = 1;

        // instead of interating through array to check is num+1 is present or not, use hashset
        while(set.contains(currNum+1)) {
          currStreak++;
          currNum++;
        }

        longestStreak = Math.max(longestStreak, currStreak);
      }
    }
    
    return longestStreak;
  }
}