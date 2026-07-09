class Solution {
    public void printS( List<List<Integer>> ans, List<Integer> ds, int[] nums, int n, int i){
        if(i == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        printS(ans,ds,nums,n,i+1);
        ds.remove(ds.size()-1);
        printS(ans,ds,nums,n,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        printS(ans, ds, nums, n, i);
        return ans;
    }
}