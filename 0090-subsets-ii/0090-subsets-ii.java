class Solution {
    public void printS(int ind, int n, List<List<Integer>>ans, int[]nums, List<Integer>ds){

        ans.add(new ArrayList<>(ds));
   
    

    for(int i = ind; i<n; i++){
        if(i>ind && nums[i] == nums[i-1])continue;
        ds.add(nums[i]);
        printS(i+1, n, ans, nums, ds);
        ds.remove(ds.size()-1);
    }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        printS(0,nums.length,ans, nums, new ArrayList<>());
        return ans;
    }
}