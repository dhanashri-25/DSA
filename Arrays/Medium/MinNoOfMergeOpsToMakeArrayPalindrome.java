public class MinNoOfMergeOpsToMakeArrayPalindrome {
  static int findMinOps(int[] arr, int n) {
    int count=0;
    int l=0;int r=arr.length-1;
    while(l<r){
      if(arr[l]==arr[r]) {
        l++;r--;
      }else if(arr[l]>arr[r]){
        arr[r-1]=arr[r]+arr[r-1];
        r--;
        count++;
      }
      else{
        arr[l+1]=arr[l]+arr[l+1];
        l++;
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 1, 4, 5, 9, 1 };
    System.out.println("Count of minimum operations is " +
        findMinOps(arr, arr.length));
  }
}
//for left=1 right=1 equal so ++
//l=4 r=9 as L<r l+(l+1) = 4+5=9 
//1 9 9 1 count=1
