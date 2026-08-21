class Solution {
    List<Set<Character>> row = new ArrayList<>();
    List<Set<Character>> col = new ArrayList<>();
    List<Set<Character>> box = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char c = board[i][j];
                    row.get(i).add(c);
                    col.get(j).add(c);
                    box.get(3 * (i / 3) + j / 3).add(c);
                }
            }
        }
        solve(board); 
    }
    public boolean isInvalid(int i, int j, int k, char[][] board){
        char c = (char)(k+'0');
        return row.get(i).contains(c) || col.get(j).contains(c) || box.get(3*(i/3)+j/3).contains(c);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(int k=1;k<=9;k++){
                        if(!isInvalid(i,j,k,board)){
                            char c = (char)(k+'0');
                            board[i][j] = c;
                            row.get(i).add(c);
                            col.get(j).add(c);
                            box.get(3*(i/3)+j/3).add(c);
                            if(solve(board)) return true;
                            board[i][j] = '.';
                            row.get(i).remove(c);
                            col.get(j).remove(c);
                            box.get(3*(i/3)+j/3).remove(c);

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
}