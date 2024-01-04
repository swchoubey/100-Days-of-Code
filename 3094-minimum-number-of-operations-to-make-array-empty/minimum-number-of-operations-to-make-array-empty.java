class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int res = 0;
        for(int i : map.values()){
            if(i==1){
                return -1;
            }
            res += (i+2)/3;
        }
        return res;
    }
}