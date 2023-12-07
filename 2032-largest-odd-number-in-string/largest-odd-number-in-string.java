class Solution {
    public String largestOddNumber(String num) {
        int max = -1;
        for(int i=num.length()-1;i>=0;i--){
          int digit=num.charAt(i)-'0';
          if(digit%2!=0){
            max=i;
            break;
          }
        }
        return (max==-1)?"":num.substring(0,max+1);
    }
}