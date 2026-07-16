class Solution {
    boolean isSafeBoard(char[][] board, int row, int col, char val){
        for(int i = 0; i<board[0].length; i++){
            if(board[row][i] == val)return false;
            if(board[i][col] == val)return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;

    }
    public boolean Solve(char[][] board){
        int n = board[0].length;

        for(int row = 0; row<n; row++){
            for(int col = 0; col<n; col++){


                if(board[row][col] == '.'){
                    for(char i = '1'; i<='9'; i++){

                        
                        if(isSafeBoard(board,row,col,i)){

                            board[row][col] = i;

                            if(Solve(board))return true;

                            board[row][col] = '.';

                        }
                     
                    }
                    return false;
                }
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        Solve(board);
    }
}