
class Solution {
    public String[] createGrid(int m, int n) {
        char[][] res = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    res[i][j] = '.';
                } else {
                    res[i][j] = '#';
                }
            }
        }

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(res[i]);
        }

        return ans;
    }
}
