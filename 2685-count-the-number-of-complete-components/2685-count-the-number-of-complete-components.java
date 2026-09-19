class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){

            if(!visited[i]){

                int[] result = dfs(adj, i, visited);

                int vertices = result[0];
                int degreeSum = result[1];

                // Every edge is counted twice
                int edgesCount = degreeSum / 2;

                int requiredEdges = vertices * (vertices - 1) / 2;

                if(edgesCount == requiredEdges){
                    count++;
                }
            }
        }

        return count;
    }

    private int[] dfs(
        List<List<Integer>> adj,
        int node,
        boolean[] visited
    ){

        visited[node] = true;

        int vertices = 1;
        int degreeSum = adj.get(node).size();

        for(int neighbor : adj.get(node)){

            if(!visited[neighbor]){

                int[] result = dfs(adj, neighbor, visited);

                vertices += result[0];
                degreeSum += result[1];
            }
        }

        return new int[]{vertices, degreeSum};
    }
}