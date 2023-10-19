class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
            for(int[] relation:relations){
                int prevCourse=relation[0]-1;
                int nextCourse=relation[1]-1;
                graph.get(nextCourse).add(prevCourse);
            }
        
        int[] dp=new int[n];
        int minTime=0;
        for(int i=0;i<n;i++){
            minTime=Math.max(minTime, getTime(i,graph,dp,time));
        }
        return minTime;
    }
    private int getTime(int i, List<List<Integer>> graph, int[] dp, int[] time){
        if(dp[i]!=0){
            return dp[i];
        }
        int maxPrereq=0;
        for(int p:graph.get(i)){
            maxPrereq=Math.max(maxPrereq, getTime(p,graph,dp,time));
        }
        dp[i]=maxPrereq+time[i];

        return dp[i];
    }
}