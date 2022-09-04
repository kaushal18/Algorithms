
// Time - O(Nlog(N))
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
      List<List<Integer>> ans = new ArrayList<>();      
      
      int minDiff = Integer.MAX_VALUE;
      Arrays.sort(arr);
      
      for(int i=0; i<arr.length-1; i++) {
        minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i+1]));
      }
      
      // pairs will be adjacent to each other
      for(int i=0; i<arr.length-1; i++) {
        if(arr[i+1] - arr[i] == minDiff) {
          ans.add(Arrays.asList(arr[i], arr[i+1]));
        }
      }
      
      return ans;
    }
}