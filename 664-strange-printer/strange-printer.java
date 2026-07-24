class Solution {
    public int strangePrinter(String s) {
        StringBuilder s1 = new StringBuilder();
        s1.append(s.charAt(0));
        for(char c: s.toCharArray()){
            if(c!=s1.charAt(s1.length()-1)) s1.append(c);
        }
        s = s1.toString();
        int n = s1.length();
        Integer[][] memo = new Integer[n][n];
        return minimum(0,n-1,s,memo);
    }

    public int minimum(int start, int end, String s, Integer[][] memo){
        if(start>end) return 0;

        if(memo[start][end] != null) return memo[start][end];

        int minTrns = 1 + minimum(start+1,end,s,memo);

        for(int k = start +1;k<=end;k++){
            if(s.charAt(k)==s.charAt(start)){
                int turnsWithMatch = minimum(start,k-1,s,memo)+minimum(k+1,end,s,memo);
                minTrns = Math.min(minTrns,turnsWithMatch );
            }
        }

        return memo[start][end]=minTrns;
    }
}