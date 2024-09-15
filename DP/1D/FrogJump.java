import java.util.*;
//memoization
//O(n) //O(n)
public class FrogJump {
  public static int solve(int idx, int[] height, int[] dp) {
    if (idx == 0)
      return 0;
    if (dp[idx] != -1)
      return dp[idx];
    int jump1 = 0;
    int jump2 = 0;
    if (idx > 1) {
      jump1 = solve(idx - 1, height, dp) + Math.abs(height[idx] - height[idx - 1]);
      jump2 = solve(idx - 2, height, dp) + Math.abs(height[idx] - height[idx - 2]);
    }
    return dp[idx] = Math.min(jump1, jump2);
  }

  public static void main(String args[]) {

    int height[] = { 30, 10, 60, 10, 60, 50 };
    int n = height.length;
    int dp[] = new int[n];
    Arrays.fill(dp, -1);
    System.out.println(solve(n - 1, height, dp));
  }
}

//tabulation 
//O(n) O(n)
// class Solution{
//   public int minimumEnergy(int arr[],int N){
//       //code here
//       int [] dp=new int[N];
//       Arrays.fill(dp,-1);
//       dp[0]=0;
//       int jump1=Integer.MAX_VALUE;int jump2=Integer.MAX_VALUE;
//       for(int i=1;i<arr.length;i++){
//           jump1=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
//           if(i>1){
//               jump2=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
//           }
//           dp[i]=Math.min(jump1,jump2);
//       }
//       return dp[arr.length-1];
      
//   }
// }


//space optimization
// O(n) 
// O(1)
// public int minimumEnergy(int arr[],int N){
//   //code here
//   int prev=0;int prev2=0;
//   int jump2=Integer.MAX_VALUE;int jump1=Integer.MAX_VALUE;
//   for(int i=1;i<arr.length;i++){
//       jump1=prev+Math.abs(arr[i]-arr[i-1]);
//       if(i>1){
//           jump2=prev2+Math.abs(arr[i]-arr[i-2]);
//       }
//       int curr=Math.min(jump1,jump2);
//       prev2=prev;
//       prev=curr;
//   }
//   return prev;
// }