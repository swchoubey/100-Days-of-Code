class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> avaRooms = new PriorityQueue<>();
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        for(int i = 0; i < n; i++){
            avaRooms.add(i);
        }
        int[] count = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        for(int[] meeting : meetings){
            int s = meeting[0];
            int e = meeting[1];

            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= s){
                int[] fin = busyRooms.poll();
                avaRooms.add(fin[1]);
            }
            if(!avaRooms.isEmpty()){
                int room = avaRooms.poll();
                busyRooms.add(new int[]{e, room});
                count[room]++;
            }
            else{
                int[] ongoingMeeting = busyRooms.poll();
                e += ongoingMeeting[0] - s;
                busyRooms.add(new int[]{e, ongoingMeeting[1]});
                count[ongoingMeeting[1]]++;
            }
           
        }
        int maxBooked = 0;
        int roomWithMaxBookings = 0;
        for(int i = 0; i < n; i++){
            if(count[i] > maxBooked){
                maxBooked = count[i];
                roomWithMaxBookings = i;
            }
        }
        return roomWithMaxBookings;
    }
}