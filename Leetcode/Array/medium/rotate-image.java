// https://leetcode.com/problems/rotate-image/


// Reverse around diagonal - transpose
// then Reverse left to right - reflection
class Solution {
    public void rotate(int[][] matrix) {
      for(int i=0; i<matrix.length; i++) {
        for(int j=i; j<matrix[0].length; j++) {
          // swap (i,j) (j,i)
          if(i != j) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
          }
        }
      }
      
      // print(matrix);
      
      for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix[0].length/2; j++) {
          // swap (i, j) (i, cols-1-j)
          int temp = matrix[i][j];
          matrix[i][j] = matrix[i][matrix[0].length-1-j];
          matrix[i][matrix[0].length-1-j] = temp;
        }
      }
    }
  
    public void print(int[][] matrix) {
      for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix[0].length; j++) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
      }
    }
}