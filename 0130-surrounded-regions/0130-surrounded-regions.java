class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] v = new boolean[n][m];
        for(int i =0;i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1 && (!v[i][j] && board[i][j] == 'O') ){
                    solve(board,i,j,n,m,v);
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O' && !v[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }

    private void solve(char[][] board, int i, int j, int n, int m, boolean[][] v){
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]=='X' || v[i][j])return;

        v[i][j]=true;
        solve(board,i+1,j,n,m,v);
        solve(board,i-1,j,n,m,v);
        solve(board,i,j+1,n,m,v);
        solve(board,i,j-1,n,m,v);
    }
}