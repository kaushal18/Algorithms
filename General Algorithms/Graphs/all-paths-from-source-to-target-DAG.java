
// Time - O(N * 2^N) - https://leetcode.com/problems/all-paths-from-source-to-target/discuss/118691/C++Python-Backtracking/198488
class Solution {
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      int n = graph.length;
      
      List<Integer> currPath = new ArrayList<>();
      Deque<Integer> stk = new ArrayDeque<>();
      
      stk.push(0);
      while(!stk.isEmpty()) {
        int node = stk.pop();
        currPath.add(node);
        
        if(node == n-1) {
          // O(N)
          paths.add(new ArrayList<>(currPath));
          continue;
        }
        
        for(int[] child : graph[node]) {
          stk.push(child);
        }
      }
    }
}