// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/submissions/
// Time - O(V + E)
// Treat graph as unidirected and increment count if there is an outgoing edge in original graph
class Solution {
    public int minReorder(int n, int[][] connections) {
      List<Set<Integer>> originalEdge = new ArrayList<>();
      List<List<Integer>> adj = new ArrayList<>();
      int count = 0;
      
      for(int i=0; i<n; i++) {
        originalEdge.add(new HashSet<>());
        adj.add(new ArrayList<>());
      }
      
      for(int[] edge : connections) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
        originalEdge.get(edge[0]).add(edge[1]);
      }
      
      Deque<Integer> stk = new ArrayDeque<>();
      boolean[] visited = new boolean[n];
      stk.push(0);
      visited[0] = true;
      
      while(!stk.isEmpty()) {
        int parent = stk.pop();
        for(int child : adj.get(parent)) {
          if(visited[child]) continue;
          if(originalEdge.get(parent).contains(child)) {
            count++;
          }
          stk.push(child);
          visited[child] = true;
        }
      }
      
      return count;
    }
}