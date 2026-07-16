class Solution {
    boolean safe(char[][] board, char val, int row, int col){
        for(int i = 0; i<board.length; i++){
            if(board[i][col] == val)return false;
            if(board[row][i] == val)return false;
        }

        int strow = (row/3)*3;
        int stcol = (col/3)*3;

        for(int i = strow; i<strow+3; i++){
            for(int j = stcol; j<stcol+3; j++){
                if(board[i][j] == val)return false;
            }
        }

        return true;
    }
    public boolean solve(char[][] board){

        int n = board[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){


                if(board[i][j]=='.'){

                    for(char k = '1'; k<='9'; k++){

                        if(safe(board, k, i,j)){

                            board[i][j] = k;

                            if(solve(board))return true;

                            board[i][j] = '.';

                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}