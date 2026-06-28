class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> container = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(container.contains(nums[i]))return true;
            else container.add(nums[i]);
        }

        return false;
    }
}