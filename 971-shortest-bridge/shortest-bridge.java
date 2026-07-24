class Solution {
    List<int[]> l1 = new ArrayList<>();
    List<List<int[]>> l2 = new ArrayList<>();
    boolean[][] v;
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        v = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!v[i][j] && grid[i][j]==1){
                    dfs(grid,i,j);
                    l2.add(l1);
                    l1 = new ArrayList<>();
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int[] a1: l2.get(0)){
            for(int[] a2: l2.get(1)){
                res = Math.min(res, Math.abs(a1[0]-a2[0])+Math.abs(a1[1]-a2[1]));
            }
        }
        return res-1;
    }
    public void dfs(int[][] grid, int i ,int j){
        int m = grid.length, n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>= n || v[i][j] || grid[i][j]==0) return;
        v[i][j] = true;
        l1.add(new int[]{i,j});
        dfs(grid,i-1,j);dfs(grid,i+1,j);dfs(grid,i,j-1);dfs(grid,i,j+1);
        return;
    }
}