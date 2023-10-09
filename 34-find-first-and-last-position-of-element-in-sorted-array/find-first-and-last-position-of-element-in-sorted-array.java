class Solution {
    private int findLeftIndex(int[] nums, int target){
        int left=0, right=nums.length-1, left_index=-1;
        while(left<=right){
            int mid=left + (right-left)/2;
            if(nums[mid]==target){
            left_index=mid;
            right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        
        return left_index;
    }
    private int findRightIndex(int[] nums, int target){
        int left=0, right=nums.length-1, right_index=-1;
        while(left<=right){
            int mid=left + (right-left)/2;
            if(nums[mid]==target){
                right_index=mid;
                left=mid+1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        
        return right_index;
    }
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length==0)
            return new int[]{-1,-1};

        int left_index=findLeftIndex(nums, target);
        int right_index=findRightIndex(nums,target);
        if(left_index<=right_index)
            return new int[]{left_index,right_index};
        else
            return new int[]{-1,-1};
    }
}