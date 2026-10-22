class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int dis = curr[2];

            if(i == n-1 && j == n-1)return dis;
            for (int[] d : directions) {
                int nr = i + d[0];
                int nc = j + d[1];

      
                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = 1; 
                    q.offer(new int[]{nr, nc, dis + 1});
                }
            }
        }

        return -1;
    }
}