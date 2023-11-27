class Solution {
    static final int[][] NUMPAD = {
        {4,6}, {6,8}, {7,9}, {4,8}, {0,3,9}, {}, {0,1,7}, {2,6}, {1,3}, {2,4}
    };
    static final int[][] cache = new int[5001][10];
    public int knightDialer(int n) {
        return knightDialer(n, new int[]{0,1,2,3,4,5,6,7,8,9});
        
    }
    int knightDialer(int n, int[] next){
        if(n==1){
            return next.length;
        }
        int count=0;
        for(int num:next){
            int curr = cache[n][num];
            if(curr==0){
                curr=knightDialer(n-1, NUMPAD[num]);
                cache[n][num]=curr;
            }
            count+=curr;
            count%=1000000007;
        }
        return count;
    }
}