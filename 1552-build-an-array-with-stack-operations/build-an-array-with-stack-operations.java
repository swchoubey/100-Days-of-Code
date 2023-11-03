class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> tarset = new HashSet<>(); // "tarset" get it? lol
        for(int i=0;i<target.length;i++){
            tarset.add(target[i]);
        }
        int p = target[target.length-1];
        //Initially stack is always empty so we push 1 on to the stack and add Push to the list
        for(int i=1;i<=n;i++){
            if(i<=p){
                stack.push(i);
                ops.add("Push");
                if(!tarset.contains(i)){
                    stack.pop();
                    ops.add("Pop");
                }
            }
        }
        return ops;
    }
}