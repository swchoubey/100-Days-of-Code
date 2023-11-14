class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        //Set<Character> set = new HashSet<>();
        for(char c = 'a'; c <= 'z'; c++){
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);

            if(first != -1 && last != -1 && first < last){
                Set<Character> set = new HashSet<>();
                for(int i = first+1; i<last; i++){
                    set.add(s.charAt(i));
                }
                res += set.size();
            }
        }
        return res;
    }
}