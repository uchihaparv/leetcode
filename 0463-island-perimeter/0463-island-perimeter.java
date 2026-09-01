class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1)return solve(grid, i,j,n,m,visited);
            }
        }

        return 0;
    }

    private int solve(int[][] grid, int i, int j, int n, int m, boolean[][] visited){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0 )return 1;

        if(visited[i][j])return 0;

        visited[i][j] = true;

        int l = solve(grid, i-1,j,n,m,visited);
        int r= solve(grid ,i+1,j,n,m,visited);
        int d = solve(grid ,i,j+1,n,m,visited);
        int u = solve(grid, i,j-1,n,m,visited);

        return l+u+r+d;
    }
}