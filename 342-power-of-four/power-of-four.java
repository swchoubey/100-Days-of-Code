class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1)
            return true;
        if(n%4!=0)
            return false;
        double x=Math.log(n)/Math.log(4);
        if((x*10)%10==0)
            return true;
            
        return false;
    }
}