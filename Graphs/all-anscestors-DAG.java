
// topo sort and add parent in anscestor list
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
      List<List<Integer>> adjList = new ArrayList<>();
      int[] indegree = new int[n];
      List<Set<Integer>> ansc = new ArrayList<>();
      
      for(int i=0; i<n; i++) {
        adjList.add(new ArrayList<>());
        ansc.add(new TreeSet<>());
      }
      
      for(int[] edge : edges) {
        adjList.get(edge[0]).add(edge[1]);
        indegree[edge[1]]++;
      }
      
      Deque<Integer> stk = new ArrayDeque<>();
      for(int i=0; i<n; i++) {
        if(indegree[i] == 0) stk.push(i);
      }
      
      while(!stk.isEmpty()) {
        int parent = stk.pop();
        for(int child : adjList.get(parent)) {
          ansc.get(child).addAll(ansc.get(parent));
          ansc.get(child).add(parent);
          
          indegree[child]--;
          if(indegree[child] == 0) {
            stk.push(child);  
          }
          
        }
      }
      
      List<List<Integer>> result = new ArrayList<>();
      for(int i=0; i<n; i++) {
        List<Integer> temp = new ArrayList<>();
        temp.addAll(ansc.get(i));
        result.add(temp);
      }
      return result;
    }
}