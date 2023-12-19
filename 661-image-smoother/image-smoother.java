class Solution {
    public int[][] imageSmoother(int[][] img) {
        if(img == null || img[0].length == 0 || img.length == 0){
            return new int[0][0];
        }
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[i][j] = getSmoothed(img,i,j,rows,cols);
            }
        }
        return result;
    }
    public int getSmoothed(int[][] img, int row, int col, int rows, int cols){
        int sum=0, count=0;
        for(int i=row-1;i<=row+1;i++){
            for(int j=col-1;j<=col+1;j++){
                if(i>=0 && i<rows && j>=0 && j<cols){
                    sum+=img[i][j];
                    count++;
                }
            }
        }
        return sum/count;
    }
}