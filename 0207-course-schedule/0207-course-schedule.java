class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

    
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }


        for(int[] e : prerequisites){
            int v = e[0];
            int u = e[1];

            adj.get(v).add(u);
        }

        int[] state = new int[numCourses];

        for(int i = 0; i < numCourses; i++){

            if(state[i] == 0){
                if(dfs(i, adj, state)){
                    return false;
                }
            }
        }

        return true; 
    }

    public boolean dfs(int node, List<List<Integer>> adj, int[] state){

        state[node] = 1; 

        for(int ne : adj.get(node)){

         
            if(state[ne] == 1){
                return true;
            }

            
            else if(state[ne] == 0){
                if(dfs(ne, adj, state)){
                    return true;
                }
            }
        }

        state[node] = 2; 

        return false;
    }
}