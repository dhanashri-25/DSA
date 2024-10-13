// package Arrays.Easy;

// public @interface PairsWithSum {
  
// }
// package arrays.easy;

import java.util.HashSet;

public class  PairsWithSum {

    public int countPair(int k, int[] arr) {
        // Using a HashSet to store the visited elements
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        
        // Loop through the array to find pairs
        for (int i = 0; i < arr.length; i++) {
            // Check if the complement of the current element (k - arr[i]) exists in the set
            if (set.contains(k - arr[i])) {
                count++; // Increment the count when a valid pair is found
            }
            // Add the current element to the set
            set.add(arr[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        PairsWithSum solution = new PairsWithSum();
        
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 8;
        System.out.println("Number of pairs: " + solution.countPair(k1, arr1));  // Output: 3

        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int k2 = 98;
        System.out.println("Number of pairs: " + solution.countPair(k2, arr2));  // Output: 0
    }
}
