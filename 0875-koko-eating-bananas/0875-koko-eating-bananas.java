class Solution {
    public boolean isPossible(int val, int h, int[] piles){
        int hour = 0;
        for(int i : piles){
            int curr = i;

           hour += Math.ceil((double)i / val);
            
        }

        return hour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int i : piles){
            r = Math.max(r,i);
        }
        int ans=0;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(isPossible(mid, h, piles)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }

        return ans;
    }
}