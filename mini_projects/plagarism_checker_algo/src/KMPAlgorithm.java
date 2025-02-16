public class KMPAlgorithm {
  public int search(String text, String pattern) {
      int m = pattern.length();
      int n = text.length();
      int[] lps = new int[m];
      computeLPSArray(pattern, lps);

      int first = 0, second = 0;

      while (first < n) {  // Fixed: Correct condition
          if (text.charAt(first) == pattern.charAt(second)) {
              first++;
              second++;
          }
          if (second == m) { // Full match found
              return first - second;
          } else if (first < n && text.charAt(first) != pattern.charAt(second)) {
              if (second == 0) {
                  first++;
              } else {
                  second = lps[second - 1];
              }
          }
      }
      return -1; // Pattern not found
  }

  private void computeLPSArray(String pattern, int[] lps) {
      int prefix = 0;
      int suffix = 1;
      lps[0] = 0; // First element of LPS array is always 0

      while (suffix < pattern.length()) {
          if (pattern.charAt(prefix) == pattern.charAt(suffix)) {
              prefix++;
              lps[suffix] = prefix;  // Assign LPS before incrementing suffix
              suffix++;
          } else {
              if (prefix != 0) {
                  prefix = lps[prefix - 1];
              } else {
                  lps[suffix] = 0;
                  suffix++;
              }
          }
      }
  }
}
