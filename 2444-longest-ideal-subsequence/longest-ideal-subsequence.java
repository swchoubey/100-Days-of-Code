class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[27];
        
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            int ind = c - 'a';
            int max = Integer.MIN_VALUE;

            int l = Math.max((ind - k), 0);
            int r = Math.min((ind + k), 26);

            for(int j = l; j <= r; j++){
                max = Math.max(max, dp[j]);
            }

            dp[ind] = max + 1;
        }

        int max = Integer.MIN_VALUE;

        for(int e : dp){
            max = Math.max(e, max);
        }

        return max;
    }
}