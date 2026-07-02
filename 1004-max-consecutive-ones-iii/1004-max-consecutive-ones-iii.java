class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt = 0, j = 0, len = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0)cnt++;

            while(cnt>k){
                if(nums[j] == 0)cnt--;
                j++;
            }

            len = Math.max(len,i-j+1);
        }

        return len;
    }
}