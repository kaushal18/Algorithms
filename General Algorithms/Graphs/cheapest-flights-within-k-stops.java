// DFS - do dfs till k depth without maintaing visited array
// Time - O(N ^ K) --> at each node we have N choices (N child nodes) and we go till K depth
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      List<Map<Integer, Integer>> adjList = new ArrayList<>();
      int ans = Integer.MAX_VALUE;
      boolean found = false;
      for(int i=0; i<n; i++) {
        adjList.add(new HashMap<>());
      }
      
      for(int[] edge : flights) {
        adjList.get(edge[0]).put(edge[1], edge[2]);
        if(edge[1] == dst) {
          found = true;
        }
      }
      
      // if there is no edge to destination
      if(!found) return -1;
      
      Deque<Node> stk = new ArrayDeque<>();
      stk.push(new Node(src, 0, k));
      
      while(!stk.isEmpty()) {
        Node parent = stk.pop();
        for(Map.Entry<Integer, Integer> entry : adjList.get(parent.val).entrySet()) {
          int newSum = parent.sum + entry.getValue();
          
          // pruning
          if(parent.k < 0 || newSum >= ans) {
            continue;
          }
          if(parent.k >= 0 && entry.getKey() == dst) {
            ans = Math.min(parent.sum + entry.getValue(), ans);
          }
          
          stk.push(new Node(entry.getKey(), parent.sum + entry.getValue(), parent.k-1));
          
        }
      }
      
      return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

class Node {
  int val;
  int sum;
  int k;
  public Node(int val, int sum, int k) {
    this.val = val;
    this.sum = sum;
    this.k = k;
  }
}