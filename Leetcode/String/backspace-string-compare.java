
// without space implementation
// time - O(N)
class Solution {
    public boolean backspaceCompare(String s, String t) {
      int i = s.length()-1;
      int j = t.length()-1;
      
      while(i >= 0 && j >= 0) {
        i = skipBackspace(i, s);
        j = skipBackspace(j, t);

        if(i == -1 && j == -1) return true;
        if(i >= 0 && j >= 0 && (s.charAt(i) != t.charAt(j))) {
          return false;
        }
        i--;
        j--;
      }
      
      i = skipBackspace(i, s);
      j = skipBackspace(j, t);
  
      if(i == -1 && j == -1) return true;
      return false;
    }
  
    public int skipBackspace(int i, String s) {
      while(i >= 0 && s.charAt(i) == '#') {
          int count = 0;
          while(i >= 0 && s.charAt(i) == '#') {
            count++;
            i--;
          }
          while(i >= 0 && count > 0) {
            if(s.charAt(i) == '#') count++;
            else count--;
            i--;
          }
        }
      return i;
    }
}