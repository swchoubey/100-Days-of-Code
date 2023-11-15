class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int[] counter = new int[arr.length];
        int n = arr.length;
        for(int i=0;i<n;i++){
            ++counter[Math.min(arr[i]-1, n-1)];
        }
        int res=1;
        for(int i=1;i<n;i++){
            res=Math.min(i+1,res+counter[i]);
        }
        return res;
    }
}