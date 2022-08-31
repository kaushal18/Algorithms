// https://leetcode.com/problems/permutations/

// backtracking
// time - O(N * N!) --> there are N! permutations and to get to those we need O(N) time ie iterating through the whole array
// space - O(N * N!) --> N! permutations each with length N
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> totalPermutations = new ArrayList<>();  
      helper(nums, totalPermutations, new ArrayList<>());
      return totalPermutations;
    }
  
    public void helper(int[] nums, List<List<Integer>> totalPermutations, List<Integer> currPermutation) {
      if(currPermutation.size() == nums.length) {
        totalPermutations.add(new ArrayList(currPermutation));
        return;
      }
      
      for(int i=0; i<nums.length; i++) {
        if(currPermutation.contains(nums[i])) continue;
        
        currPermutation.add(nums[i]);
        helper(nums, totalPermutations, currPermutation);
        currPermutation.remove(currPermutation.size()-1);
      }
    }
}