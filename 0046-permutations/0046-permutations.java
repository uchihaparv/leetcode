class Solution {
    public void backtrack(List<List<Integer>> ans, List<Integer> ds, Map<Integer, Boolean> map, int i, int[] nums){
        if(i==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int ele : nums){
            if(!map.get(ele)){
                map.put(ele, true);
                ds.add(ele);
                backtrack(ans,ds, map,i+1,nums);
                ds.remove(ds.size()-1);
                map.put(ele, false);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,false);
        }
        List<Integer> ds = new ArrayList<>();

        backtrack(ans,ds,map,0,nums);

        return ans;
    }
}