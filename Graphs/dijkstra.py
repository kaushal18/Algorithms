class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        # Dijsktra algorithm
        # node0 -> [(node1, weight1), (node2, weight2)]
        adjList = [[] for i in range(n)]
        visited = [False for i in range(n)]
        distance = [float("inf") for i in range(n)]

        for i in range(len(edges)):
            edge = edges[i]
            adjList[edge[0]].append((edge[1], succProb[i]))
            adjList[edge[1]].append((edge[0], succProb[i]))

        # minHeap will contain tuple (min distance to node, node number)
        minHeap = [(0, start)]
        visited[start] = True
        distance[start] = 0
        
        while len(minHeap) > 0:
            # currDist -> min distance to reach this node
            currDist, node = heapq.heappop(minHeap)

            # if we already found a lesser weight path to this node we continue
            if distance[node] < currDist:
                continue

            visited[node] = True

            # update the distance to every child and insert them in heap
            for child, weight in adjList[node]:
                # if there is room for improvement in distance to child
                if not visited[child] and distance[node] + weight < distance[child]:
                    distance[child] = distance[node] + weight
                    heapq.heappush(minHeap, (distance[child], child))

            if node == end:
                return distance[end]

        return -1



