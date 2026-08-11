class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int maxSum = nums[0];

        for(int i : nums){

            curr+=i;
            maxSum = Math.max(curr,maxSum);
            if(curr<0)curr=0;
            
        }
        return maxSum;
    }
}