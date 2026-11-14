
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();

        if(n == 1) {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Calculate degree
        int[] degree = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            degree[i] = adj.get(i).size();

            if(degree[i] == 1) {
                q.add(i);
            }
        }

        int remaining = n;

        // Remove leaves level by level
        while(remaining > 2) {

            int size = q.size();

            remaining -= size;

            for(int i = 0; i < size; i++) {

                int node = q.poll();

                for(int neighbor : adj.get(node)) {

                    degree[neighbor]--;

                    if(degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }

        // Remaining nodes are the answer
        while(!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }
}
