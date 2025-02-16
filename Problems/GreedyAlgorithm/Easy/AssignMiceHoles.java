import java.util.*;

public class AssignMiceHoles {
  public static void main(String[] args) {
    int N = 3;
    int M[] = { 4, -4, 2 };
    int H[] = { 4, 0, 5 };
    Arrays.sort(M);
    Arrays.sort(H);
    int max = Integer.MIN_VALUE;
    int i = 0;
    int j = 0;
    while (i < M.length) {
      max = Math.max(max, Math.abs(H[i] - M[i]));
      i++;
      j++;
    }
    System.out.println("Maximum time is :" + max);
  }
}
// Time Complexity: O(N log N)
// Space Complexity: O(1)

// dry run
// M =-4,2,4
// H = 0,4,5
// itr 1: i=0,j=0 max=4 i=1 j=1
// itr 2: i=j=1 max=(4,2)= 4
// itr 3: i=j=2 max=(4,3)=4