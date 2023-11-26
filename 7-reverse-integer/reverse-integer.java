class Solution {
    public int reverse(int x) {
        int p=0,q=0;
        int sign=(x>0)?1:-1;
        x=Math.abs(x);
        while(x!=0){
            q=x%10;
            x=x/10;
            if(p>(Integer.MAX_VALUE - q)/10 || p<(Integer.MIN_VALUE+q)/10)
                return 0;
            p=p*10+q;
        }
        return p*sign;
    }
}