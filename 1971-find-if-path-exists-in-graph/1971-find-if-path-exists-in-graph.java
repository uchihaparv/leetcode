import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

      
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(adj, destination, visited, source);
    }

    private boolean dfs(List<List<Integer>> adj,
                        int destination,
                        boolean[] visited,
                        int node) {

        if (node == destination) {
            return true;
        }

        visited[node] = true;

        for (int ne : adj.get(node)) {

            if (!visited[ne]) {
                if (dfs(adj, destination, visited, ne)) {
                    return true;
                }
            }
        }

        return false;
    }
}