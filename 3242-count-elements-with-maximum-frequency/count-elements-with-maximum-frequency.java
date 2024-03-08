class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, freq = Integer.MIN_VALUE;
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int f : map.values()){
            freq = Math.max(freq, f);
        }
        for(int f : map.values()){
            if(f == freq){
                max += freq;
            }
        }
        return max;
    }
}