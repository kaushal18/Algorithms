// https://leetcode.com/problems/search-a-2d-matrix/

// Brute force - convert 2d array to 1d and return kth element
// time - O(n * m) 
// space - O(n * m)


// consider matrix as a single 1d array of index [0, n*m-1] and do binary search over [0, n*m-1]
// convert 1d to 2d by storing key value pair in map
// 0th element used for binary search will map to (0,0) and so on 

// time - O(n * m)
// space - O(n * m) because of map
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
      int rows = matrix.length;
      int cols = matrix[0].length;
      
      int k = 0;
      for(int i=0; i<rows; i++) {
        for(int j=0; j<cols; j++) {
          map.put(k, new Pair<>(i, j));
          k++;
        }
      }
      
      int left = 0;
      int right = rows*cols - 1;
      while(left <= right) {
        int mid = (left + right)/2;
        // System.out.println(left + " " + right + " " + mid);
        int i = map.get(mid).getKey();
        int j = map.get(mid).getValue();
        
        if(matrix[i][j] < target) {
          left = mid + 1;
        }
        else if(matrix[i][j] > target) {
          right = mid - 1;
        }
        else {
          return true;
        }
      }
      return false;
    }
}


// optimizing space 
// use this conversions - 
// n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

// an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      
      int left = 0;
      int right = rows*cols - 1;
      while(left <= right) {
        int mid = (left + right)/2;
        
        // convert 1d to 2d
        if(matrix[mid / cols][mid % cols] < target) {
          left = mid + 1;
        }
        else if(matrix[mid / cols][mid % cols] > target) {
          right = mid - 1;
        }
        else {
          return true;
        }
      }
      return false;
    }
}