class Solution {
    public int lengthOfLastWord(String s) {
        int n = 0;
        for(int i = s.length() - 1; i >=0; i--){
            if(s.charAt(i) == ' '){
                if(n > 0)
                    break;
            }
            else {
                n++;
            }
        }
       return n; 
    }
}