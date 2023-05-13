
# Time - O(m * n)
class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        inverseMap = dict()

        m = len(mat)
        n = len(mat[0])
        
        rowCount = [0]*m
        colCount = [0]*n

        for i in range(m):
            for j in range(n):
                inverseMap[mat[i][j]] =(i,j)

        # arr len is m * n
        for i in range(len(arr)):
            rowId, colId = inverseMap[arr[i]]
            rowId = int(rowId)
            colId = int(colId)

            rowCount[rowId] += 1
            # print("i", i)
            # print("rc", rowCount)
            if rowCount[rowId] == n:
                return i

            colCount[colId] += 1
            # print("ct", colCount)
            if colCount[colId] == m:
                return i

        return -1
            