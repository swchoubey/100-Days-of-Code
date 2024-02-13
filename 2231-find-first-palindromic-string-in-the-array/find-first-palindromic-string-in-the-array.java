class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            StringBuilder sb = new StringBuilder(s).reverse();
            if(s.equals(sb.toString())){
                return s;
            }
        }
        return "";
    }
}