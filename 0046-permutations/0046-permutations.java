class Solution {
    void backtrack(List<List<Integer>> ans, List<Integer> ds, Map<Integer, Boolean> map, int[] nums, int n, int i){
        if(i == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int ele : nums){
            if(!map.get(ele)){
                map.put(ele,true);
                ds.add(ele);
                backtrack(ans,ds,map,nums,n,i+1);
                ds.remove(ds.size()-1);
                map.put(ele,false);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i : nums)map.put(i,false);

        backtrack(ans,ds,map,nums,nums.length,0);

        return ans;
    }
}