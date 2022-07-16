// https://leetcode.com/problems/path-sum/

// Time - O(N)
// Space - O(Height) which is O(N) in worst case
class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return helper(root, targetSum, 0);
  }
    
  public boolean helper(TreeNode root, int targetSum, int currentSum) {
		if(root == null) return false;
		
		currentSum += root.val;
		
		if(root.left == null && root.right == null && currentSum == targetSum) {
				return true;
		}
		
		boolean isLeftTreeHasSum = helper(root.left, targetSum, currentSum);
		boolean isRightTreeHasSum = helper(root.right, targetSum, currentSum);
		
		return isLeftTreeHasSum || isRightTreeHasSum;
	}
}

// Time - O(N)
// Space - O(Height) which is O(N) in worst 
class Solution {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) return false;
		
		if(root.left == null && root.right == null) {
				if(targetSum == root.val) return true;
				else return false;
		}
		
		boolean hasLeftPathSum = hasPathSum(root.left, targetSum - root.val);
		boolean hasRightPathSum = hasPathSum(root.right, targetSum - root.val);
		
		return hasLeftPathSum || hasRightPathSum;
	}
}