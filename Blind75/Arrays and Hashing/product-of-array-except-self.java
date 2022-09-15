// Without division operation
// keep prefix and suffix product, then multiply both
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] product = new int[n];
      
      int[] leftProduct = new int[n];
      leftProduct[0] = 1;
      for(int i=1; i<n; i++) {
        leftProduct[i] = leftProduct[i-1] * nums[i-1];
      }
      
      int[] rightProduct = new int[n];
      rightProduct[n-1] = 1;
      for(int i=n-2; i>=0; i--) {
        rightProduct[i] = rightProduct[i+1] * nums[i+1];
      }
      
      for(int i=0; i<n; i++) {
        product[i] = leftProduct[i] * rightProduct[i];
      }
      
      return product;
    }
}