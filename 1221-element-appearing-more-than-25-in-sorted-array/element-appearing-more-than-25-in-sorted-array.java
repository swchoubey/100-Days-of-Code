class Solution {
    public int findSpecialInteger(int[] arr) {
        int count=1, flag=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] == flag){
                count++;
            }
            else{
                count=1;
            }
            if(count > (arr.length/4)){
                return arr[i];
            }
            flag = arr[i];
        }
        return flag;
    }
}