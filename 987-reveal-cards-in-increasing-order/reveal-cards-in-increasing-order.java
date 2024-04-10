class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        Deque<Integer> indices = new LinkedList<>();

        for(int i = 0; i < deck.length; i++){
            indices.add(i);
        }

        for(int c : deck){
            int i = indices.poll();
            res[i] = c;
            if(!indices.isEmpty()){
                indices.add(indices.poll());
            }
        }

        return res;

    }
}