
class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : times) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(v, wt));
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[k] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.wt - b.wt);

        pq.add(new Pair(k, 0));

        while(!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int wt = curr.wt;

            if(wt > dis[node]) continue;

            for(Pair p : adj.get(node)) {

                int ne = p.node;
                int edgeWt = p.wt;

                if(dis[node] + edgeWt < dis[ne]) {

                    dis[ne] = dis[node] + edgeWt;

                    pq.add(new Pair(ne, dis[ne]));
                }
            }
        }

        int max = 0;

        for(int i = 1; i <= n; i++) {

            if(dis[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dis[i]);
        }

        return max;
    }
}
