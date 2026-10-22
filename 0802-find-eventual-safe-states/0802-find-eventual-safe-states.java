class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] s = new int[n];
        List<Integer> ls = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(s[i] == 0){
                dfs(graph, i, s);
            }
        }


        for(int i = 0; i<n; i++){
            if(s[i] == 2)ls.add(i);
        }

        return ls;
    }

    private boolean dfs(int[][] graph, int node, int[] s){
        s[node] = 1;
        for(int e : graph[node]){
            if(s[e] == 0){
                if(!dfs(graph, e, s))return false;
            }
            else if(s[e] == 1)return false;
        }
        s[node] = 2;
        return true;
    }

}