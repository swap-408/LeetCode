class Solution {
    int count =0;
    public int maxAreaOfIsland(int[][] grid) {
        int res =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dfs(grid,i,j);
                res = Math.max(res, count);
                count =0;
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j){
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return;
        grid[i][j]=0;
        count++;
        dfs(grid, i+1,j);dfs(grid, i-1,j); dfs(grid, i,j+1); dfs(grid, i,j-1);
    }
}