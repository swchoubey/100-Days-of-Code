class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] t = new int[nums.length];
        int s = 0;
        for(int n : nums){
            int i = 0, j = s;
            while(i != j){
                int m = (i+j)/2;
                if(t[m] < n){
                    i = m + 1;
                }
                else{
                    j = m;
                }
            }
                t[i] = n;
                if(i == s){
                    ++s;
                }
        }
        return s;
    }
}