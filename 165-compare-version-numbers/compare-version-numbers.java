class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);
        for(int i = 0; i < max; i++){
            int c1 = 0, c2 = 0;
            if(i >= v1.length){ 
                c1 = 0;
                c2 = Integer.valueOf(v2[i]);
                }
            else if(i >= v2.length){ 
                c2 = 0;
                c1 = Integer.valueOf(v1[i]);
                }
            else{
                c1 = Integer.valueOf(v1[i]);
                c2 = Integer.valueOf(v2[i]);
                }
            if(c1 > c2){ 
                return 1;
            }
            else if(c2 > c1){
                return -1;
            }
        }

        return 0;
    }
}