# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time - O(N)
# Space - O(N)
class Solution:
    balanced = True

    def getHeight(self, root):
        if root == None:
            return 0
        
        leftSubtreeHeight = 1 + self.getHeight(root.left)
        rightSubtreeHeight = 1 + self.getHeight(root.right)

        if abs(leftSubtreeHeight - rightSubtreeHeight) > 1:
            self.balanced = False

        return max(leftSubtreeHeight, rightSubtreeHeight)
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.getHeight(root)
        return self.balanced

# Without the global variable
class Solution:
    def getHeight(self, root):
        if root == None:
            return 0
        
        # propogate -1 up to the parent if we already know that the tree is not balanced somewhere down
        leftSubtreeHeight = self.getHeight(root.left)
        if leftSubtreeHeight == -1:
            return -1
        
        rightSubtreeHeight = self.getHeight(root.right)
        if rightSubtreeHeight == -1:
            return -1

        if abs(leftSubtreeHeight - rightSubtreeHeight) > 1:
            return -1

        return 1 + max(leftSubtreeHeight, rightSubtreeHeight)
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.getHeight(root) != -1
