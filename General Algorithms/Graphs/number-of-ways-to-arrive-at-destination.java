// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

// modified Dijkstras
class Solution {
    int paths = 0;
    public int countPaths(int n, int[][] roads) {
      List<List<Node>> adj = new ArrayList<>();
      boolean[] visited = new boolean[n];
      for(int i=0; i<n; i++) {
        adj.add(new ArrayList<>());
      }
      
      for(int[] edge : roads) {
        adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        adj.get(edge[1]).add(new Node(edge[0], edge[2]));
      }
      
      int[] ways = dijkstra(adj, 0, n-1, n);
      
      // ans is no of ways to reach n-1th node
      return ways[n-1];
    }
  
  public static int[] dijkstra(List<List<Node>> adjList, int source, int dst, int n) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
    minHeap.add(new Node(source, 0));

    int[] distance = new int[n];
    // no of ways to reach ith node
    int[] ways = new int[n];
    
    for(int i=0; i<n; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[source] = 0;
    ways[source] = 1;
    
    boolean[] visited = new boolean[n];
    visited[source] = true;

    while(!minHeap.isEmpty()) {
      Node node = minHeap.poll();
      int u = node.vertex;

      if(distance[u] < node.weight) continue;
      visited[u] = true; 

      for(Node child : adjList.get(u)) {
        int v = child.vertex;
        int weight = child.weight;

        // if this is new minimum distance --> no of ways to reach (v) = ways to reach (u)
        if(!visited[v] && distance[u]+weight < distance[v]) {
          distance[v] = distance[u]+weight;
          ways[v] = ways[u];
          minHeap.add(new Node(v, distance[v]));
        }
        // if we found same min distance --> ways to reach (v) += ways to reach (u)
        else if(distance[u]+weight == distance[v]) {
          ways[v] = (ways[v] + ways[u]) % 1000000007;
        }
      }
    }

    return ways;
  }
}

class Node {
  int vertex;
  int weight;
  public Node(int vertex, int weight) {
    this.vertex = vertex;
    this.weight = weight;
  }
}