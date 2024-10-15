class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>mp=new HashMap<>();
        //step 1 iterate throught each index word
        for(int i=0;i<strs.length;i++){
            //step 2: convert each index element to char array
            char[]ch=(strs[i]).toCharArray();
            //step3: sort each index element in lexographical order
            Arrays.sort(ch);
            //step4: convert it back to string means bat-- 'b','a','t'="abt"
            String sorted=new String(ch);

            //step5:put sorted string to make list of similar ones
            if(!mp.containsKey(sorted)){
                mp.put(sorted,new ArrayList<>());
            }
            mp.get(sorted).add(strs[i]);//get sorted and add ith element into it
        }
        //step6:finally we make list of values in map and return 
        return new ArrayList<>(mp.values());
    }
}