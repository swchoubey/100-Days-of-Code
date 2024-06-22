class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 1;

        int res = 0, temp = 0;

        for(int n : nums){
            temp += n & 1;

            if(temp - k >= 0){
                res += sum[temp - k];
            }
            sum[temp]++;
        }

        return res;
    }
}