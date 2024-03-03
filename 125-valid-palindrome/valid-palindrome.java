class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int st = 0, e = s.length()-1;
        while(st < e){
            int currF = s.charAt(st);
            int currL = s.charAt(e);

            if(!Character.isLetterOrDigit(currF))
                st++;
            else if(!Character.isLetterOrDigit(currL))
                e--;
            else{
                if(Character.toLowerCase(currF) != Character.toLowerCase(currL))
                    return false;
                st++;
                e--;
            }
        }
        return true;
    }
}