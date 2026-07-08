class Solution {
    public int[] helper(int[] nums, int[] ans, int i){
        if(i==nums.length)return ans;

        ans[i] = nums[nums[i]];

        return helper(nums, ans, i+1); 
    }
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        return helper(nums, ans, 0);
    }
}