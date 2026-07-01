class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        int j = 0;
        double maxAvg = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            sum+=nums[i];
            if(i-j+1 == k){
                maxAvg = Math.max(maxAvg, sum/k);
                sum-=nums[j];
                j++;
            }
        }

        return maxAvg;
    }
}