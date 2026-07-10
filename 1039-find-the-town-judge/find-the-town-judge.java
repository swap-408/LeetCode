class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] freq = new int[n];
        for(int[] e: trust){
            graph.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
            freq[e[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(freq[i]==n-1 && !graph.keySet().contains(i+1)) return i+1;
        }
        return -1;
    }
}