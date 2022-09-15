// Time --> O(NlogK)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      // min heap
      PriorityQueue<Element> heap = new PriorityQueue<>(new Comparator<Element>() {
        public int compare(Element lhs, Element rhs) {
          if(lhs.freq<rhs.freq) return -1;
          if(lhs.freq>rhs.freq) return +1;
          return 0;
        }
      });
      Map<Integer, Integer> map = new HashMap<>();
      int[] ans = new int[k];
      
      // O(n)
      for(int i=0; i<nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);  
      }
      
      // worst case O(n)
      for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // O(logK) --> heap size is K
        heap.add(new Element(entry.getKey(), entry.getValue()));
        if(heap.size() > k) {
          heap.poll();
        }
        // System.out.println(heap.peek().val);
      }
      
      int i=k-1;
      while(!heap.isEmpty()) {
        ans[i] = heap.poll().val;
        i--;
      }
      return ans;
    }
}

class Element {
  int val;
  int freq;
  public Element(int val, int freq) {
    this.val = val;
    this.freq = freq;
  }
}