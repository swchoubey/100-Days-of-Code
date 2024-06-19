class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int s = 0, mod = (int)1e9;
        int res = -1;

        while(s <= mod){
            int mid = s + (mod - s)/2;
            int con = 0, buk = 0;

            for(int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    con++;
                    if(con >= k){
                        buk++;
                        con = 0;
                    }
                }
                else{
                    con = 0;
                }
            }
            if(buk >= m){
                res = mid;
                mod = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }

        return res;
    }
}