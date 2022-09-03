
# keep list of path for each node in stack
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
      if root == None:
        return []
      
      ans = []
      stk = [(root, 0, [])]
      
      while len(stk) > 0:
        root, currSum, path = stk.pop()
        # print(path)
        if root.left == None and root.right == None:
          if currSum + root.val == targetSum:
            path.append(root.val)
            ans.append(path)
            
        if root.right != None:
          stk.append((root.right, currSum + root.val, path + [root.val]))
        
        if root.left != None:
          stk.append((root.left, currSum + root.val, path + [root.val]))
      
      return ans