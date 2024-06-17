class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = 2; i * i <= c; i++){
            if(c % i == 0){
                int exp = 0;
                while(c % i == 0){
                    exp++;
                    c /= i;
                }
                if(i % 4 == 3 && exp % 2 != 0){
                    return false;
                }
            }
        }
        return c % 4 != 3;
    }
}