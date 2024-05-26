class Solution {
    private static final int MOD = 1000000007;

    private int helper(int i, int ca, int cl, int n, int[][][] temp){
        if(i == n) return 1;

        if(temp[i][ca][cl] != -1){
            return temp[i][ca][cl];
        }

        int a = (ca == 0)? helper(i+1, ca+1, 0, n, temp) : 0;
        int l = (cl == 2)? 0 : helper(i+1, ca, cl+1, n, temp);
        int p = helper(i+1, ca, 0, n, temp);
        int total = ((a + l) % MOD + p) % MOD;

        temp[i][ca][cl] = total;

        return total;
    }
    public int checkRecord(int n) {
        int[][][] temp = new int[n][2][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++){
                    temp[i][j][k] = -1;
                }
            }
        }

        return helper(0, 0, 0, n, temp);
    }
}