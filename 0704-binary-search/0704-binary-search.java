class Solution {
        public int search(int[] nums, int target, int st, int end){
        if(st>end)return -1;

        int mid = st+(end-st)/2;
        if(nums[mid] == target)return mid;
        else if(nums[mid]>target)return search(nums, target, st, mid-1);
        else return search(nums, target, mid+1, end);

    }
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length-1;

        return search(nums,target,st,end);
    }
}