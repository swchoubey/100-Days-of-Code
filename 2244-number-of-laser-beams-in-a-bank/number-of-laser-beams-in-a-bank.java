class Solution {
    public int numberOfBeams(String[] bank) {
        int beams = 0;
        List<Integer> ones = new ArrayList<>();
        for(int i=0;i<bank.length;i++){
            int count = 0;
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1'){
                    count++;
                }
            }
            if(count!=0){
                ones.add(count);
            }
        }
        if(ones.size()==1){
            return 0;
        }
        else{
            for(int i=0;i<ones.size()-1;i++){
                beams+=ones.get(i)*ones.get(i+1);
            }
        }
        return beams;
    }
}