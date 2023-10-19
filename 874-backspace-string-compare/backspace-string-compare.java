class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildFinalString(s).equals(buildFinalString(t));
    }
    private String buildFinalString(String str){
        Stack<Character> stack=new Stack<>();
        for(char c:str.toCharArray()){
            if(c!='#'){
                stack.push(c);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        StringBuilder sbr=new StringBuilder();
        for(char c:stack){
            sbr.append(c);
        }
        return sbr.toString();
    }
}