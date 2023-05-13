
    #                2
    #          /               \
    #         1(+1)             5(+0)
    #      /      \            /     \
    #     5(+1-1) 2(+4-1)    2(+3)    5
    #    /  \     / \
    #  2(+1) 3   3   1(+2)

# 1. Find max path sum
# 2. start from bottom up, for each leaf add the complement (max - curr sum) in result and return it to the parent
# 3. for non leaf nodes decrement min(left, right) from result and return it

class Solution:
    result = 0

    def getLeftChild(self, i, cost):
        if (2*i + 1) > len(cost)-1:
            return -1
        return 2*i + 1
    
    def getRightChild(self, i, cost):
        if (2*i + 2) > len(cost)-1:
            return -1
        return 2*i + 2

    def getMaxPath(self, cost):
        stack = deque()
        stack.append((0, cost[0]))
        maxPathSum = -1

        while len(stack) > 0:
            node, pathSum = stack.pop()
            leftChild = self.getLeftChild(node, cost)
            rightChild = self.getRightChild(node, cost)

            if leftChild == -1 and rightChild == -1:
                maxPathSum = max(maxPathSum, pathSum)
            
            if leftChild != -1:
                stack.append((leftChild, pathSum + cost[leftChild]))
            if rightChild != -1:
                stack.append((rightChild, pathSum + cost[rightChild]))
            
        return maxPathSum
    
    def getMinIncrements(self, n, root, cost, currPathSum, maxPathSum):
        leftChild = self.getLeftChild(root, cost)
        rightChild = self.getRightChild(root, cost)

        # leaf node
        if leftChild == -1 and rightChild == -1:
            currPathSum += cost[root]
            self.result += (maxPathSum - currPathSum)
            return (maxPathSum - currPathSum)
        
        currPathSum += cost[root]
        # postorder traversal
        leftIncr = self.getMinIncrements(n, leftChild, cost, currPathSum, maxPathSum)
        
        rightIncr =  self.getMinIncrements(n, rightChild, cost, currPathSum, maxPathSum)

        self.result -= min(leftIncr, rightIncr)
        return min(leftIncr, rightIncr)


    def minIncrements(self, n: int, cost: List[int]) -> int:
        maxPathSum = self.getMaxPath(cost)
        self.getMinIncrements(n, 0, cost, 0, maxPathSum)

        return self.result
        