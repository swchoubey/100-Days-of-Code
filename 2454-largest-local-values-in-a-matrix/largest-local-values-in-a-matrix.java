class Solution {
    public int helper(int[][] grid, int x, int y){
        int max = 0;

        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length - 2;
        int[][] res = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = helper(grid, i, j);
            }
        }

        return res;
    }
}