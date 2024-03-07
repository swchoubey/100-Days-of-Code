class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        int n = needle.length();
        for(int i = 0; i <= haystack.length() - n; i++){
            int j = 0;
            while(j < n && haystack.charAt(i + j) == needle.charAt(j)) j++;
            if(j == n){
                return i;
            }
        }
        return -1;
    }
}