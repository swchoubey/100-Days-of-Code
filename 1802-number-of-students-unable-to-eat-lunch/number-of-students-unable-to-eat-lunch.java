class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];

        for(int s : students){
            counts[s]++;
        }

        int hungry = sandwiches.length;

        for(int s : sandwiches){
            if(counts[s] == 0) break;
            if(hungry-- == 0) break;
            counts[s]--;
        }

        return hungry;
    }
}