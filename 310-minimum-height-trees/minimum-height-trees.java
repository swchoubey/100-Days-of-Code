class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Collections.singletonList(0);
        }

        Map<Integer, List<Integer>> tree = new HashMap<>();
        int[] degrees = new int[n];

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            tree.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            tree.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

            degrees[u]++;
            degrees[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(degrees[i] == 1){
                q.offer(i);
            }
        }

        int rem = n;
        while(rem > 2){
            int size = q.size();
            rem -= size;

            for(int i = 0; i < size; i++){
                int leaf = q.poll();
                if(tree.containsKey(leaf)){
                    for(int neighbor : tree.get(leaf)){
                        degrees[neighbor]--;
                        if(degrees[neighbor] == 1){
                            q.offer(neighbor);
                        }
                    }
                    tree.remove(leaf);
                }
            }
        }
        return new ArrayList<>(q);
    }
}