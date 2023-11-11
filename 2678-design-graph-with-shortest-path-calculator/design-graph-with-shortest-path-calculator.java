class Graph {
    private List<List<int[]>> adjacencyList;
    public Graph(int n, int[][] edges) {
       adjacencyList = new ArrayList<>();
       for(int i = 0; i < n; i++) {
           adjacencyList.add(new ArrayList<>());
       }
       for(int[] edge : edges){
           addEdge(edge);
       }
    }
    
    public void addEdge(int[] edge) {
        int[] edgeArr = {edge[1], edge[2]};
        adjacencyList.get(edge[0]).add(edgeArr);
    }
    
    public int shortestPath(int node1, int node2) {
        return dijkstra(node1, node2);
    }

    private int dijkstra(int start, int end){
        int n = adjacencyList.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, start});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[1];
            int currCost = curr[0];
            if(currCost > dist[currNode]){
                continue; //skips as shorter path has been found
            }
            if(currNode == end){
                return currCost;
            }
            for(int[] edge : adjacencyList.get(currNode)){
                int neighbor = edge[0], edgeLen = edge[1];
                int newRouteCost = edgeLen + dist[currNode];

                if(dist[neighbor] > newRouteCost){
                    dist[neighbor] = newRouteCost;
                    pq.add(new int[]{newRouteCost, neighbor});
                }
            }
        }
        return ((dist[end] == Integer.MAX_VALUE) ? -1 : dist[end]);
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */