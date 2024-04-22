class Solution {
    public int openLock(String[] deadends, String target) {
        int[] pow10 = {1, 10, 100, 1000};
        int[] visit = new int[10000];

        for(String d : deadends){
            visit[Integer.parseInt(d)] = 2;
        }

        int src = 0, dst = Integer.parseInt(target), steps = 0, dir = 1;

        if(visit[src] == 2 || visit[dst] == 2) return -1;

        if(src == dst) return 0;

        Queue<Integer> fwd = new LinkedList<>(), bwd = new LinkedList<>();

        fwd.add(src);
        visit[src] = 1;

        bwd.add(dst);
        visit[dst] = -1;

        while(!fwd.isEmpty() && !bwd.isEmpty()){
            if(fwd.size() > bwd.size()){
                Queue<Integer> temp = fwd;
                fwd = bwd;
                bwd = temp;
                dir = -dir;
            }
            steps++;

            int size = fwd.size();
            while(size-- > 0){
                int curr = fwd.poll();
                for(int p : pow10){
                    int d = (curr/p) % 10;
                    for(int i = -1; i <= 1; i +=2){
                        int z = d + i;
                        z = z == -1 ? 9 : (z == 10 ? 0 : z);
                        int next = curr + (z - d) * p;
                        if(visit[next] == -dir) return steps;
                        if(visit[next] == 0){
                            fwd.add(next);
                            visit[next] = dir;
                        }
                    }
                }
            }
        }
        return -1;
    }
}