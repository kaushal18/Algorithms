// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// using maxHeap
// time - O(n^2 * log(k))
// space - O(k)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      
      for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix[0].length; j++) {
          maxHeap.add(matrix[i][j]);
          
          if(maxHeap.size() > k) {
            maxHeap.poll();
          }
        }
      }
      
      return maxHeap.peek();
    }
}

// Binary search - explaination - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101/C%2B%2BJavaPython-MaxHeap-MinHeap-Binary-Search-Picture-Explain-Clean-and-Concise
// The key point for any binary search is to figure out the "Search Space". 
// There are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). Most usually, when the array is sorted in one direction, we can use index as "search space", when the array is unsorted and we are going to find a specific number, we can use "range".

// search space --> index; example - find element in sorted array - left and right pointers are indices 0 and len-1
// search space --> range; example - https://leetcode.com/problems/find-the-duplicate-number/ check out the leetcode official solution
// here the search space is minimum and maximum array values in the matrix

// time - O((m + n)*log(maxValue - minValue))
// space - O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int kthSmallest = -1;
      
      int leftNum = matrix[0][0]; 
      int rightNum = matrix[rows-1][cols-1];
      
      // binary search over matrix values - O(log(max - min))
      while(leftNum <= rightNum) {
        int midNum = leftNum + (rightNum - leftNum)/2;
        
        int count = getCountLessThanOrEqual(matrix, midNum);
        
        if(count >= k) {
          kthSmallest = midNum;
          rightNum = midNum - 1;
        }
        else {
          leftNum = midNum + 1;
        }
      }
      
      return kthSmallest;
    }

    // O(m + n)
    public int getCountLessThanOrEqual(int[][] matrix, int midNum) {
      int col = matrix[0].length-1;
      int count = 0;
      
      for(int row = 0; row < matrix.length; row++) {
        while(col >= 0 && matrix[row][col] > midNum) {
          col--;
        }
        count += (col + 1);
      }
      return count;
    }
}