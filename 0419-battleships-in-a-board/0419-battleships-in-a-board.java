class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    solve(board, i, j, n, m, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }
    private void solve(char[][] board, int i, int j, int n, int m, boolean[][] visited){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || board[i][j] == '.')return;

        visited[i][j] = true;
        solve(board, i,j-1,n,m,visited);
         solve(board, i, j+1, n, m, visited);
         solve(board, i-1, j, n, m, visited);
         solve(board, i+1, j, n, m, visited);
    }
}