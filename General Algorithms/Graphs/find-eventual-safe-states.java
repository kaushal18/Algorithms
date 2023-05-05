class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      int[] isTerminal = new int[n];
      List<Integer> ans = new ArrayList<>();
      
      int[] indegree = new int[n];
      List<List<Integer>> adjList = new ArrayList<>();
      for(int i=0; i<graph.length; i++) {
        adjList.add(new ArrayList<>());
      }
      
      // reverse the graph edges
      for(int parent=0; parent<n; parent++) {
        for(int i=0; i<graph[parent].length; i++) {
          adjList.get(graph[parent][i]).add(parent);
        }
        indegree[parent] += graph[parent].length;
      }
      
      // Topological Sort
      Deque<Integer> stk = new ArrayDeque<>();
      for(int i=0; i<n; i++) {
        if(indegree[i] == 0) {
          stk.push(i);
        }
      }
      
      while(!stk.isEmpty()) {
        int node = stk.pop();
        isTerminal[node] = 1;
        
        for(Integer child : adjList.get(node)) {
          indegree[child]--;
          if(indegree[child] == 0) {
            stk.push(child);
          }
        }
      }
      
      for(int i=0; i<n; i++) {
        if(isTerminal[i] == 1) ans.add(i);
      }
      return ans;
    }
}