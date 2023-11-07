class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int count = 0;
        //time=dist/speed
        for(int i=0;i<n;i++){
            dist[i]=(int) Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(dist);
        for(int i=0;i<n;i++){
            if(count>=dist[i]){
                return count;
            }
            count++;
        }
        return n;
    }
}