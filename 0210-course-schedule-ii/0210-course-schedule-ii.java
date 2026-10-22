class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : prerequisites){
            int v = i[0];
            int u = i[1];
            
            adj.get(v).add(u);
        }

        int[] v = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<numCourses; i++){
            if(v[i] == 0){
                if(dfs(adj, i, v, st))return new int[]{};
            }
        }

        int[] res = new int[numCourses];
        int i = 0;
        for(int el : st){
            res[i++] = el;
        }

        return res;
    }

    private boolean dfs(List<List<Integer>> adj, int node, int[] v, Stack<Integer> st){
        v[node] = 1;

        for(int ne : adj.get(node)){
            if(v[ne] == 1){
                return true;
            }
            else if(v[ne] == 0){
                if(dfs(adj, ne, v, st))return true;
            }
        }
        v[node] = 2;
        st.push(node);
        return false;
    }
}