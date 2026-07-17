class Solution {
    void backtrack(List<List<Integer>> ans, List<Integer> ds, int[] candidates, int target, int i, int sum){
        if(i == candidates.length){
            if(sum == target){
                ans.add(new ArrayList<>(ds));
            }

            return;
        }

        if(sum+candidates[i]<=target){
            ds.add(candidates[i]);
            backtrack(ans,ds,candidates,target,i+1,sum+candidates[i]);
            ds.remove(ds.size()-1);
        }

        int idx=i+1;

        while(idx<candidates.length && candidates[idx]==candidates[idx-1])idx++;
        backtrack(ans,ds,candidates,target,idx,sum);
    } 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int i = 0;
        int sum = 0;
        backtrack(ans,ds,candidates,target,i,sum);

        return ans;
    }
}