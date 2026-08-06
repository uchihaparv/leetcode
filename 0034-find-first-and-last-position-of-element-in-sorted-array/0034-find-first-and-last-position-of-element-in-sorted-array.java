class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        // Lower Bound
        int first = nums.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                first = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // Target not found
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }

        // Upper Bound
        l = 0;
        r = nums.length - 1;
        int upper = nums.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > target) {
                upper = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int last = upper - 1;

        return new int[]{first, last};
    }
}