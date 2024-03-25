class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int n = Math.abs(nums[i]);
            int ind = n - 1;
            if(nums[ind] < 0)
                list.add(n);
            nums[ind] *= -1;
        }
        return list;
    }
}