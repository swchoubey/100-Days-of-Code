class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums){
            if(!map.containsKey(n)){
                int l = (map.containsKey(n-1)) ? map.get(n-1) : 0;
                int r = (map.containsKey(n+1)) ? map.get(n+1) : 0;

                int sum = l + r + 1;

                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - l, sum);
                map.put(n + r, sum);
            }
            else{
                continue;
            }
        }

        return res;
    }
}