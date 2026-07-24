class Solution {
    public int longestBeautifulSubstring(String word) {
        int res =0;
        int uv = 1;
        int left =0;
        for(int right=1;right<word.length();right++){
            if(word.charAt(right)<word.charAt(right-1)){
                left = right;
                uv = 1;
            }else if(word.charAt(right)>word.charAt(right-1)){
                uv++;
            }
            if(uv==5){
                res = Math.max(res, right-left+1);
            }
        }
        return res;
    }
}