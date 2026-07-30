class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        int cnt = 1;
        while(n>8){
            ans+= 8*cnt;
            n-=8;
            cnt++;
        }

        return ans+(n!=0?cnt*n:0);
    }
}