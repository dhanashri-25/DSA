class Solution {
  public int lengthOfLongestSubstring(String s) {
      Map<Character,Integer>mp=new HashMap<>();
      int r=0;int l=0;
      int maxlen=0;
      while(r<s.length()){
          if(mp.containsKey(s.charAt(r))){
              l=Math.max(mp.get(s.charAt(r))+1,l);
          }
          mp.put(s.charAt(r),r);
          maxlen=Math.max(r-l+1,maxlen);
          r++;
      }return maxlen;
  }
}
//tc=sc-O(n)