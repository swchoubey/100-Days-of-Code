class Solution {
    public static boolean isPrime(int n){
        if(n<=1)
            return false;
        if(n<=3)
            return true;
        if(n%2==0 || n%3==0)
            return false;
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0)
                return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int l=nums.length;
        int maxp=0;
        for(int i=0;i<l;i++){
            if(isPrime(nums[i][i])){
                maxp=Math.max(maxp, nums[i][i]);
            }
            if(isPrime(nums[i][l-1-i])){
                maxp=Math.max(maxp, nums[i][l-1-i]);
            }
        }
        return maxp;      
    }
}