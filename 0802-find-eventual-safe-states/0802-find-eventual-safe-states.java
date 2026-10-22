
import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] s = new int[n];

        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, s)) {
                ls.add(i);
            }
        }

        return ls;
    }

    private boolean dfs(int[][] graph, int node, int[] s) {
        if (s[node] == 1) return false; // Cycle
        if (s[node] == 2) return true;  // Already safe
        if (s[node] == 3) return false; // Already unsafe

        s[node] = 1; // Currently visiting

        for (int e : graph[node]) {
            if (!dfs(graph, e, s)) {
                s[node] = 3; // Unsafe
                return false;
            }
        }

        s[node] = 2; // Safe
        return true;
    }
}
