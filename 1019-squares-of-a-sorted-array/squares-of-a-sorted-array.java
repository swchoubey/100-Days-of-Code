class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;
        int[] res = new int[n];
        for(int i = n-1; i >= 0; i--){
            if(Math.abs(nums[s]) >= Math.abs(nums[e])){
                res[i] = nums[s] * nums[s];
                s++;
            }
            else{
                res[i] = nums[e] * nums[e];
                e--;
            }
        }
        return res;
    }
}