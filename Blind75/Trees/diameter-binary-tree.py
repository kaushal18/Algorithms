# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    maxLenPath = -1
    
    def helper(self, root):
        if root == None:
            return 0

        leftSubtreeHeight = self.helper(root.left)
        rightSubtreeHeight = self.helper(root.right)

        self.maxLenPath = max(self.maxLenPath, leftSubtreeHeight + rightSubtreeHeight)

        return 1 + max(leftSubtreeHeight, rightSubtreeHeight)

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.helper(root)
        return self.maxLenPath