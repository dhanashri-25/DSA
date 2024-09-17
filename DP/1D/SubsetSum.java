import java.util.Arrays;

public class SubsetSum {
    // Function to solve the subset sum problem using recursion and memoization (DP)
    static boolean solve(int idx, int target, int[] arr, int[][] dp) {
        // If target is 0, we found a subset that adds up to the target
        if (target == 0) return true;
        
        // If idx is 0, we can only take arr[0] and check if it equals the target
        if (idx == 0) return arr[0] == target;
        
        // If already computed, return the memoized result
        if (dp[idx][target] != -1) return dp[idx][target] == 1;

        // Don't take the current element
        boolean nottaken = solve(idx - 1, target, arr, dp);

        // Try taking the current element if it doesn't exceed the target
        boolean taken = false;
        if (arr[idx] <= target) {
            taken = solve(idx - 1, target - arr[idx], arr, dp);
        }

        // Memoize the result and return
        dp[idx][target] = nottaken || taken ? 1 : 0;
        return nottaken || taken;
    }

    // Main function to check if there's a subset that sums up to target
    static boolean subsetSumToK(int n, int k, int[] arr) {
        // DP table to memoize results, initialized with -1 (unvisited)
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function
        return solve(n - 1, k, arr, dp);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr)) {
            System.out.println("Subset with the given target found");
        } else {
            System.out.println("Subset with the given target not found");
        }
    }
}
