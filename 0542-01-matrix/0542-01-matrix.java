class Pair{
    int i;
    int j;

    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j <m ;j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i,j));
                }
                else mat[i][j] = -1;
            }
        }
        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;

            for(int k = 0; k<4; k++){
                int nR = i+r[k];
                int nC = j+c[k];

                if(nR>=n || nC>=m || nR<0 || nC<0)continue;

                if(mat[nR][nC] == -1){
                    mat[nR][nC] = mat[i][j]+1;
                    q.offer(new Pair(nR, nC));
                }


            }
        }

        return mat;
    }
}