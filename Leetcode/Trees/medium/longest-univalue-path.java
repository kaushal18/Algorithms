// same logic as maximum path sum

class Solution {
    int ans = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
      if(root == null) return 0;
      helper(root);
      return ans;
    }
  
    public int helper(TreeNode root) {
      if(root == null) return 0;
      
      int leftMax = helper(root.left);
      int rightMax = helper(root.right);
      
      
      if(root.left != null) {
        if(root.left.val == root.val) {
          leftMax += 1;  
        }
        else {
          leftMax = 0;
        }
      }
      if(root.right != null) {
        if(root.right.val == root.val) {
          rightMax += 1;  
        }
        else {
          rightMax = 0;
        }
      }
      // System.out.println(root.val + " " + leftMax + " " + rightMax);
      ans = Math.max(ans, leftMax + rightMax);
      
      return Math.max(leftMax, rightMax);
    }
}