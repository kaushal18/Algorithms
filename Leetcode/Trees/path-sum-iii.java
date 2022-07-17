// https://leetcode.com/problems/path-sum-iii/

// Time - O(N)
// Space - O(N)
class Solution {
  int noOfPaths = 0;
  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> prefixMap = new HashMap<>();
    prefixMap.put(0L, 1);
    helper(root, targetSum, 0L, prefixMap);
    return noOfPaths;
  }

  public void helper(TreeNode root, int targetSum, long currSum, Map<Long, Integer> prefixMap) {
    if(root == null) return;
    
    currSum += (long)root.val;

    // if current sum minus target sum is present in map then path is found
    if(prefixMap.containsKey(currSum - (long)targetSum)) {
      noOfPaths += prefixMap.get(currSum - (long)targetSum);
    }
    
    // add sum till this point in map
    if(prefixMap.containsKey(currSum)) {
      prefixMap.put(currSum, prefixMap.get(currSum) + 1);
    } else {
      prefixMap.put(currSum, 1);
    }
    
    helper(root.left, targetSum, currSum, prefixMap);
    helper(root.right, targetSum, currSum, prefixMap);
    prefixMap.put(currSum, prefixMap.get(currSum) - 1);
  }
}