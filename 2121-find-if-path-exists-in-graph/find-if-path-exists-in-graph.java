class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(source, destination, map, visited);
    }

    public boolean dfs(int s, int d, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(s == d) return true;
        visited.add(s);
        for(int neighbor : map.getOrDefault(s, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                if(dfs(neighbor, d, map, visited)) return true;
            }
        }
        return false;
    }
}