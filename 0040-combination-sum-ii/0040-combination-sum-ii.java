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
            Sum(ans,ds,candidates,target,sum+candidates[i],n,i+1);
            ds.remove(ds.size()-1);
        }

        int idx = i+1;

        while(idx<n && candidates[idx-1] == candidates[idx])idx++;
        Sum(ans,ds,candidates,target,sum,n,idx);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int sum = 0;
        int i = 0;
        int n = candidates.length;

        Sum(ans,ds,candidates,target,sum,n,i);

        return ans;
    }
}