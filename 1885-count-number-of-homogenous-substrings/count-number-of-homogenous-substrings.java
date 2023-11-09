class Solution {
    public int countHomogenous(String s) {
        long count = 0;
        int start = 0;
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]!=c[start]){
                int appearance = i-start;
                while(appearance>0){
                    count+=appearance;
                    appearance-=1;
                }
                start=i;
            }
        }
        int appearance = c.length - start;
        while(appearance>0){
            count+=appearance;
            appearance-=1;
        }

        return (int)(count%(Math.pow(10,9)+7));
    }
}