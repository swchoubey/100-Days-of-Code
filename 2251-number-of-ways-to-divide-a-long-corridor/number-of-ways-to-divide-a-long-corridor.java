class Solution {
    public int numberOfWays(String corridor) {
        char[] arr=corridor.toCharArray();
        int ch=0;
        long ways =1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='S'){
                ch++;
                while(++i<arr.length && arr[i]!='S');
                if(i<arr.length && arr[i]=='S'){
                    ch++;
                }
                int division=1;
                while(++i<arr.length && arr[i]!='S'){
                    division++;
                }
                if(division>1 && i<arr.length){
                    ways=(ways*division)%1000000007;
                }
                i--;
            }
        }
        return (ch!=0 && ch%2==0)?(int) ways:0;
    }
}