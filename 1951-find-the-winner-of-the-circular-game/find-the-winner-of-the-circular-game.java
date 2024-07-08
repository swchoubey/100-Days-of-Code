class Solution {
    public int findTheWinner(int n, int k) {
       return recur(n, k)  + 1;
    }
    private int recur(int n, int k){
        if(n == 1){
            return 0;
        }

        return (recur(n - 1, k) + k) % n;
    }
}