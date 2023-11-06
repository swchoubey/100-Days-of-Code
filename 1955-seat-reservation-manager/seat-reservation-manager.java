class SeatManager {
    private PriorityQueue<Integer> queue;
    private int count;
    public SeatManager(int n) {
        this.count=0;
        this.queue=new PriorityQueue<>();
    }
    
    public int reserve() {
        if(queue.size()==0){
            return ++count;
        }
        else{
            return queue.poll();
        }
        
    }
    
    public void unreserve(int seatNumber) {
        if(seatNumber==count){
            --count;
        }
        else{
            queue.offer(seatNumber);
        }
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */