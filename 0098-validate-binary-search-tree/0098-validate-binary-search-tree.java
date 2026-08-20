class Solution {
    public void inorder(TreeNode root, List<Integer> in) {
        if (root == null) {
            return;
        }

        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> in = new ArrayList<>();

        inorder(root, in);

        for (int i = 1; i < in.size(); i++) {
            if (in.get(i) <= in.get(i - 1)) {
                return false;
            }
        }

        return true;
    }
}