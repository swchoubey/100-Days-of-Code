class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(m == 1 || n == 1){
            return matrix[0][0];
        }

        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < m; ++i){
            ans = Math.min(ans, minFallingPath(matrix, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPath(int[][] matrix, int row, int col, int[][] dp){
        int m = matrix.length;
        int n = matrix[0].length;

        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }

        if(row == m-1){
            return dp[row][col] = matrix[row][col];
        }

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if(col > 0){
            left = minFallingPath(matrix, row+1, col-1, dp);
        }
        int straight = minFallingPath(matrix, row+1, col, dp);

        if(col < n-1){
            right = minFallingPath(matrix, row+1, col+1, dp);
        }

        dp[row][col] = Math.min(left, Math.min(straight, right)) + matrix[row][col];

        return dp[row][col];
    }
}