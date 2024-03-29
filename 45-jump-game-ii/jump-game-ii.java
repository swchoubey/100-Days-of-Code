class Solution {
    public int jump(int[] nums) {
        int count = 0, end = 0, farthest = 0;
        for(int i = 0; i < nums.length - 1; ++i){
            farthest = Math.max(farthest, i + nums[i]);
            if(farthest >= nums.length-1){
                ++count;
                break;
            }
            if(i == end){
                ++count;
                end = farthest;
            }
        }
        return count;
    }
}