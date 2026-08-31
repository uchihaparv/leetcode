class Solution {

    public void solve(int[][] image, int sr, int sc, int color, int originalColor) {

        int n = image.length;
        int m = image[0].length;

        if (sr < 0 || sr >= n || sc < 0 || sc >= m) {
            return;
        }


        if (image[sr][sc] != originalColor) {
            return;
        }

        image[sr][sc] = color;

        solve(image, sr + 1, sc, color, originalColor);
        solve(image, sr - 1, sc, color, originalColor);
        solve(image, sr, sc + 1, color, originalColor);
        solve(image, sr, sc - 1, color, originalColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

  
        if (originalColor == color) {
            return image;
        }

        solve(image, sr, sc, color, originalColor);

        return image;
    }
}