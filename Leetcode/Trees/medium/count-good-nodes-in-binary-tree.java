// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

// Time - O(Nlog(N))
// Space - O(N)
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
      PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); 
      dfs(root, heap);
      return count;
    }
  
    public void dfs(TreeNode root, PriorityQueue<Integer> heap) {
      if(root == null) return;
      
      if(heap.size() == 0 || root.val >= heap.peek()) {
        heap.add(root.val);
        count++;
      }
      // System.out.println(heap);
      dfs(root.left, heap);
      dfs(root.right, heap);
      // O(logN)
      if(heap.peek() != null && root.val == heap.peek()) {
        heap.poll();
      }
    }
}

// Time - O(N)
// Space - O(N)
class Solution {
    public int goodNodes(TreeNode root) {
      return goodNodes(root, Integer.MIN_VALUE);
    }
  
    public int goodNodes(TreeNode root, int max) {
      if(root == null) return 0;
      
      max = Math.max(max, root.val);
      int count = root.val >= max ? 1 : 0;
      count += goodNodes(root.left, max);
      count += goodNodes(root.right, max);
      
      return count;
    }
}