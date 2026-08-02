class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;

        while(l<r){
            int h = Math.min(height[l],height[r]);
            int b = r-l;
            int currArea = h*b;
            maxArea = Math.max(maxArea,currArea);

            if(height[l]<height[r])l++;
            else r--;
        }

        return maxArea;
    }
}