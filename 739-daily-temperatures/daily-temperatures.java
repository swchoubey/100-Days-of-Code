class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = temperatures.length - 1; i >= 0; --i){
            int curr = temperatures[i];
            while(!stack.isEmpty() && curr >=temperatures[stack.peekLast()]){
                stack.pollLast();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peekLast() - i;
            }
            stack.offerLast(i);
        }
        return res;
    }
}