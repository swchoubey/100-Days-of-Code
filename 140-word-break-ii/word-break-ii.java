class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, 0, set);
    }

    private List<String> helper(String s, int i, HashSet<String> set){
        List<String> res = new ArrayList<>();

        if(i == s.length()) res.add("");

        for(int j = i+1; j <= s.length(); j++){
            String pre = s.substring(i, j);
            if(set.contains(pre)){
                List<String> suff = helper(s, j, set);
                for(String su : suff){
                    res.add(pre + (su.equals("")?"":" ") + su);
                }
            }
        }
        return res;
    }
}