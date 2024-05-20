class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }
    public int dfs(int[] nums, int i, int curr){
        if(i == nums.length) return curr;
        int inc = dfs(nums, i + 1, curr ^ nums[i]);
        int exc = dfs(nums, i + 1, curr);

        return inc + exc;
    }
}