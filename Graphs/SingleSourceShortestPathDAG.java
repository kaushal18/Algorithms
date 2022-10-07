class SingleSourceShortestPathDAG {
  public static void main(String[] args) {
    int n = 8;
    List<List<Node>> adjList = new ArrayList<>();
    adjList.get(0).add(new Node(1, 3));
    adjList.get(0).add(new Node(2, 6));
    adjList.get(1).add(new Node(2, 4));
    adjList.get(1).add(new Node(3, 4));
    adjList.get(1).add(new Node(4, 11));
    adjList.get(2).add(new Node(3, 8));
    adjList.get(2).add(new Node(6, 11));
    adjList.get(3).add(new Node(4, -4));
    adjList.get(3).add(new Node(5, 5));
    adjList.get(3).add(new Node(6, 2));
    adjList.get(4).add(new Node(7, 9));
    adjList.get(7).add(new Node(7, 1));
    adjList.get(6).add(new Node(7, 2));

    int[] distance = SSSP(adjList, 0, n);
    System.out.println(distance);
  }

  public static int[] SSSP(List<List<Node>> adjList, int start, int n) {
    int[] topsort = topologicalSort(adjList, n);
    int[] distance = new int[n];
    for(int i=0; i<n; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[start] = 0;

    for(int i=0; i<n; i++) {
      int parent = topoSort[i];

      // loop through node's children
      for(Node child : adjList.get(parent)) {
        distance[child.vertex] = Math.min(distance[child.vertex], distance[parent] + child.weight);
      }
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