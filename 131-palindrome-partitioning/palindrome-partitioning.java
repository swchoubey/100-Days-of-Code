class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        getPart(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void getPart(String s, int start, List<String> path, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = start + 1; end <= s.length(); end++){
            if(isPal(s, start, end - 1)){
                path.add(s.substring(start, end));
                getPart(s, end, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}