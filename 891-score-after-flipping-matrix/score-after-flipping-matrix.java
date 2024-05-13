class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = (1 << (m - 1)) * n;

        for(int i = 1; i < m; ++i){
            int val = 1 << (m - 1 - i);
            int set = 0;

            for(int j = 0; j < n; ++j){
                if(grid[j][i] == grid[j][0]){
                    set++;
                }
            }

            res += Math.max(set, n - set) * val;
        }

        return res;
    }
}