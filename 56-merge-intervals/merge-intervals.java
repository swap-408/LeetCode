class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> l = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        for(int i=0;i< intervals.length;){
            int j = i+1;
            int[] curr = intervals[i];
            while(j<intervals.length && intervals[j][0]<=curr[1]){
                curr[1] = Math.max(curr[1],intervals[j][1]);
                j++;
            }
            i = j;
            l.add(curr);
        }
        int[][] res = l.toArray(new int[l.size()][]);
        return res;
    }
}