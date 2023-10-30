class Solution {
    public int countBits(int n){
        int count=0;
        while(n>0){
            count+= n&1;
            n>>=1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        Integer[] intArr = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            intArr[i]=arr[i];
        }
        Arrays.sort(intArr, (a,b)->{
            int countA = countBits(a);
            int countB = countBits(b);

            if(countA != countB){
                return countA-countB;
            }
            else{
                return a-b;
            }
        });
        for(int i=0;i<arr.length;i++){
            arr[i]=intArr[i];
        }

        return arr;
    }
}