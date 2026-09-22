// bfs solution --->

// import java.util.*;

// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int[] v = new int[graph.length];
//         Arrays.fill(v, -1);

//         for (int i = 0; i < v.length; i++) {
//             if (v[i] == -1) {
//                 if (bfs(graph, v, i)) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }

//     public boolean bfs(int[][] graph, int[] v, int node) {
//         Queue<int[]> q = new LinkedList<>();

//         q.offer(new int[]{node, 0});
//         v[node] = 0;

//         while (!q.isEmpty()) {
//             int[] p = q.poll();

//             int n = p[0];
//             int c = p[1];

//             for (int ne : graph[n]) {

               
//                 if (v[ne] == -1) {
//                     v[ne] = 1 - c;
//                     q.offer(new int[]{ne, v[ne]});
//                 }

//                 else if (v[ne] == c) {
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }
import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] v = new int[n];

        Arrays.fill(v,-1);

        for(int i = 0; i<n; i++){
            if(v[i] == -1){
                v[i] = 0;
                if(dfs(graph, v, i, v[i]))return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int[] v, int node, int c){
        for(int ne : graph[node]){
            if(v[ne] == -1){
                v[ne] = 1-c;
                if(dfs(graph, v, ne, v[ne]))return true;
            }
            else if(v[ne] == c)return true;
        }

        return false;
    }
}