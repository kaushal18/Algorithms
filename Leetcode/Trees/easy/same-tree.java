// https://leetcode.com/problems/same-tree/

// Time - O(n)
// Space - O(H) , worst - O(n)
class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    
    if(p.val != q.val) return false;
    
    boolean ifLeftTreeSame = isSameTree(p.left, q.left);
    boolean isRightTreeSame = isSameTree(p.right, q.right);
    
    return ifLeftTreeSame && isRightTreeSame;
  }
}