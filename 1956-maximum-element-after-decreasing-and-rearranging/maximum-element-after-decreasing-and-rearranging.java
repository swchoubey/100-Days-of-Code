class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int[] counter = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ++counter[Math.min(arr[i]-1, arr.length-1)];
        }
        int res=1;
        for(int i=1;i<arr.length;i++){
            res=Math.min(i+1,res+counter[i]);
        }
        return res;
    }
}