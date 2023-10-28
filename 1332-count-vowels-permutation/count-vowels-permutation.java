class Solution {
    public int countVowelPermutation(int n) {
        final int mod = 1000000007;
        long cA=1, cE=1, cI=1, cO=1, cU=1;
        for(int i=1; i<n; i++){
            long nextA=cE;
            long nextE=(cA+cI)%mod;
            long nextI=(cA+cE+cO+cU)%mod;
            long nextO=(cI+cU)%mod;
            long nextU=(cA)%mod;

            cA=nextA;
            cE=nextE;
            cI=nextI;
            cO=nextO;
            cU=nextU;
        }
        long count = (cA+cE+cI+cU+cO)%mod;

        return (int) count;
    }
}