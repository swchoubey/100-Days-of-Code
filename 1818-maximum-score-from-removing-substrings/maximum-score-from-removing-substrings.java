class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        String top, bot;
        int tops, bots;

        if(y > x){
            top = "ba";
            tops = y;
            bot = "ab";
            bots = x;
        }
        else{
            top = "ab";
            tops = x;
            bot = "ba";
            bots = y;
        }

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == top.charAt(1) && sb.length() > 0 && sb.charAt(sb.length() - 1) == top.charAt(0)){
                res += tops;
                sb.setLength(sb.length() - 1);
            }
            else{
                sb.append(c);
            }
        }

        StringBuilder st = new StringBuilder();
        for(char c : sb.toString().toCharArray()){
            if(c == bot.charAt(1) && st.length() > 0 && st.charAt(st.length() - 1) == bot.charAt(0)){
                res += bots;
                st.setLength(st.length() - 1);
            }
            else{
                st.append(c);
            }
        }
        return res;
    }
}