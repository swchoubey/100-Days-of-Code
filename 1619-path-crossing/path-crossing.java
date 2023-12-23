class Solution {
    public boolean isPathCrossing(String path) {
        Map<Character, Pair<Integer, Integer>> move = new HashMap<>();
        move.put('N', new Pair(0,1));
        move.put('E', new Pair(1,0));
        move.put('W', new Pair(-1,0));
        move.put('S', new Pair(0,-1));
        Set<Pair<Integer,Integer>> visited = new HashSet();
        visited.add(new Pair(0,0));
        int x=0;
        int y=0;
        for(Character c : path.toCharArray()){
            Pair<Integer, Integer> current = move.get(c);
            int x1=current.getKey();
            int y1=current.getValue();
            x+=x1;
            y+=y1;
            Pair<Integer, Integer> pair = new Pair(x,y);
            if(visited.contains(pair)){
                return true;
            }
            visited.add(pair);
        }
        return false;
    }
}