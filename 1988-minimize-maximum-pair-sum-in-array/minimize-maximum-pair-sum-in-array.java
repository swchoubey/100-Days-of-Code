class Solution {
    public int minPairSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int[] hash = new int[100001];
        for(int n: nums){
            hash[n]++;
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        int high=max;
        int low=min;
        max=Integer.MIN_VALUE;
        while(low<=high){
            if(hash[low]==0) 
                low++;
            else if(hash[high]==0)
                high--;
            else{
                max=Math.max(max,low+high);
                hash[low]--;
                hash[high]--;
            }

        }
        return max;
    }
}