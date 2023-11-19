class Solution {
    public int reductionOperations(int[] nums) {
        int ops=0, res=0;
        int[] freq = new int[50001];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }
        for(int i = 50000; i >= 1; i--){
            if(freq[i] > 0){
                ops+=freq[i];
                res+=ops-freq[i];
            }
        }
        return res;
    }
}