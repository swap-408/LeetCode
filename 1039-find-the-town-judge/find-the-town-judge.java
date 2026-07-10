class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] freq = new int[n];
        for(int[] e: trust){
            freq[e[0]-1]--;
            freq[e[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(freq[i]==n-1) return i+1;
        }
        return -1;
    }
}