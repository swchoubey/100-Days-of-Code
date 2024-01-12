class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int c1 = 0, c2 = 0;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='A' || s.charAt(i)=='e' || s.charAt(i)=='E' || s.charAt(i)=='i' || s.charAt(i)=='I' || s.charAt(i)=='o' || s.charAt(i)=='O' || s.charAt(i)=='u' || s.charAt(i)=='U'){
                c1++;
            }
        }
        for(int i=n/2;i<n;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='A' || s.charAt(i)=='e' || s.charAt(i)=='E' || s.charAt(i)=='i' || s.charAt(i)=='I' || s.charAt(i)=='o' || s.charAt(i)=='O' || s.charAt(i)=='u' || s.charAt(i)=='U'){
                c2++;
            }
        }
        return (c1 == c2)?true : false;
    }
}