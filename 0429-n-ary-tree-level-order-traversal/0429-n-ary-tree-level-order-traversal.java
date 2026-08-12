class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> ls = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                ls.add(curr.val);

                if (curr.children != null) {
                    for (Node ele : curr.children) {
                        q.offer(ele);
                    }
                }
            }

            ans.add(ls);
        }

        return ans;
    }
}