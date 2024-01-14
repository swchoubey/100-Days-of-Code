class Solution {
    public int minSteps(String s, String t) {
        int min = 0;
        int[] sf = new int[26];
        int[] tf = new int[26];

        for(char c : s.toCharArray()){
            sf[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            tf[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(sf[i] != tf[i]){
                min+= Math.abs(sf[i]-tf[i]);
            }
        }
        return min/2;
    }
}