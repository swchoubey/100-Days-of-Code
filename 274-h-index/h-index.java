class Solution {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int h = 0;

        for(int i : citations){
            pq.offer(i);
        }

        while(!pq.isEmpty() && pq.peek() > h){
            pq.poll();
            h++;
        }

        return h;
    }
}