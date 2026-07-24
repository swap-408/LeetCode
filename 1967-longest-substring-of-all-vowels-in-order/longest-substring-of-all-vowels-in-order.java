class Solution {
    int start = 0;
    public int longestBeautifulSubstring(String word) {
        int res =0;
        while(start<word.length()){
            if(word.charAt(start)=='a'){
                int temp = seq(word);
                if(temp != -1) res = Math.max(res,temp);
            }else start++;
        }
        return res;
    }
    public int seq(String word){
        int n = word.length();
        int count = start;
        while(start < n && word.charAt(start)=='a') start++;
        if(start==n || word.charAt(start)!='e') return -1;

        while(start < n && word.charAt(start)=='e') start++;
        if(start==n || word.charAt(start)!='i') return -1;
        
        while(start < n && word.charAt(start)=='i') start++;
        if(start==n || word.charAt(start)!='o') return -1;
        
        while(start < n && word.charAt(start)=='o') start++;
        if(start==n || word.charAt(start)!='u') return -1;
        
        while(start < n && word.charAt(start)=='u') start++;
        return start - count;
    }
}