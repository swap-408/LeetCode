class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0,j=0;
        int res = 0;
        while(j<s.length()){
            if(set.contains(s.charAt(j))){
                res = Math.max(res, set.size());
                set.remove(s.charAt(i));
                i++;
            }else{
                set.add(s.charAt(j));
                j++;
            }
        }
        res = Math.max(res, set.size());
        return res;
    }
}