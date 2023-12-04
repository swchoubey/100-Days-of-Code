class Solution {
    public String largestGoodInteger(String num) {
        int val=-1;
        for(int i=0; i<num.length()-2;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)){
                val = Math.max(val, num.charAt(i)-'0');
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<3;i++){
            res.append((char) (48+val));
        }

        return (val==-1)?"":res.toString();
    }
}