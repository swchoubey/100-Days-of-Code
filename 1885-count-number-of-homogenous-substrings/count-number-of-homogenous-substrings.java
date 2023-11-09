class Solution {
    public int countHomogenous(String s) {
        long count = 0;
        int left = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(left) == s.charAt(i)){
                count+=i-left+1;
            }
            else{
                count+=1;
                left=i;
            }
        }
        return (int)(count%(1000000007));
    }
}