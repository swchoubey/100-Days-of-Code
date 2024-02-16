class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry : list){
            if(entry.getValue() <= k){
                k -= entry.getValue();
                map.remove(entry.getKey());
            }
            else{
                break;
            }
        }
        return map.size();
    }
}