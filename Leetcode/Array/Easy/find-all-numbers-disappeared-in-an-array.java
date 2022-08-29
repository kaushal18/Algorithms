// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int num = Math.abs(nums[i])-1;
            if(nums[num] > 0) {
                nums[num] = -nums[num];
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) ans.add(i+1);
        }
        
        return ans;
    }
}