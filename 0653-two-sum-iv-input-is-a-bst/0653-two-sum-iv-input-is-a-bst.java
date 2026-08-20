class Solution {
    public void inorder(TreeNode root, List<Integer> in) {
        if (root == null) return;

        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> in = new ArrayList<>();
        inorder(root, in);

        int i = 0;
        int j = in.size() - 1;

        while (i < j) {
            int sum = in.get(i) + in.get(j);

            if (sum == k) return true;

            if (sum > k)
                j--;
            else
                i++;
        }

        return false;
    }
}