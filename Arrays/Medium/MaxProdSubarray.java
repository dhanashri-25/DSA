public class MaxProdSubarray {
  public static void main(String[] args) {
      Solution solution = new Solution();
      int[] nums = {2, 3, -2, 4};
      int result = solution.maxProduct(nums);  // corrected method name
      System.out.println("Maximum Product Subarray: " + result);
  }
}

class Solution {
  public int maxProduct(int[] nums) {
      int leftprod = 1;
      int rightprod = 1;
      int ans = nums[0];

      for (int i = 0; i < nums.length; i++) {
          leftprod = leftprod == 0 ? 1 : leftprod;
          rightprod = rightprod == 0 ? 1 : rightprod;

          leftprod *= nums[i];
          rightprod *= nums[nums.length - 1 - i];

          ans = Math.max(ans, Math.max(leftprod, rightprod));
      }

      return ans;
  }
}
