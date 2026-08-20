class Solution {
    public boolean backtrack(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return backtrack(root.left, targetSum - root.val) ||
               backtrack(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backtrack(root, targetSum);
    }
}