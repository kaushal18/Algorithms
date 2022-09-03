
# save running sum at each node
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
      if root == None:
        return False
      
      stk = [(root, 0)]
      
      while len(stk) > 0:
        # print(stk)
        node, currSum = stk.pop()
        
        if node.left == None and node.right == None:
          if currSum + node.val == targetSum:
            return True
        
        if node.right != None:
          stk.append((node.right, currSum + node.val))
        
        if node.left != None:
          stk.append((node.left, currSum + node.val))
        
      return False
        