class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max = 0;
        for(int d : difficulty){
            max = Math.max(max, d);
        }

        int[] maxPro = new int[max + 1];

        for(int i = 0; i < difficulty.length; i++){
            maxPro[difficulty[i]] = Math.max(maxPro[difficulty[i]], profit[i]);
        }

        for(int i = 1; i <= max; i++){
            maxPro[i] = Math.max(maxPro[i], maxPro[i-1]);
        }

        int totalPro = 0;
        for(int ability : worker){
            if(ability > max){
                totalPro += maxPro[max];
            }
            else{
                totalPro += maxPro[ability];
            }
        }

        return totalPro;
    }
}