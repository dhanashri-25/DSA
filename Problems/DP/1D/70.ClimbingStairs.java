//Memoization
//method1 
class Solution {
  public int climbStairs(int n) {
      Map<Integer, Integer> memo = new HashMap<>();
      return climbStairs(n, memo);
  }
  
  private int climbStairs(int n, Map<Integer, Integer> memo) {
      if (n == 0 || n == 1) {
          return 1;
      }
      if (!memo.containsKey(n)) {
          memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
      }
      return memo.get(n);
  }
}

//method2
//Tabulation
class Solution {
  public int climbStairs(int n) {
      if(n==1 || n==0) return 1;
      int[]dp=new int[n+1];
      dp[0]=dp[1]=1;
      for(int i=2;i<=n;i++){
          dp[i]=dp[i-1]+dp[i-2];
      }
      return dp[n];
  }
}
// dp[0] = 1  (Base case)
// dp[1] = 1  (Base case)
// dp[2] = dp[1] + dp[0] = 1 + 1 = 2
// dp[3] = dp[2] + dp[1] = 2 + 1 = 3
//both approaches have
//Time Complexity: O(n).
// Space Complexity: O(n).

//method3
//space optimazation
class Solution {
  public int climbStairs(int n) {
      if(n==0 || n==1) return 1;
      int prev=1;
      int curr=1;
      for(int i=2;i<=n;i++){
          int temp=curr;
          curr=prev+curr;
          prev=temp;
      }
      return curr;
  }
}
//time complexity : O(n) and a space complexity : O(1),