class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        for(int i = 0; i < garbage.length-1; i++){
            res += 3*travel[i];
        }
        for(String s : garbage){
            res += s.length();
        }
        for(int i = garbage.length-1; i > 0; i--){
            if(!garbage[i].contains("M")){
                res -= travel[i-1];
            }
            else{
                break;
            }
        }
        for(int i = garbage.length-1; i > 0; i--){
            if(!garbage[i].contains("P")){
                res -= travel[i-1];
            }
            else{
                break;
            }
        }
        for(int i = garbage.length-1; i > 0; i--){
            if(!garbage[i].contains("G")){
                res -= travel[i-1];
            }
            else{
                break;
            }
        }
        return res;
    }
}