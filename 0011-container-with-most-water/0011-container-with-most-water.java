class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;

        int maxArea = 0;

        while(l<r){
            int h = Math.min(height[l], height[r]);
            int b = r-l;
            int area = h*b;
            maxArea = Math.max(maxArea, area);
            if(height[r]<height[l])r--;
            else l++;
        }

        return maxArea;
    }
}