class Solution {
    public int minimumPushes(String word) {
        int[] fre = new int[26];
        for(char c : word.toCharArray()){
            fre[c-'a']++;
        }

        int ans = 0;
        int cnt = 0;
        int push = 1;

        Arrays.sort(fre);

        for(int i = 25; i>=0; i--){

            ans += fre[i]*push;
            cnt++;

            if(cnt == 8){
                cnt=0;
                push++;
            }
        }

        return ans;


    }
}