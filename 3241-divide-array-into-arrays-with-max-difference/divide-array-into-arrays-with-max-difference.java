class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] res = new int[n/3][3];
        int rows = 0;
        for(int i = 0; i < n; i+=3){
            if(i+2 < n && nums[i+2]-nums[i] <= k){
                res[rows][0] = nums[i];
                res[rows][1] = nums[i+1];
                res[rows][2] = nums[i+2];
                rows++;
            }
            else{
                return new int[0][0];
            }
        }
        return res;
    }
}