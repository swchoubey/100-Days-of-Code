class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int l=0,r=sum;
       int[] result = new int[nums.length] ;
       for(int i=0;i<nums.length;i++){
           int n=nums[i];
           r-=n;
           result[i]=n*i-l+r-n*(nums.length-i-1);
           l+=n;
       }
       return result;
    }
}