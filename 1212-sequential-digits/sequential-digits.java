class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String num = "123456789";
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j <= 9; j++){
                int cur = Integer.parseInt(num.substring(i, j));
                if(cur >= low && cur <= high){
                    list.add(cur);
                }
            }
        }
        list.sort(null);
        return list;
    }
}