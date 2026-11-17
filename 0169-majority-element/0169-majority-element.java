class Solution {
    public int majorityElement(int[] nums) {
        int maxelem = nums[0];
        int c = 0;

        for(int i : nums){
            if(i == maxelem)c++;
            else c--;

            if(c == 0 && i!=maxelem){
                maxelem=i;
                c=1;
            }
        }

        return maxelem;
    }
}