class Solution {
    public int[] singleNumber(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();

       for(int n : nums) {
        map.put(n, map.getOrDefault(n, 0) + 1);
       }

       int[] res = new int[2];

       int i = 0;

       for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        if(entry.getValue() == 1){
            res[i++] = entry.getKey();
        }
       }
       return res;
    }
}