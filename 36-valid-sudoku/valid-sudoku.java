class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowMasks = new int[9];
        int[] colMasks = new int[9];
        int[] boxMasks = new int[9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c == '.') continue;
                int value = c - '0';
                int mask = 1 << (value-1);
                int boxIndex = 3*(i/3) + j/3;
                
                boolean hasEntry = ((rowMasks[i] & mask) != 0) ||
                                    ((colMasks[j] & mask) != 0) ||
                                    ((boxMasks[boxIndex] & mask) != 0);

                if(hasEntry) return false;
                
                rowMasks[i] |= mask;
                colMasks[j] |= mask;
                boxMasks[boxIndex] |= mask;
            }
        }

        return true;
        
    }
}