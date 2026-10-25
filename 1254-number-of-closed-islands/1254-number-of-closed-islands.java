class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] v = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if((i == 0 || j==0 || i == n-1 || j == m-1) && grid[i][j] == 0 && !v[i][j])dfs(grid, i, j, v,n,m);
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0 && !v[i][j]){
                    cnt++;
                    dfs(grid, i, j, v, n, m);
                }
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] v , int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != 0 || v[i][j])return;

        v[i][j] = true;

        dfs(grid, i+1, j, v, n,m);
        dfs(grid, i-1, j, v, n,m);
        dfs(grid, i, j+1, v, n,m);
        dfs(grid, i, j-1, v, n,m);
    }
}