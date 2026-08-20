class Solution {
    private void backtrack(TreeNode root, int targetSum,
                           List<List<Integer>> ans,
                           List<Integer> ds) {

        if (root == null)
            return;

      
        ds.add(root.val);

        
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ans.add(new ArrayList<>(ds));
            }
            ds.remove(ds.size() - 1);
            return;
        }

       
        backtrack(root.left, targetSum - root.val, ans, ds);
        backtrack(root.right, targetSum - root.val, ans, ds);

        
        ds.remove(ds.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        backtrack(root, targetSum, ans, ds);

        return ans;
    }
}