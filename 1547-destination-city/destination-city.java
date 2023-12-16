class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> src = new HashSet<>();
        for(List<String> s : paths){
            src.add(s.get(0));
        }
        for(List<String> s : paths){
            if(!src.contains(s.get(1))){
                return s.get(1);
            }
        }
        return " ";
    }
}