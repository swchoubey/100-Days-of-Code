class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums1){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int n : nums2){
            if(map.containsKey(n) && map.get(n) > 0){
                return n;
            }
        }
        return -1;
    }
}