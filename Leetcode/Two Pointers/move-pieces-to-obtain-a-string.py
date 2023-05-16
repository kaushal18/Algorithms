# Time - O(N)
# Space - O(1)
class Solution:
    def canChange(self, start: str, target: str) -> bool:
        ptr1 = 0
        ptr2 = 0

        n = len(start)

        while ptr1 < n and ptr2 < n:
            while ptr1 < n and start[ptr1] == "_":
                ptr1 += 1
            
            while ptr2 < n and target[ptr2] == "_":
                ptr2 += 1
            
            if ptr1 >= n or ptr2 >= n:
                break
            if start[ptr1] != target[ptr2]:
                return False
            
            elif start[ptr1] == "L" and target[ptr2] == "L":
                if ptr2 > ptr1:
                    return False
                ptr1 += 1
                ptr2 += 1

            elif start[ptr1] == "R" and target[ptr2] == "R":
                if ptr2 < ptr1:
                    return False
                ptr1 += 1
                ptr2 += 1

        while ptr1 < n and start[ptr1] == "_":
            ptr1 += 1

        while ptr2 < n and target[ptr2] == "_":
            ptr2 += 1

        return ptr1 == n and ptr2 == n