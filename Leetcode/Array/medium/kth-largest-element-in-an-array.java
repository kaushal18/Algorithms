// https://leetcode.com/problems/kth-largest-element-in-an-array/

// MinHeap
// time - O(nlog(k))
// space - O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      
      for(int num : nums) {
        minHeap.add(num);
        
        if(minHeap.size() > k) {
          minHeap.poll();
        }
      }
      
      return minHeap.peek();
    }
}

// MaxHeap  - construct maxheap and then remove k-1 elements
// time - O(n + klog(n))
// space - O(n)


// most optimized - quick select
// time - O(n)
// space - O(1)
