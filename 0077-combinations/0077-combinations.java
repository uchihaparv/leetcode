class Solution {
    void backtrack(List<List<Integer>> ans,List<Integer> ds,int curr, int k, int n){
        if(ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = curr+1; i<=n; i++){
            ds.add(i);
            backtrack(ans,ds,i,k,n);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        backtrack(ans,ds,0,k,n);

        return ans;


    }
}