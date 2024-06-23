class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> dq = new LinkedList<>();
        Deque<Integer> eq = new LinkedList<>();

        int ans = 0, l = 0;
        for(int r = 0; r < nums.length; ++r){
            int num = nums[r];
            while(!dq.isEmpty() && num > dq.peekLast()){
                dq.pollLast();
            }
            dq.addLast(num);

            while(!eq.isEmpty() && num < eq.peekLast()){
                eq.pollLast();
            }
            eq.addLast(num);

            while(dq.peekFirst() - eq.peekFirst() > limit){
                if(dq.peekFirst() == nums[l]){
                    dq.pollFirst();
                }
                if(eq.peekFirst() == nums[l]){
                    eq.pollFirst();
                }
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}