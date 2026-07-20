class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0, curr = 0, n = cardPoints.length,j=k;
        for(int i=0;i<k;i++){
            curr += cardPoints[i];
        }
        res = curr;
        for(int i=n-1;i>=n-k;i--){
            curr += cardPoints[i];
            curr -= cardPoints[j-1];
            j--;
            res = Math.max(curr,res);
        }
        return res;

    }
}