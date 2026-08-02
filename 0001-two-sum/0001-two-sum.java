class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seen = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int res = target-nums[i];
            if(seen.containsKey(res))return new int[]{i, seen.get(res)};
            seen.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}