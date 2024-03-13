class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;

        while(i < j){
            if(height[j] <= height[i]){
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
            else{
                max = Math.max(max, height[i] * (j - i));
                i++;
            }
        }
        return max;
    }
}