class Solution {
    public int maxLength(List<String> arr) {
        int[] maxLength = {0};
        backtrack(arr, "", 0, maxLength);
        
        return maxLength[0];
    }
    private void backtrack(List<String> arr, String path, int start, int[] maxLength){
        if(maxLength[0] < path.length()){
            maxLength[0] = path.length();
        }
        for(int i = start; i < arr.size(); i++){
            if(!isUnique(path, arr.get(i))){
                continue;
            }
            backtrack(arr, path + arr.get(i), i + 1, maxLength);
        }
    }
    private boolean isUnique(String s, String rev){
        Set<Character> set = new HashSet<>();

        for(char c : rev.toCharArray()){
            if(set.contains(c)){
                return false;
            }
            set.add(c);
            if(s.contains(String.valueOf(c))){
                return false;
            }
        }
        return true;
    }
}