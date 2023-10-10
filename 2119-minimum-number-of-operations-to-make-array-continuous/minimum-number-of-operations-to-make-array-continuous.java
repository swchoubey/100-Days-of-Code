class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int uniqueLength=1;
        for(int i=1;i<n;++i){
            if(nums[i]!=nums[i-1]){
                nums[uniqueLength++]=nums[i];
            }
        }
        int minOps=n;
        for(int i=0,j=0;i<uniqueLength;++i){
            while(j<uniqueLength && nums[j]-nums[i]<=nums.length-1){
                ++j;
            }
            minOps=Math.min(minOps,n-(j-i));
        }
        return minOps;
    }
}