class Solution {
    public int appendCharacters(String s, String t) {
        int si = 0, ti = 0;
        while(si < s.length() && ti < t.length()){
            if(s.charAt(si) == t.charAt(ti)){
                ti++;
            }
            si++;
        }

        return t.length() - ti;
    }
}