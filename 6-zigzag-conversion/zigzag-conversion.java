class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];

        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuffer();
        }

        int x = 0;
        while(x < n){
        for(int i = 0; i < numRows && x < n; i++){
            sb[i].append(s.charAt(x++));
        }
        for(int i = numRows - 2; i > 0 && x < n; i--){
            sb[i].append(s.charAt(x++));
        }
        }
        StringBuffer buff = new StringBuffer();

        for(StringBuffer b : sb){
            buff.append(b);
        }

        return buff.toString();
    }
}