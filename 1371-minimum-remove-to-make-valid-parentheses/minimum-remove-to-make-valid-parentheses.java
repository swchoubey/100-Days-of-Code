class Solution {
    public String minRemoveToMakeValid(String s) {
        int left = 0, right = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '('){
                left++;
            }

            if(curr == ')'){
                right++;
            }

            if(right > left){
                right--;
                continue;
            }
            else{
                st.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char curr = st.pop();
            if(left > right && curr == '('){
                left--;
            }
            else{
                sb.append(curr);
            }
        }

        return sb.reverse().toString();
    }
}