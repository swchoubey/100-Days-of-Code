class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        int i = 0, j = 0;
        while(i < neededTime.length && j< neededTime.length){
            int curr = 0, currMx = 0;
            while(j < neededTime.length && colors.charAt(i) == colors.charAt(j)){
                curr += neededTime[j];
                currMx = Math.max(currMx, neededTime[j]);
                j++;
            }
            time += curr - currMx;
            i = j;
        }
        return time;
    }
}