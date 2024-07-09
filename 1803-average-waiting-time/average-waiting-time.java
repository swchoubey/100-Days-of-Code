class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double wait = customers[0][1];
        int fin = customers[0][0] + customers[0][1];

        for(int i = 1; i < n; ++i){
            int[] times = customers[i];
            int arrive = times[0];

            int start = Math.max(arrive, fin);
            int end = start + times[1];
            fin = end;
            wait += end - arrive;
        }

        return wait/n;
    }
}