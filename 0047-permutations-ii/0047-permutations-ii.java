class Solution {

    public void solve(List<List<Integer>> ans,
                      List<Integer> ds,
                      int[] nums,
                      boolean[] used) {

        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

           
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            ds.add(nums[i]);

            solve(ans, ds, nums, used);

            ds.remove(ds.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        solve(ans, ds, nums, used);

        return ans;
    }
}