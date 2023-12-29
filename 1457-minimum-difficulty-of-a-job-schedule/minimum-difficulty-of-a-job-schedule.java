class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d){
            return -1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=jobDifficulty[i];
        }
        if(sum==0){
            return 0;
        }
        int[][] memo = new int[d+1][n];
        helper(jobDifficulty, d, 0, memo);

        return memo[d][0];
    }
    private void helper(int[] jd, int dys, int index, int[][] memo){
        int n = jd.length;
        if(memo[dys][index]!=0){
            return;
        }
        if(dys==1){
            int num = 0;
            for(int i = index;i<n;i++){
                num=Math.max(num,jd[i]);
            }
            memo[dys][index] = num;
            return;
        }
        int max = jd[index];
        dys--;
        int stop = n-index-dys+1;
        int result=Integer.MAX_VALUE;
        for(int i=1;i<stop;i++){
            max=Math.max(max, jd[index+i-1]);
            int rep = memo[dys][index+i];
            if(rep==0){
                helper(jd, dys, index+i, memo);
                rep = memo[dys][index+i];
            }
            result=Math.min(result, rep+max);
        }
        memo[dys+1][index]=result;
    }
}