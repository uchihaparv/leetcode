class Solution {
    int cnt = 0;

    public void helper(int n){
        if(n == 0)return;

        if(n%2 == 0){
            cnt++;
            helper(n/2);
        }
        else {
            cnt++;
            helper(n-1);
        }
    }

    public int numberOfSteps(int num) {

        helper(num);

        return cnt;    
    }
}