class Solution {
    public void Sum(List<List<Integer>> ans, List<Integer> ds, int[] candidates, int target, int sum, int n, int i){
        if(i == n){
            if(sum == target){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(sum+candidates[i]<=target){
            ds.add(candidates[i]);
            Sum(ans,ds,candidates,target,sum+candidates[i],n,i);
            ds.remove(ds.size()-1);
        }
        Sum(ans,ds,candidates,target,sum,n,i+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int sum = 0;
        int i = 0;
        int n = candidates.length;

        Sum(ans,ds,candidates,target,sum,n,i);

        return ans;
    }
}