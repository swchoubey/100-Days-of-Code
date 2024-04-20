class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1){
                    int[] coords = farmCoords(land, i , j);
                    res.add(coords);
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }
    private int[] farmCoords(int[][] land, int row, int col){
        int[] coords = new int[4];

        coords[0] = row;
        coords[1] = col;

        int m = land.length;
        int n = land[0].length;

        int r = row;
        int c = col;

        while(r < m && land[r][col] == 1) r++;
        while(c < n && land[row][c] == 1) c++;

        coords[2] = r-1;
        coords[3] = c-1;

        for(int i = row; i < r; i++){
            for(int j = col; j < c; j++){
                land[i][j] = 0;
            }
        }

        return coords;
    }
}