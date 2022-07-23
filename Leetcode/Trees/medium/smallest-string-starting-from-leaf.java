// https://leetcode.com/problems/smallest-string-starting-from-leaf/

// bottom up approach - Does not work
// https://leetcode.com/problems/smallest-string-starting-from-leaf/discuss/244205/Divide-and-conquer-technique-doesn't-work-for-this-problem
class Solution {
  public String smallestFromLeaf(TreeNode root) {
    if(root == null) return Character.toString('a' + 26);
        
    if(root.left == null && root.right == null) {
      return Character.toString('a' + root.val);
    }
    String leftSmallestStr = smallestFromLeaf(root.left);
    String rightSmallestStr = smallestFromLeaf(root.right);
    
    leftSmallestStr = leftSmallestStr.concat(Character.toString('a' + root.val));
    rightSmallestStr = rightSmallestStr.concat(Character.toString('a' + root.val));
        
    if(leftSmallestStr.compareTo(rightSmallestStr) < 0) {
      return leftSmallestStr;
    }
    return rightSmallestStr;
  }
}

// top down approach
// Time - O(NlogN)
// space - O(N)
class Solution {
  String ans = Character.toString((char)('a' + 26));

  public String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return ans;
  }
  
  public void dfs(TreeNode root, StringBuilder sb) {
    if(root == null) return;
      
    sb.append((char)('a' + root.val));
      
    if(root.left == null && root.right == null) {
      // O(log(height))
      sb.reverse();
      String str = sb.toString();
      sb.reverse();
      
      if(str.compareTo(ans) < 0) {
        ans = str;
      }
    }
    
    dfs(root.left, sb);
    dfs(root.right, sb);
    sb.deleteCharAt(sb.length() - 1);
  }
}