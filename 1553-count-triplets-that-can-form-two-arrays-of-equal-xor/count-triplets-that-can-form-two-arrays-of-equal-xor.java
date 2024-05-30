class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n + 1];

        for(int i = 0; i < n; i++){
            pre[i + 1] = pre[i] ^ arr[i];
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int k = i + 1; k < n; k++){
                if(pre[i] == pre[k + 1]){
                    count += (k - i);
                }
            }
        }
        return count;
    }
}