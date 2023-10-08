class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int[][] dp=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j]=Integer.MIN_VALUE;
                else
                    dp[i][j]=Math.max(nums1[i-1]*nums2[j-1]+Math.max(dp[i-1][j-1],0), Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
}