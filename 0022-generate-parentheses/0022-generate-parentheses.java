class Solution {
    public void Solver(List<String> ans , String curr, int open, int close, int n){
        if(curr.length() == 2*n){
            ans.add(curr);
            return;
        }

        if(open<n){
            Solver(ans, curr + "(", open + 1, close, n);
        }

        if(close < open){
            Solver(ans, curr + ")", open, close+1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String curr = "";
        int open = 0;
        int close = 0;

        Solver(ans,curr,open,close,n);

        return ans;
    }
}