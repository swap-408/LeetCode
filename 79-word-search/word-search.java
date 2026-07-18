class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board,word,i,j,0,visited)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,int i,int j,int k, boolean[][] visited){
        if(k==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j]) return false;

        if(word.charAt(k)!=board[i][j]) return false;
        visited[i][j] = true;
        boolean found =  dfs(board,word,i+1,j,k+1,visited) || dfs(board,word,i-1,j,k+1,visited) ||dfs(board,word,i,j-1,k+1,visited) || dfs(board,word,i,j+1,k+1,visited);
        visited[i][j] = false;
        return found;
    }
}