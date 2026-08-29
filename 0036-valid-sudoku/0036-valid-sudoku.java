class Solution {

    public boolean solve(char[][] board, char val, int row, int col) {

    
        for (int i = 0; i < board.length; i++) {

     
            if (i != row && board[i][col] == val) {
                return false;
            }

       
            if (i != col && board[row][i] == val) {
                return false;
            }
        }

     
        int strow = (row / 3) * 3;
        int stcol = (col / 3) * 3;

       
        for (int i = strow; i < strow + 3; i++) {
            for (int j = stcol; j < stcol + 3; j++) {

                if ((i != row || j != col) && board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] != '.') {

                    if (!solve(board, board[i][j], i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}