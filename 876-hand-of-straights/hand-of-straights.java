class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int[] sorted = new int[map.size()];
        int in = 0;
        for(int key : map.keySet()){
            sorted[in++] = key;
        }
        Arrays.sort(sorted);

        for(int key : sorted){
            if(map.get(key) > 0){
                int start= map.get(key);
                for(int i = key; i < key + groupSize; i++){
                    if(map.getOrDefault(i, 0) < start) return false;
                    map.put(i, map.get(i) - start);
                }
            }
        }
        return true;
    }
}