class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

    
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(n == 1) {
            ans.add(0);
            return ans;
        }

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] d = new int[n];
        for(int i = 0; i<n; i++){
            d[i]=adj.get(i).size();
            if(d[i] == 1)q.offer(i);
        }

        int rem = n;

        while(rem > 2){
            int size = q.size();
            rem -= size;
            for(int i = 0; i<size; i++){
                int node = q.poll();

                for(int ne : adj.get(node)){
                    d[ne]--;
                    if(d[ne] == 1)q.offer(ne);
                }
            }
        }

        
        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;


    }
}