class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int n = formula.length();

        for(int i = 0; i < n;){
            if(formula.charAt(i) == '('){
                stack.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i) == ')'){
                Map<String, Integer> map = stack.pop();
                i++;
                int start = i;
                while(i < n && Character.isDigit(formula.charAt(i)))
                    i++;
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for(String k : map.keySet()){
                    stack.peek().put(k, stack.peek().getOrDefault(k, 0) + map.get(k) * multiplier);
                }
            }
            else{
                int start = i;
                i++;
                while(i < n && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String ele = formula.substring(start, i);
                start = i;
                while(i < n && Character.isDigit(formula.charAt(i))) 
                    i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(ele, stack.peek().getOrDefault(ele, 0) + count);
            }
        }
        Map<String, Integer> res = stack.pop();
        List<String> element = new ArrayList<>(res.keySet());
        Collections.sort(element);

        StringBuilder sb = new StringBuilder();

        for(String e : element){
            sb.append(e);
            int count = res.get(e);

            if(count > 1)
                sb.append(count);
        }


        return sb.toString();
    }
}