class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            int minCol = findMinCol(matrix, i);
            int num = matrix[i][minCol];

            if(isMaxInCol(matrix, num, minCol)){
                result.add(num);
            }
        }
        return result;
    }

    private int findMinCol(int[][] matrix, int row){
        int minVal = matrix[row][0], minCol = 0;
        for(int j = 1; j < matrix[row].length; j++){
            if(matrix[row][j] < minVal){
                minVal = matrix[row][j];
                minCol = j;
            }
        }
        return minCol;
    }

    private boolean isMaxInCol(int[][] matrix, int val, int col){
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] > val) return false;
        }
        return true;
    }
}
