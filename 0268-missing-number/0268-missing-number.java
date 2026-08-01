class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int cur=0;
        for(int i : nums)cur+=i;

        return sum-cur;
    }
}