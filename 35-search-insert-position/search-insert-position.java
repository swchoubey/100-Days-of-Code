class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(target > nums[n-1])
            return n;
        if(target <= nums[n/2]){
            for(int i = 0; i <= n/2; i++){
                if(nums[i] < target){
                    continue;
                }
                else{
                    return i;
                }
            }
        }
        else{
            for(int i = n/2 + 1; i < n; i++){
                if(nums[i] < target){
                    continue;
                }
                else{
                    return i;
                }
            }
        }

        return 0;
    }
}