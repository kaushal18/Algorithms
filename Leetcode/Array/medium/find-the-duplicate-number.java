// https://leetcode.com/problems/find-the-duplicate-number/
// IMPORTANT

// Negative marking solution - but this solution modifies the original array
// time - O(n)
// space - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
      for(int i=0; i<nums.length; i++) {
        if(nums[Math.abs(nums[i])-1] < 0) {
          return Math.abs(nums[i]);
        }
        
        nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
      }  
      return -1;
    }
}

// Binary search - this is a different kind of binary search which searches on array values and not on index
// check leetcode solution page of more info

// time - O(nlogn)
// space - O(1) - does not modifies original array
class Solution {
    public int findDuplicate(int[] nums) {
      // binary search on array values, array length is n+1 and it contains values in range [1,n]
      int leftNum = 1;
      int rightNum = nums.length-1;
      int duplicate = -1; 
        
      while(leftNum <= rightNum) {
        int midNum = (leftNum + rightNum)/2;
        int count = 0;
        
        // find numbers less than or equal to midNum
        for(int num : nums) {
          if(num <= midNum) {
            count++;
          }
        }
        
        if(count > midNum) {
          duplicate = midNum;
          rightNum = midNum - 1;
        }
        else {
          leftNum = midNum + 1;
        }
      }
      
      return duplicate;
    }
}