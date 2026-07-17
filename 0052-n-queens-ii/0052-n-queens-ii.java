class Solution {
    int cnt = 0;

    public boolean isSafe(char[][] board, int row, int col, int n){
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }


        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }


        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public void solve(char[][] board, int row, int n){
        if(row == n){
            cnt++;
            return;
        }

        for(int i = 0; i<n; i++){


            if(isSafe(board, row,i,n)){
                board[row][i] = 'Q';
                solve(board, row+1,n);
                board[row][i] = '.';
            }
        }
    }


    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
        Arrays.fill(board[i], '.');
        }

        solve(board,0,n);

        return cnt;
    }


    
}