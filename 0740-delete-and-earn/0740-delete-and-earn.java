class Solution {

    int[] points;
    int[] dp;

    public int deleteAndEarn(int[] nums) {

        // Find maximum number
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // points[i] = total points obtained by taking all i's
        points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        dp = new int[max + 1];
        Arrays.fill(dp, -1);

        return solve(max);
    }

    private int solve(int i) {

        // Base case
        if (i <= 0) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Don't take i
        int notTake = solve(i - 1);

        // Take i -> cannot take i - 1
        int take = points[i] + solve(i - 2);

        return dp[i] = Math.max(take, notTake);
    }
}