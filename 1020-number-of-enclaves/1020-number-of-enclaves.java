class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] v = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if((i == 0 || j == 0 || j == m-1 || i == n-1) && (grid[i][j] == 1 && !v[i][j])){
                    solve(grid, i,j,n,m,v);
                }
            }
        }

        int cnt = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && !v[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void solve(int[][] grid, int i, int j, int n, int m, boolean[][] v){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0 || v[i][j])return;

        v[i][j] = true;

        solve(grid,i+1,j,n,m,v);
        solve(grid,i,j+1,n,m,v);
        solve(grid,i-1,j,n,m,v);
        solve(grid,i,j-1,n,m,v);
    }
}