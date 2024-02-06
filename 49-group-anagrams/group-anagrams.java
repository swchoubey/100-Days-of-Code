class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ana = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!ana.containsKey(key)){
                ana.put(key, new ArrayList<>(List.of(s)));
            }
            else{
                ana.get(key).add(s);
            }
        }
        return new ArrayList<>(ana.values());
    }
}