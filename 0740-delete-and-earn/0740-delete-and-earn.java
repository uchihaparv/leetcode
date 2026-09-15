class Solution {
    int[] dp;
    int[] points;
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i : nums){
            max = Math.max(max,i);
        }

        points = new int[max+1];
        dp = new int[max + 1];
        Arrays.fill(dp,-1);

        for(int i : nums){
            points[i] += i;
        }

        return solve(max);
    }

    private int solve(int n){
        if(n<=0)return 0;
        if(dp[n]!=-1)return dp[n];

        int nt = solve(n-1);
        int t = points[n] + solve(n-2);

        return dp[n] = Math.max(t,nt);
    }
}


// class Solution {

//     int[] points;
//     int[] dp;

//     public int deleteAndEarn(int[] nums) {

  
//         int max = 0;
//         for (int num : nums) {
//             max = Math.max(max, num);
//         }

//         points = new int[max + 1];

//         for (int num : nums) {
//             points[num] += num;
//         }

//         dp = new int[max + 1];
//         Arrays.fill(dp, -1);

//         return solve(max);
//     }

//     private int solve(int i) {

    
//         if (i <= 0) {
//             return 0;
//         }

  
//         if (dp[i] != -1) {
//             return dp[i];
//         }

//         int notTake = solve(i - 1);

//         int take = points[i] + solve(i - 2);

//         return dp[i] = Math.max(take, notTake);
//     }
// }