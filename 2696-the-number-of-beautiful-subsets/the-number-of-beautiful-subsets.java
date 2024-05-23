class Solution {
    private int count;
    private Map<Integer, Integer> visited;

    public Solution(){
        this.count = 0;
        this.visited = new HashMap<>();
    }
    public int beautifulSubsets(int[] nums, int k) {
        explore(nums, k, 0);

        return count - 1;
    }
    private void explore(int[] nums, int k, int i){
        if(i == nums.length){
            count++;
            return;
        }
        int num = nums[i];
        if(!visited.containsKey(num - k) && !visited.containsKey(num + k)){
            visited.put(num, visited.getOrDefault(num, 0) + 1);
            explore(nums, k, i + 1);
            visited.put(num, visited.get(num) - 1);

            if(visited.get(num) == 0){
                visited.remove(num);
            }
        }
        explore(nums, k, i+1);
    }
}