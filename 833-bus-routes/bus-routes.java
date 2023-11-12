class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        int maxStop = -1;
        for(int[] route: routes){
            for(int stop : route){
                maxStop = Math.max(maxStop, stop);
            }
        }
        if(maxStop<target){
            return -1;
        }
        int n = routes.length;
        int[] minBuses = new int[maxStop+1];
        Arrays.fill(minBuses, n+1);
        minBuses[source]=0;
        boolean flag = true;
        while(flag){
            flag = false;
            for(int[] route : routes){
                int min = n+1;
                for(int stop : route){
                    min = Math.min(min, minBuses[stop]);
                }
                min++;
                for(int stop : route){
                    if(minBuses[stop]>min){
                        minBuses[stop] = min;
                        flag=true;
                    }
                }
            }
        }
        return (minBuses[target] < n+1 ? minBuses[target]:-1);
    }
}