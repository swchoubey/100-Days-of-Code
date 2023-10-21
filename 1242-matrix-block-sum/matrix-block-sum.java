class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] prefixSum=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                prefixSum[i][j]=mat[i-1][j-1]+prefixSum[i-1][j]+prefixSum[i][j-1]-prefixSum[i-1][j-1];
            }
        }
        int[][] answer = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1=Math.max(0, i-k);
                int c1=Math.max(0, j-k);
                int r2=Math.min(m,i+1+k);
                int c2=Math.min(n,j+1+k);
                answer[i][j]=prefixSum[r1][c1]+prefixSum[r2][c2]-prefixSum[r1][c2]-prefixSum[r2][c1];
            }
        }
        return answer;
    }
}