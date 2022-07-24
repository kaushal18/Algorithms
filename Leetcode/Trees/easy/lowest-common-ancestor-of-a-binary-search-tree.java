// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// Time - O(logN) in balanced tree, O(n) in skewed
// space - O(logN) in balanced tree, O(n) in skewed
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p.val > q.val) {
      return lowestCommonAncestor(root, q, p);
    }
    
    if(root == null) return null;
    
    if(root.val < p.val) {
      return lowestCommonAncestor(root.right, p, q);
    } 
    if(root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    return root;
  }
}