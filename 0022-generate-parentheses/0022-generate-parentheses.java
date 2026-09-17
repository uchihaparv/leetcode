class Solution {
    private void solve(List<String> ans, int n, String s, int open, int close){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }

        if(open < n){
            solve(ans,n,s+"(",open+1, close);
        }

        if(close < open){
            solve(ans,n,s+")",open, close+1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(ans, n, "", 0,0);
        return ans;
    }
}