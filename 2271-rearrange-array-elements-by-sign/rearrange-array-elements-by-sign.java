class Solution {
    public int[] rearrangeArray(int[] nums) {
        Stack<Integer> pos = new Stack<>();
        Stack<Integer> neg = new Stack<>();
        for(int n : nums){
            if(n > 0){
                pos.push(n);
            }
            else{
                neg.push(n);
            }
        }
        int[] res = new int[nums.length];
        for(int i = nums.length-1; i >=0; i -= 2){
            res[i] = neg.pop();
        }
        for(int i = nums.length-2; i >=0; i -= 2){
            res[i] = pos.pop();
        }
        return res;
    }
}