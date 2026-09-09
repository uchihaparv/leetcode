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

        int cntFresh = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2 && !v[i][j]){
                    v[i][j] = true;
                    q.offer(new Pair(i,j,0));
                }

                if(grid[i][j] == 1)cntFresh++;
            }
        }

        int cnt = 0;
        int ans = 0;
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int t = p.t;

            ans = Math.max(ans,t);

            for(int k = 0;k<4; k++){
                int nRow = i+dRow[k];
                int nCol = j+dCol[k];

                if(nRow>=0 && nCol>=0 && nCol<m && nRow<n && grid[nRow][nCol] == 1 && !v[nRow][nCol]){
                    q.offer(new Pair(nRow, nCol, t+1));
                    v[nRow][nCol] = true;
                    cnt++;
                }
            }
        }

        if((cnt-cntFresh)!=0)return -1;

        return ans;
    }
}