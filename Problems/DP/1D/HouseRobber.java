import java.util.*;

public class HouseRobber {
  public static void main(String args[]) {
    // Input array with elements.
    int arr[] = { 2, 1, 4, 9 };

    // Get the length of the array.
    int n = arr.length;

    // Call the solve function to find the maximum possible sum.
    int result = houserobber(arr);

    // Print the result.
    System.out.println(result);
  }

  public static int houserobber(int[] nums) {
    int dp[] = new int[nums.length];
    Arrays.fill(dp, -1);
    return solve(nums.length - 1, nums, dp);
  }

  // // memoization
  // public static int solve(int idx, int[] nums, int[] dp) {
  //   if (idx < 0)
  //     return 0;
  //   if (idx == 0)
  //     return nums[idx];
  //   if (dp[idx] != -1)
  //     return dp[idx];
  //   int pick = nums[idx] + solve(idx - 2, nums, dp);
  //   int dontpick = 0 + solve(idx - 1, nums, dp);
  //   return dp[idx] = Math.max(pick, dontpick);
  // }

  // tabulation
  public static int solve(int n,int nums[], int dp[]) {
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int pick = nums[i];
      if (i > 1) {
        pick += dp[i - 2];
      }
      int dontpick = dp[i - 1];
      dp[i] = Math.max(pick, dontpick);
    }
    return dp[nums.length - 1];
  }
  //space optimization
  // public static int solve(int n,int nums[]) {
  //   int prev=nums[0];int prev2=0;
  //   for(int i=1;i<nums.length;i++){
  //     int pick=nums[i];
  //     if(i>1){
  //       pick+=nums[i-2];
  //     }
  //     int dontpick=nums[i-1];
  //     int curr=Math.max(pick,dontpick);
  //     prev2=prev;
  //     prev=curr;
  //     return prev;
  //   }
    
  }
