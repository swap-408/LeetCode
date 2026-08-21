class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> row = new ArrayList<>();
        List<Set<Integer>> col = new ArrayList<>();
        List<Set<Integer>> box = new ArrayList<>();
        for(int i=0;i<9;i++){
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int curr = board[i][j]-'0';
                boolean cond = row.get(i).contains(curr) || col.get(j).contains(curr);
                cond = cond || box.get(3*(i/3)+j/3).contains(curr);
                if(cond) return false;
                row.get(i).add(curr);
                col.get(j).add(curr);
                box.get(3*(i/3) + j/3).add(curr);
            }
        }
        return true;

    }
}