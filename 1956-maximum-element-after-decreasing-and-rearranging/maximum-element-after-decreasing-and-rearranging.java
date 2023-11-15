class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]!=1){
            arr[0]=1;
        }
        //bool flag=true;
        for(int i=0;i<arr.length-1;i++){
            
            if(!((Math.abs(arr[i]-arr[i+1]))<=1)){
                //flag=true;
                arr[i+1]=arr[i]+1;
            }
            
        }
        return arr[arr.length-1];
    }
}