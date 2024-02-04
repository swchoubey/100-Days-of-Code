class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s == null || t==null || t.length() > s.length()){
            return "";
        }
        int count = t.length();
        int[] map = new int[128];
        int st = 0, e = 0, minLen = Integer.MAX_VALUE, si = 0;
        for(char c : t.toCharArray()){
            map[c]++;
        }
        char[] s_arr = s.toCharArray();
        while(e < s_arr.length){
            if(map[s_arr[e++]]-- > 0){
                count--;
            }
            while(count == 0){
                if(e-st < minLen){
                    si = st;
                    minLen = e-st;
                }
                if(map[s_arr[st++]]++ == 0){
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : new String(s_arr, si, minLen);
    }
}