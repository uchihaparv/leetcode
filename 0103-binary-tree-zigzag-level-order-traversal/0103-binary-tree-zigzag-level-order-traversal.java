class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean flag = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ls = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                ls.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            if (!flag) {
                Collections.reverse(ls);
            }

            ans.add(ls);
            flag = !flag;
        }

        return ans;
    }
}