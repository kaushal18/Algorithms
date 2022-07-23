// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// Time - O(N)
// Space - O(N) 
class Solution {
  int ans = -1;
  int count = 0;
  public int kthSmallest(TreeNode root, int k) {
    dfs(root, k);
    return ans;
  }

  // indorder traversal will give sorted order in BST
  public void dfs(TreeNode root, int k) {
    if(root == null) return;
    
    dfs(root.left, k);
    
    count++;
    if(count == k) {
      ans = root.val;
    }
    
    dfs(root.right, k);
  }
}