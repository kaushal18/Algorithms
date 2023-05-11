# Definition for a binary tree node.

# keep a running maximum for each node and compare the max with the node value
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        stack = [(root, -float("inf"))]
        countGoodNodes = 0

        while len(stack) > 0:
            node, currMax = stack.pop()
            if node.val >= currMax:
                countGoodNodes += 1

            if node.right != None:
                stack.append((node.right, max(node.val, currMax)))
            if node.left != None:
                stack.append((node.left, max(node.val, currMax)))

        return countGoodNodes


