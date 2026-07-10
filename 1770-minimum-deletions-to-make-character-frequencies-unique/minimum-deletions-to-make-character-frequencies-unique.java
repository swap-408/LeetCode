class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int res =0;
        int prev = Integer.MAX_VALUE;
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            if(prev == 0) res += freq[i];
            else if(prev<=freq[i]){
                res += (freq[i]-prev+1);
                prev -= 1;
            }else{
                prev = freq[i];
            }
        }
        return res;
    }
}