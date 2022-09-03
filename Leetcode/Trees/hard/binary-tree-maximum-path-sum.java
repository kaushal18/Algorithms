

class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      if(root == null) return 0;
      if(root.left == null && root.right == null) return root.val;
      helper(root);
      return ans;
    }
  
    public int helper(TreeNode root) {
      if(root == null) return 0;
      
      int leftMax = helper(root.left);
      int rightMax = helper(root.right);
      // System.out.println(root.val + " " + leftMax + " " + rightMax);
      
      if(leftMax < 0) leftMax = 0;
      if(rightMax < 0) rightMax = 0;
      ans = Math.max(leftMax + rightMax + root.val, ans);
      return  Math.max(leftMax, rightMax) + root.val;
    }
}