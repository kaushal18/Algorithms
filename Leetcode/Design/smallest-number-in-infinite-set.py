
# With SortedSet
from sortedcontainers import SortedSet

class SmallestInfiniteSet:
    minHeap = None
    minCounter = None

    def __init__(self):
        self.sortedSet = SortedSet()
        self.minCounter = 1

    # O(log N) - SortedSet add and delete are log(N) operations
    def popSmallest(self) -> int:
        if len(self.sortedSet) > 0 and self.sortedSet[0] <= self.minCounter:
            if self.sortedSet[0] == self.minCounter:
                self.minCounter += 1
            
            _min = self.sortedSet[0]
            self.sortedSet.discard(_min)
            
        else:
            _min = self.minCounter
            self.minCounter += 1
        
        return _min
        
    # O(log N)
    def addBack(self, num: int) -> None:
        if num < self.minCounter:
            self.sortedSet.add(num)


# With Min Heap + Set
class SmallestInfiniteSet:
    minHeap = None
    minCounter = None
    seenSet = None

    def __init__(self):
        self.minHeap = []
        heapify(self.minHeap)
        self.seenSet = set()
        self.minCounter = 1

    # O(log N) - to remove the top element
    def popSmallest(self) -> int:
        if len(self.minHeap) > 0 and self.minHeap[0] <= self.minCounter:
            if self.minHeap[0] == self.minCounter:
                self.minCounter += 1
            _min = heappop(self.minHeap)
            self.seenSet.remove(_min)          
            
        else:
            _min = self.minCounter
            self.minCounter += 1
        
        return _min
        
    # O(log N) - to add new element in the heap
    def addBack(self, num: int) -> None:
        if num < self.minCounter:
            if num not in self.seenSet:
                heappush(self.minHeap, num)
            self.seenSet.add(num)

