class Solution {
    int i = 0;
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        return reverse(arr);
    }

    public String reverse(char[] arr){
        StringBuilder sb = new StringBuilder();
        while(i < arr.length){
            if(arr[i] == ')'){
                i++;
                return sb.reverse().toString();
            }
            else if(arr[i] == '('){
                i++;
                String s = reverse(arr);
                sb.append(s);
            }
            else{
                sb.append(arr[i]);
                i++;
            }
        }
        return sb.toString();
    }
}