class Solution {

    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Put all 0s into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Pair(i, j));
                } else {
                    // Mark unvisited 1s
                    mat[i][j] = -1;
                }
            }
        }

        int[] r = {1, 0, -1, 0};
        int[] c = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair p = q.poll();

            int i = p.r;
            int j = p.c;

            for (int d = 0; d < 4; d++) {

                int nR = i + r[d];
                int nC = j + c[d];

                // Out of bounds
                if (nR < 0 || nR >= n || nC < 0 || nC >= m) {
                    continue;
                }

                // Unvisited cell
                if (mat[nR][nC] == -1) {

                    mat[nR][nC] = mat[i][j] + 1;

                    q.offer(new Pair(nR, nC));
                }
            }
        }

        return mat;
    }
}