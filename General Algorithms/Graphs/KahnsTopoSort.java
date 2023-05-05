import java.util.*;

class Main {
  public static void main(String[] args) {
    // adj list , a --> [(b,1) ..neighbouring node and weight.. , (c,2)]
    List<List<Integer>> adjList = new ArrayList<>(); 
    int n = 8;
    for(int i=0; i<n; i++) {
      adjList.add(new ArrayList<>());
    }

    List<List<Integer>> edges = new ArrayList<>();
    edges.add(Arrays.asList(0, 6));
    edges.add(Arrays.asList(1, 2));
    edges.add(Arrays.asList(1, 4));
    edges.add(Arrays.asList(1, 6));
    edges.add(Arrays.asList(3, 0));
    edges.add(Arrays.asList(3, 4));
    edges.add(Arrays.asList(5, 1));
    edges.add(Arrays.asList(7, 0));
    edges.add(Arrays.asList(7, 1));

    // construct indegree array from edge list 
    int[] indegree = new int[n];
    for(int i=0; i<n; i++) {
      indegree[i] = 0;
    }
    for(int i=0; i<edges.size(); i++) {
      indegree[edges.get(i).get(1)]++;
    }
    // System.out.println(Arrays.toString(indegree));
    // construct adjList 
    for(List<Integer> edge : edges) {
      adjList.get(edge.get(0)).add(edge.get(1));
    }

    List<Integer> topoSort = getTopoSort(adjList, indegree, n);
    System.out.println(topoSort);
  }

  public static List<Integer> getTopoSort(List<List<Integer>> adjList, int[] indegree, int n) {
    List<Integer> topoSort = new ArrayList<>();

    Deque<Integer> stk = new ArrayDeque<>();
    // push all nodes with 0 indegree
    for(int i=0; i<n; i++) {
      if(indegree[i] == 0) {
        stk.push(i);
      }
    }

    while(!stk.isEmpty()) {
      int node = stk.pop();
      // add this node in answer array
      topoSort.add(node);

      // loop through the children of this node and add nodes with 0 indegree
      for(Integer child : adjList.get(node)) {
        // reduce indegree of child by 1
        indegree[child]--;
        // push in stack children with indegree 0
        if(indegree[child] == 0) {
          stk.push(child);
        }
      }
    }

    for(int i=0; i<n; i++) {
      // this means graph has a cycle
      if(indegree[i] != 0) {
        return null;
      }
    }

    return topoSort;
  }
}