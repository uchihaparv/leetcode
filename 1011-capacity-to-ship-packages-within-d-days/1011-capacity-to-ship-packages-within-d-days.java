class Solution {
    public boolean isPossible(int cap, int days, int[] weights){
        int d = 1;
        int sum=0;

        for(int i : weights){
            sum+=i;

            if(sum>cap){
                sum=i;
                d++;
            }
        }

        return d<=days;

    }
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        int ans=1;

        for(int i : weights){
            r+=i;
            l=Math.max(i,l);
        }

        while(l<=r){
            int mid = l+(r-l)/2;

            if(isPossible(mid,days,weights)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }

        return ans;

    }
}