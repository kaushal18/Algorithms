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

// recursive
// when going up after completing recursion how does we get max at that position - https://leetcode.com/problems/count-good-nodes-in-binary-tree/discuss/635258/JavaPython-3-Simple-recursive-and-iterative-DFS-codes-w-brief-explanation-and-analysis./839933
// ans --> I could think of the logic for this problem but couldn't think how to reset the max value once the path is changed. Then I realized that it would be implicitly taken care by the recursion call stack. 
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

// iterative - easier version to visualize
// in the stack we store the root reference and max "till that position" , so when we go up while in dfs we already have the max at that position ready in our stack
class Element {
  TreeNode node;
  int max;
  
  public Element(TreeNode node, int max) {
    this.node = node;
    this.max = max;
  }
}
class Solution {
    public int goodNodes(TreeNode root) {
      Deque<Element> stk = new ArrayDeque<>();
      int count = 0;
      stk.push(new Element(root, Integer.MIN_VALUE));
      
      while(!stk.isEmpty()) {
       
        Element e = stk.pop();
        TreeNode node = e.node;
        int max = e.max;
        // System.out.println(node.val);
        
        if(node.val >= max) {
          max = node.val;
          count++;
        }
        
        if(node.right != null) {
          stk.push(new Element(node.right, max));
        }
        if(node.left != null) {
          stk.push(new Element(node.left, max));
        }
      }
      
      return count;
    }
}