class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder("#");
        for(char c : s.toCharArray()){
            sb.append(c).append("#");
        }
        len = sb.length();
        int[] dp = new int[len];
        int mid = 0, right = 0, count = 0;
        for(int i = 0; i < len; i++){
            int mirror = 2*mid - i;
            if(i < right){
                dp[i] = Math.min(right-i, dp[mirror]);
            }
            int a = i + (1 + dp[i]);
            int b = i - (1 + dp[i]);
            while(a < len && b >=0 && sb.charAt(a)==sb.charAt(b)){
                dp[i]++;
                a++;
                b--;
            }
            if(i + dp[i] > right){
                mid = i;
                right = i + dp[i];
            }
            count += (dp[i]+1)/2;
        }
        return count;
    }
}