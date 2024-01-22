class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = n * (n+1)/2;
        int aSum = 0, sSum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            aSum += i;
        }
        for(int i : nums){
            set.add(i);
        }
        for(int i : set){
            sSum += i;
        }
        int d = aSum - sSum;
        int m = sum - sSum;

        return new int[]{d, m};
    }
}