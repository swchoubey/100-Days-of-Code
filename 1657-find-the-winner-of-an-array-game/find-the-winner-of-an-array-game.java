class Solution {
    public int getWinner(int[] arr, int k) {
        int curr = arr[0];
        int wins = 0;
        for(int i=1;i<arr.length;++i){
            if(arr[i]>curr){
                curr=arr[i];
                wins=0;
            }
            if(++wins==k){
                break;
            }
        }
        return curr;
    }
}