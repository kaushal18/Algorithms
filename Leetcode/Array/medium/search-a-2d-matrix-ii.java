// https://leetcode.com/problems/search-a-2d-matrix-ii/

// binary search - perform binary search for each row
// time - mlog(n)
// space - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if(target < matrix[0][0]) return false;
      
      for(int i=0; i<matrix.length; i++) {
        boolean found = binarySearch(matrix[i], target);
        if(found) return true;
      }
      
      return false;
    }
  
    public boolean binarySearch(int[] arr, int target) {
      int left = 0;
      int right = arr.length-1;
      
      while(left <= right) {
        int mid = left + (right - left)/2;
        
        if(arr[mid] < target) {
          left = mid + 1;
        }
        else if(arr[mid] > target) {
          right = mid - 1;
        }
        else return true;
      }
      return false;
    }
}

// optimized - start from top right - if target < num -> move left , if target > num -> move right
// we can start from top right / bottom left as their both sides have one decreasing and incresing sequence , therefore we can navigate accordingly
// time - O(m + n)
// space - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      
      int i = 0;
      int j = cols-1;
      while(j >= 0 && i < rows) {
        if(target < matrix[i][j]) {
          j--;
        }
        else if(target > matrix[i][j]) {
          i++;
        }
        else return true;
      }
      
      return false;
    }
}