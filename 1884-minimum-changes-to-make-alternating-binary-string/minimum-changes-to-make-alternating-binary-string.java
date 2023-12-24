class Solution {
    public int minOperations(String s) {
        char charAt0 = s.charAt(0);
        int count_og = count(s, charAt0);
        int count_md = count(s, charAt0=='0'?'1':'0')+1;

        return Math.min(count_og, count_md);
    }
    public int count(String s, char c){
        int ops = 0;
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr==c){
                ops++;
                c = c=='0'?'1':'0';
            }
            else{
                c = curr;
            }
        }
        return ops;
    }
}