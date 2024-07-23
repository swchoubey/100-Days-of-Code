class Solution {
    public int[] frequencySort(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; ++i){
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
       }
       List<Integer> list = new ArrayList<>();
       for(int n : nums){
            list.add(n);
       }
       Collections.sort(list, (a, b) -> {
        int fa = map.get(a);
        int fb = map.get(b);

        if(fa != fb){
            return Integer.compare(fa, fb);
        }
        else{
            return Integer.compare(b, a);
        }
       });

       for(int i = 0; i < nums.length; ++i){
        nums[i] = list.get(i);
       }

       return nums;
    }
}