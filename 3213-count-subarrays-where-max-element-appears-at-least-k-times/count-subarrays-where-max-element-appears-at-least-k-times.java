class Solution {
    public long countSubarrays(int[] nums, int k) {
       long max = Long.MIN_VALUE, count = 0, left = 0, right = 0, ans = 0;

       for(int n : nums) {
        max = Math.max(max, n);
       }

       while(right < nums.length || left > right){
        if(nums[(int) right] == max) count++;

        while(count >= k){
            if(nums[(int) left] == max) count--;

            left++;
            ans += nums.length - right;
        }
        right++;
       }

       return ans;
    }
}