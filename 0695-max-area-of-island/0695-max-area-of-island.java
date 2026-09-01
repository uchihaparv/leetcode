class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            int curr = 0;
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    curr = solve(grid, i, j, n, m, visited);
                    max = Math.max(curr, max);
                }
            }
        }

        return max;
 
    }

    private int solve(int[][] grid, int i, int j, int n, int m ,boolean[][] visited){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || grid[i][j] == 0)return 0;

        visited[i][j] = true;

        int l = solve(grid, i,j-1,n,m,visited);
        int r = solve(grid, i, j+1, n, m, visited);
        int u = solve(grid, i-1, j, n, m, visited);
        int d = solve(grid, i+1, j, n, m, visited);

        return grid[i][j]+l+u+d+r;
    }
}