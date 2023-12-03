class Solution {
    public int distCalc(int[] p1, int[] p2){
        int x = Math.abs(p1[0]-p2[0]);
        int y = Math.abs(p1[1]-p2[1]);

        return Math.max(x,y);
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int time=0;
        for(int i=1;i<points.length;i++){
            time+=distCalc(points[i-1], points[i]);
        }
        return time;
    }
}