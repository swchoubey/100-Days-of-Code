class Solution {
    public String maximumOddBinaryNumber(String s) {
        int c1 = 0, c0 = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '1')
                c1++;
            else
                c0++;
        }
        sb.append("1".repeat(c1 - 1));
        sb.append("0".repeat(c0));
        sb.append("1");

        return sb.toString();
    }
}