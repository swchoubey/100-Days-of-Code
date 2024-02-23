class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int[] f : flights){
            adj.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new int[] {f[1], f[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int stops = 0;

        while(!q.isEmpty() && stops <= k){
            int s = q.size();
            while(s-- > 0){
                int[] curr = q.poll();
                int node = curr[0];
                int distance = curr[1];

                if(!adj.containsKey(node)) continue;

                for(int[] next : adj.get(node)){
                    int neighbor = next[0];
                    int price = next[1];
                    if (price + distance >= dist[neighbor]) continue;
                    dist[neighbor] = price + distance;
                    q.offer(new int[] {neighbor, dist[neighbor]});
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
}