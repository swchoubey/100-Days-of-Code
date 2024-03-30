class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       int a = subArrayWithAtmostK(nums, k) ;
       int b = subArrayWithAtmostK(nums, k-1);

       return a - b;
    }

    public int subArrayWithAtmostK(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, res = 0;

        while(r < nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            res += r - l + 1;
            r++;
        }

        return res;
    }
}