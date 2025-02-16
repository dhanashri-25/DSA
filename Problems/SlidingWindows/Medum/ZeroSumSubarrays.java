import java.util.*;
class ZeroSumSubarrays{
  //Function to count subarrays with sum equal to 0.
  public static long findSubarray(long[] arr ,int n) 
  {
      //Your code here
      //using prefix sum
      long count=0;long sum=0;
      Map<Long,Integer>prefixSum=new HashMap<>();
      prefixSum.put(0L,1);//add initial sum of 0
      for(int i=0;i<n;i++){
          sum+=arr[i];
          // If the prefix sum has been seen before, it means there is a subarray
          // that sums to 0, so we add the frequency of this prefix sum to count
          if(prefixSum.containsKey(sum)){
              count+=prefixSum.get(sum);
          }
           // Update the frequency of the prefix sum in the map
           prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
          
      }
      return count;
  }
}
//tc-O(n)
//sc-O(n)
