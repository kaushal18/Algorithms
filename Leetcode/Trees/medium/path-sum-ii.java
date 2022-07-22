// https://leetcode.com/problems/path-sum-ii/

// Time - O(N)
// Space - O(H), worst - O(N)
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    helper(root, targetSum, 0, result, new ArrayList<>());
    
    return result;
  }
  
  public void helper(TreeNode root, int targetSum, int runningSum, List<List<Integer>> result, List<Integer> runningList) {
    if(root == null) return;
    
    runningSum += root.val;
    runningList.add(root.val);
    
    if(root.left == null && root.right == null) {
      // System.out.println(runningList.toString());
      if(runningSum == targetSum) {
        result.add(new ArrayList<>(runningList));
      }
      // removing the leaf node
      runningList.remove(runningList.size() - 1);
      return;
    }
    
    helper(root.left, targetSum, runningSum, result, runningList);
    helper(root.right, targetSum, runningSum, result, runningList);
    // removing the rest of node as we move up
    runningList.remove(runningList.size() - 1);
  }
}