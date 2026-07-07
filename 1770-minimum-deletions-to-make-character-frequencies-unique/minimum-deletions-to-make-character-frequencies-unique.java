class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int res = 0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int p = Integer.MAX_VALUE;
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            if(p==0){
                res += freq[i]; continue;
            }
            if(p<=freq[i]){
                p = p-1;
                res += freq[i]-p;
            }else{
                p=freq[i];
            }
        }
        return res;
    }
}