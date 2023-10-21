class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deq=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            nums[i]+=(!deq.isEmpty())?nums[deq.peekFirst()]:0;
            while(!deq.isEmpty() && ((i-deq.peekFirst()>=k) || nums[i]>=nums[deq.peekLast()])){
                if(nums[i]>=nums[deq.peekLast()]) deq.pollLast();
                else deq.pollFirst();
            }
            if(nums[i]>0) deq.offerLast(i);
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}