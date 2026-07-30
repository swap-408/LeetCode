class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            for(String s: strs){
                if(s.length()<=i || s.charAt(i)!=strs[0].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}