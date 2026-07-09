class Solution {
    public void Permutations(List<List<Integer>> ans, List<Integer> ds, Map<Integer, Boolean> flag, int n,int[]nums){
        if(ds.size() == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i<n; i++){
            if(flag.get(nums[i]))continue;
            flag.put(nums[i],true);
            ds.add(nums[i]);
            Permutations(ans,ds,flag,n,nums);
            flag.put(nums[i],false);
            ds.remove(ds.size()-1);

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = nums.length;

        Map<Integer, Boolean> flag = new HashMap<>();
        for(int i : nums)
            flag.put(i,false);
        
        Permutations(ans,ds,flag,n,nums);

        return ans;

    }
}