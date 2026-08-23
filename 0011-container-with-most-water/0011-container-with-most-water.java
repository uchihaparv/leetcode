class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxWater = 0;
        while(i<j){
            int h = Math.min(height[i], height[j]);
            int w = j-i;

            int curr = h*w;
            maxWater = Math.max(curr,maxWater);
            if(height[i] > height[j])j--;
            else i++;
        }
        return maxWater;
    }
}