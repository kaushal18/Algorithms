
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null) return null;
      
      if(p.val > q.val) {
        return lowestCommonAncestor(root, q, p);
      }
      
      if(p.val <= root.val && q.val >= root.val) {
        return root;
      }
      
      if(root.val > q.val) {
        return lowestCommonAncestor(root.left, p, q);
      }
      
      return lowestCommonAncestor(root.right, p, q);
    }
}