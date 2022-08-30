// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
      Map<String, Set<Character>> map = new HashMap<>();
      
      for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++) {
          String key = i + "" + j;
          map.put(key, new HashSet<>());
        }
      }
      
      for(int i=0; i<9; i++) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        
        for(int j=0; j<9; j++) {
          if(board[i][j] != '.') {
            // checking rows
            if(rowSet.contains(board[i][j])) {
              return false;
            }
            rowSet.add(board[i][j]);
            
            // check for each 3X3 sub-boxes
            String key = i/3 + "" + j/3;
            if(map.get(key).contains(board[i][j])) {
              return false;
            }
            map.get(key).add(board[i][j]);
            // System.out.println(map);
          }
          
          if(board[j][i] != '.') {
            // checking columns
            if(colSet.contains(board[j][i])) {
              return false;
            }
            colSet.add(board[j][i]);
          }
        }
      }
      
      return true;
    }
}


// Using single HashSet
// use some unique combination to help indetify same row, col and block numbers in single hashset
class Solution {
    public boolean isValidSudoku(char[][] board) {
      Set<String> set = new HashSet<>();
      
      for(int i=0; i<9; i++) {
        for(int j=0; j<9; j++) {
          if(board[i][j] != '.') {
            String rowKey = board[i][j] + "ROW#" + i;
            String colKey = board[i][j] + "COL#" + j;
            String subBlockKey = board[i][j] + "SUBBOCK#" + (i/3) + "" + (j/3);
            
            if(set.contains(rowKey) || set.contains(colKey) || set.contains(subBlockKey)) {
              return false;
            }
            set.add(rowKey);
            set.add(colKey);
            set.add(subBlockKey);
          }
        }
      }
      
      return true;
    }
}