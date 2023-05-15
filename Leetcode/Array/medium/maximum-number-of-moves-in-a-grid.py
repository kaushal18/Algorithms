class Solution:
    tempMaxPath = 0

    def dfs(self, i, j, grid, currMax, runningMaxPath, memo):
        # base case
        if i < 0 or i > len(grid)-1 or j < 0 or j > len(grid[0])-1 or grid[i][j] <= currMax:
            return
        # if we already know the max path lenth from this (i,j) coordinate update the answer instead of calculating again
        if memo[i][j] != -1:
            self.tempMaxPath = max(self.tempMaxPath, memo[i][j])
            return

        # print("ij", i, j, "running", runningMaxPath)
        self.dfs(i-1, j+1, grid, max(currMax, grid[i][j]), runningMaxPath+1, memo)
        self.dfs(i, j+1, grid, max(currMax, grid[i][j]), runningMaxPath+1, memo)
        self.dfs(i+1, j+1, grid, max(currMax, grid[i][j]), runningMaxPath+1, memo)

        # update the max path
        self.tempMaxPath = max(self.tempMaxPath, runningMaxPath)
        # save the answer for future use
        memo[i][j] = self.tempMaxPath

    def maxMoves(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        memo = [[-1]*n for _ in range(m)]
        maxPath = 0

        for i in range(m):
            self.tempMaxPath = 0
            self.dfs(i, 0, grid, -1, 0, memo)
            maxPath = max(maxPath, self.tempMaxPath)

        return maxPath

        
