class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];
        for(int i = 0; i < matches.length; i++){
            int win = matches[i][0];
            int loss = matches[i][1];

            if(losses[win] == 0){
                losses[win] = -1;
            }

            if(losses[loss] == -1){
                losses[loss] = 1;
            }
            else{
                losses[loss]++;
            }
        }
        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < losses.length; i++){
            if(losses[i] == -1){
                noLoss.add(i);
            }
            else if(losses[i] == 1){
                oneLoss.add(i);
            }
        }
        answer.add(noLoss);
        answer.add(oneLoss);

        return answer;
    }
}