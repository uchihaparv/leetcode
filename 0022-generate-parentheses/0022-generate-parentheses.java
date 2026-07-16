class Solution {
    public void solve(List<String> ans, int open, int close, int n, String s){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }

        if(open<n){
            solve(ans,open+1,close,n,s+"(");
        }

        if(close<open){
            solve(ans,open,close+1,n,s+")");
        }

        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s="";
        int open = 0;
        int close = 0;

        solve(ans,open,close,n,s);

        return ans;
    }
}