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