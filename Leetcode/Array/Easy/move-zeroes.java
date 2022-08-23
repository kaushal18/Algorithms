// https://leetcode.com/problems/move-zeroes/

// time  - O(n)
// space - O(1)
// overwrite
class Solution {
  public void moveZeroes(int[] nums) {
      int left = 0;
      int right = 0;
      
      while(right < nums.length) {
          if(nums[right] != 0) {
              nums[left] = nums[right];
              left++;
          }
          right++;
      }
      
      while(left < nums.length) {
          nums[left] = 0;
          left++;
      }
  }
}

// swap
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            if(nums[right] != 0) {
                swap(left, right, nums);
                left++;
            }
            right++;
        }
    }
    
    public void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}