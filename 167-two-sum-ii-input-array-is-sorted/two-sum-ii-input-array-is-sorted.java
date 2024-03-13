class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length - 1;

        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(target == sum){
                res[0] = l + 1;
                res[1] = r + 1;

                return res;
            }
            else if(sum < target)
                l++;
            else
                r--;
        }
        return res;
    }
}