class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] sorted = new int[n][2];

        for(int i = 0; i < n; i++){
            sorted[i] = new int[] {i, score[i]};
        }

        Arrays.sort(sorted, (x, y) -> (y[1] - x[1]));

        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            if(i == 0){
                answer[sorted[i][0]] = "Gold Medal";
            }
            else if(i == 1){
                answer[sorted[i][0]] = "Silver Medal";
            }
            else if(i == 2){
                answer[sorted[i][0]] = "Bronze Medal";
            }
            else{
                answer[sorted[i][0]] = String.valueOf(i+1);
            }
        }

        return answer;
    }
}