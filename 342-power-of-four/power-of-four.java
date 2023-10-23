class Solution {
    public boolean isPowerOfFour(int n) {
        //Original solution
       /* if(n==1)
            return true;
        if(n<=0)
            return false;
        double x=Math.log(n)/Math.log(4);

        return (x==(int)x);*/
        return((n>0) && ((n&(n-1))==0) && (n%3==1));
    }
}