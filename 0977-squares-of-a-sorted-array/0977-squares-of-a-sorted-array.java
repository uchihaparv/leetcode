class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        int[] ans = new int[nums.length];
        int ind = r;

        while(l<=r){
            int lSq = nums[l]*nums[l];
            int rSq = nums[r]*nums[r];

            if(lSq>rSq){
                ans[ind--] = lSq;
                l++;
            }
            else {
                ans[ind--] = rSq;
                r--;
            }
        }

        return ans;
    }
}