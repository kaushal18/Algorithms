// https://leetcode.com/problems/balanced-binary-tree/

// time - O(n)
// space - O(H) worst - O(n)
class Solution {
  boolean balanced = true;
  public boolean isBalanced(TreeNode root) {
    helper(root);
    return balanced;
  }
  
  public int helper(TreeNode root) {
    if(root == null) return 0;
    
    if(root.left == null && root.right == null) {
      return 1;
    }
    
    int leftHeight = helper(root.left);
    int rightHeight = helper(root.right);
      
    if(Math.abs(leftHeight - rightHeight) > 1) {
      balanced = false;
    }
      
    return 1 + Math.max(leftHeight, rightHeight);
  }
}