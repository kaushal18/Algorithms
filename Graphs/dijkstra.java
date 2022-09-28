import java.util.*;

class Main {
  public static void main(String[] args) {
    // adj list , a --> [(b,1) ..neighbouring node and weight.. , (c,2)]
    List<List<Node>> adjList = new ArrayList<>(); 
    int n = 9;
    for(int i=0; i<n; i++) {
      adjList.add(new ArrayList<>());
    }

    int source = 0;
        adjList.get(0).add(new Node(1, 4));
        adjList.get(0).add(new Node(7, 8));
        adjList.get(1).add(new Node(2, 8));
        adjList.get(1).add(new Node(7, 11));
        adjList.get(1).add(new Node(0, 7));
        adjList.get(2).add(new Node(1, 8));
        adjList.get(2).add(new Node(3, 7));
        adjList.get(2).add(new Node(8, 2));
        adjList.get(2).add(new Node(5, 4));
        adjList.get(3).add(new Node(2, 7));
        adjList.get(3).add(new Node(4, 9));
        adjList.get(3).add(new Node(5, 14));
        adjList.get(4).add(new Node(3, 9));
        adjList.get(4).add(new Node(5, 10));
        adjList.get(5).add(new Node(4, 10));
        adjList.get(5).add(new Node(6, 2));
        adjList.get(6).add(new Node(5, 2));
        adjList.get(6).add(new Node(7, 1));
        adjList.get(6).add(new Node(8, 6));
        adjList.get(7).add(new Node(0, 8));
        adjList.get(7).add(new Node(1, 11));
        adjList.get(7).add(new Node(6, 1));
        adjList.get(7).add(new Node(8, 7));
        adjList.get(8).add(new Node(2, 2));
        adjList.get(8).add(new Node(6, 6));
        adjList.get(8).add(new Node(7, 1));

      int[] distance = findShortestPath(adjList, source, n);
      System.out.println(Arrays.toString(distance));
  }

  // lazy implementation - see william fesiet video https://www.youtube.com/watch?v=pSqmAO-m7Lk&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=18
  public static int[] findShortestPath(List<List<Node>> adjList, int source, int n) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
    minHeap.add(new Node(source, 0));

    // distance from source to ith index node
    int[] distance = new int[n];
    for(int i=0; i<n; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[source] = 0;

    // visited array
    boolean[] visited = new boolean[n];
    visited[source] = true;

    // stores predecessor of a vertex (to a print path)
    int[] prev = new int[n];
    prev[source] = -1;

    while(!minHeap.isEmpty()) {
      // at each iteration we take edge with minimum weight --> greedy
      Node node = minHeap.poll();
      int u = node.vertex;
      // if this is an stale entry in heap then ignore this value
      if(distance[u] < node.weight) continue;
      visited[u] = true; 

      for(Node child : adjList.get(u)) {
        int v = child.vertex;
        int weight = child.weight;

        // distance to reach v through u (ie, dist of u + edge --> distance[u] + edge_weight) is less than the current minimum distance to reach v then update to the minimum one
        if(!visited[v] && distance[u]+weight < distance[v]) {
          distance[v] = distance[u]+weight;
          prev[v] = u;
          minHeap.add(new Node(v, distance[v]));
        }
      }

      // if we need to find shortest distance from src to destination then we can terminate early
      // if(u == endNode) {
      //   return distance[u]
      // }
    }

    return distance;
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