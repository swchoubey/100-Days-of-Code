class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length + 1];
        int maxArea = 0;

        for(char[] row : matrix){
            for(int i = 0; i < matrix[0].length; i++){
                height[i] = (row[i] == '1')? height[i] + 1 : 0;
            }

        int n = height.length;

        for(int i = 0; i < n; i++){
            for(int j = i, minHeight = Integer.MAX_VALUE; j < n; j++){
                minHeight = Math.min(minHeight, height[j]);
                int area = minHeight * (j-i+1);
                maxArea = Math.max(maxArea, area);
            }
        }
        }
        return maxArea;

    }
}