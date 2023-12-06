class Solution {
    public int totalMoney(int n) {
      int w=n/7;
      int total = w*28;
      total+=(7*w*(w-1))/2;
      if(n%7!=0){
        int extra = n%7;
        int m = w+1;
        for(int i=0;i<extra;++i){
          total+=m;
          m+=1;
        }
      }
      return total;
    }
}