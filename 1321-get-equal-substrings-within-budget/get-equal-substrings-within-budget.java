class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int st = 0, cost = 0, max = 0;

        for(int i = 0; i < s.length(); ++i){
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            while(cost > maxCost){
                cost -= Math.abs(s.charAt(st) - t.charAt(st));
                ++st;
            }
            max = Math.max(max, i - st + 1);
        }
        return max;
    }
}