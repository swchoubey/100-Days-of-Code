class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        int modulo = 1000000007;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp,1);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    int otherFactor=arr[i]/arr[j];
                    if(map.containsKey(otherFactor)){
                        dp[i]=(dp[i]+dp[j]*dp[map.get(otherFactor)])%modulo;
                    }
                }
            }
        }
        long total = 0;
        for(long numOfTrees : dp){
            total = (total + numOfTrees)%modulo;
        }

        return (int)total;
    }
}