// https://leetcode.com/problems/simplify-path/

// Time - O(N)
// Space - O(N) 
class Solution {
  public String simplifyPath(String path) {
    String splitPath[] = path.split("/");
    StringBuilder sb = new StringBuilder();
    Stack<StringBuilder> stk = new Stack<>();
    
    for(int i=1; i<splitPath.length; i++) {   
      if(splitPath[i].length() == 0 || splitPath[i].equals(".")) continue;
      if(splitPath[i].equals("..")) {
        if(!stk.isEmpty())  stk.pop();
      }
      else {
        stk.push((new StringBuilder(splitPath[i])).reverse());
      }
    }
    
    while(!stk.isEmpty()) {
      sb.append(stk.pop());
      sb.append("/");
    }
    sb.reverse();
    if(sb.length() == 0) sb.append("/");
    
    return sb.toString();
  }
}