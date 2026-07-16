class Solution {
    void backtracking(List<List<Integer>> ans, List<Integer> ds, int[] candidates, int target, int i,int sum){
        if(i == candidates.length){
            if(sum == target){
                ans.add(new ArrayList<>(ds));
            }

            return;
        }

        
        if(sum+candidates[i]<=target){
            ds.add(candidates[i]);
            backtracking(ans,ds,candidates,target,i,sum+candidates[i]);
            ds.remove(ds.size()-1);
        }
        backtracking(ans,ds,candidates,target,i+1,sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int i = 0;
        int sum = 0;

        backtracking(ans,ds,candidates,target,i,sum);
        
        return ans;
    }
}