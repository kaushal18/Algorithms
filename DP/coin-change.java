
// Unbounded Knapsack problem
class Solution {
    public int coinChange(int[] coins, int amount) {
      int[][] dp = new int[coins.length+1][amount+1];
      for(int i=0; i<=coins.length; i++) {
        for(int j=0; j<=amount; j++) {
          dp[i][j] = -1;
        }
      }
      
      int minCoins = helper(coins, amount, coins.length, dp);
      return minCoins == Integer.MAX_VALUE-1 ? -1 : minCoins;
    }
  
    public int helper(int[] coins, int amount, int n, int[][] dp) {
      if(amount == 0) {
        return 0;
      }
      if(amount < 0 || n == 0) return Integer.MAX_VALUE - 1;
      if(dp[n][amount] != -1) return dp[n][amount];
      
      // if current coin value is less than amount that is left --> we have 2 options to include to not
      // intuition - current item weight is less than remaining capacity --> 2 options
      if(coins[n-1] <= amount) {
        dp[n][amount] = Math.min(1 + helper(coins, amount-coins[n-1], n, dp),
                                 helper(coins, amount, n-1, dp));
      }
      // if coin value is > than left amount --> we cannot take this coin
      // intuition - current item has weight > than remaining capacity of knapsack
      else {
        dp[n][amount] = helper(coins, amount, n-1, dp);
      }
      return dp[n][amount];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
      int[][] dp = new int[coins.length+1][amount+1];
      for(int i=0; i<=coins.length; i++) {
        dp[i][0] = 0;
      }
      for(int j=0; j<=amount; j++) {
        dp[0][j] = Integer.MAX_VALUE-1; 
      }
      for(int i=1; i<=coins.length; i++) {
        for(int j=1; j<=amount; j++) {
          if(coins[i-1] <= j) {
            dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
          }
          else {
            dp[i][j] = dp[i-1][j]; 
          }
        }
      }
      
      if(dp[coins.length][amount] == Integer.MAX_VALUE-1) return -1;
      return dp[coins.length][amount];
    }
}