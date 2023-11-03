class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int i = 0, p = 1; //i is index and p is beginning of stream
        while(p<=n && i<target.length){
            int ele = target[i];
            if(ele == p){
                ops.add("Push");
                p++;
                i++;
            }
            else{
                ops.add("Push");
                ops.add("Pop");
                p++;
            }
        }
        return ops;
    }
}