class Solution {
    private boolean canPlaceBalls(int gap, int[] positions, int m){
        int lastPosition = positions[0];
        int ballsRemaining = m - 1;

        for(int i = 1; i < positions.length && ballsRemaining > 0; i++){
            if(positions[i] - lastPosition >= gap){
                ballsRemaining--;
                lastPosition = positions[i];
            }
        }

        return ballsRemaining == 0;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int left = 1;
        int right = position[n - 1] - position[0];
        int maxMinDistance = -1;

        while(left <= right){
            int mid = (left + right)/2;

            if(canPlaceBalls(mid, position, m)){
                maxMinDistance = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return maxMinDistance;
    }
}