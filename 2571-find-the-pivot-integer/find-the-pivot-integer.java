class Solution {
    public int pivotInteger(int n) {
        double x = Math.sqrt(n * (n+1)/2);
        if(x % 1 != 0)
            return -1;
        else
            return (int) x;
    }
}