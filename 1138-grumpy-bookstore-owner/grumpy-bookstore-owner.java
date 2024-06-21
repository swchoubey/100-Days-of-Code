class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i = 0, curr = 0, max = 0;

        for(int j = 0; j < grumpy.length; j++){
            curr += customers[j] * grumpy[j];
            max = Math.max(curr, max);

            if(j >= minutes - 1){
                curr -= customers[i] * grumpy[i++];
            }
        }
        int res = max;
        for(i = 0; i < grumpy.length; i++){
            res += customers[i] * (1 - grumpy[i]);
        }

        return res;
    }
}