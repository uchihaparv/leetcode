class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    solve(grid, i, j, n, m, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void solve(char[][] grid, int i, int j, int n, int m, boolean[][] visited){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || grid[i][j] == '0')return;

        visited[i][j] = true;
        
         solve(grid, i,j-1,n,m,visited);
         solve(grid, i, j+1, n, m, visited);
         solve(grid, i-1, j, n, m, visited);
         solve(grid, i+1, j, n, m, visited);
    }
}