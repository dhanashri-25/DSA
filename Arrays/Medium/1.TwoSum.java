class Solution {
  public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer>mp=new HashMap<>();
      int [] ans=new int[2];
      ans[0]=ans[1]=-1;
      for(int i=0;i<nums.length;i++){
          int elem1=nums[i];
          int elem2=target-nums[i];
          if(mp.containsKey(elem2)){
              ans[0]=mp.get(elem2);
              ans[1]=i;
              return ans;
          }
          mp.put(elem1,i);
      }
      return ans;
  }
}
// 1) el1=2 el2=7 put 2,0
// 2) el1=7 el2=2 yes present so nums[0]=0 nums[1]=1 return [0,1]
//tc=O(n)
//sc=O(n)