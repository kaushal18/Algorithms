class DFS {
  public void dfs(List<List<Integer>> adjList, boolean[] visited) {
    Deque<Node> stk = new ArrayDeque<>();
    // push start node
    stk.push(0);
    
    while(!stk.isEmpty()) {
      int parent = stk.pop();
      if(visited[parent]) continue;
      visited[parent] = true;
      
      List<Integer> children = adj.get(node.val);
      for(Integer child : adjList.get(parent)) {
        if(!visited[child]) {
          stk.push(new Node(child, node.val));
        }
      }
    }
  }
}