class Pair{
    int i;
    int j;
    int t;

    Pair(int i, int j, int t){
        this.i = i;
        this.j = j;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2 && !v[i][j]){
                    v[i][j] = true;
                    q.offer(new Pair(i,j,0));
                }
            }
        }

        int ans = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int t = p.t;

            ans = Math.max(ans,t);

            if(i-1>=0 && grid[i-1][j] == 1 && !v[i-1][j]){
                v[i-1][j] = true;
                q.offer(new Pair(i-1,j,t+1));
            }

            
            if(j-1>=0 && grid[i][j-1] == 1 && !v[i][j-1]){
                v[i][j-1] = true;
                q.offer(new Pair(i,j-1,t+1));
            }

            
            if(i+1<n && grid[i+1][j] == 1 && !v[i+1][j]){
                v[i+1][j] = true;
                q.offer(new Pair(i+1,j,t+1));
            }

            
            if(j+1<m && grid[i][j+1] == 1 && !v[i][j+1]){
                v[i][j+1]=true;
                q.offer(new Pair(i,j+1,t+1));
            }
        }

        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && !v[i][j]){
                    return -1;
                }
            }
        }

        return ans;
    }
}