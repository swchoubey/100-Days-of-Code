class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!map.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            List<Integer> toErase = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int f = entry.getKey();
                int s = entry.getValue();
                temp.add(f);
                s--;
                if(s==0){
                    toErase.add(f);
                }
                map.put(f, s);
            }
            result.add(temp);
            for(int i : toErase){
                map.remove(i);
            }
        }
        return result;
    }
}