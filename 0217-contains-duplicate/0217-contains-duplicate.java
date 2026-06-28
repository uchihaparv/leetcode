class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Map<Integer, Integer> container = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            container.put(nums[i], container.getOrDefault(nums[i], 0) +1);
        }

        for(int i : container.values()){
            if(i>1)return true;
        }
        return false;
    }
}