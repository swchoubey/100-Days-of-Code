class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookies = s.length;
        if(cookies==0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        int ci = cookies-1;
        int gi = g.length-1;
        while(ci>=0 && gi>=0){
            if(s[ci]>=g[gi]){
                max++;
                ci--;
                gi--;
            }
            else{
                gi--;
            }
        }
        return max;
    }
}