class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, l = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(map.get(nums[i]) > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }

            count = Math.max(count, i - l + 1);
        }

        return count;
    }
}