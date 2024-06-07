class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>(
            Arrays.asList(sentence.split(" "))
        );

        for(String s : temp){
            int i = 0;
            while(i <= s.length()){
                String curr = s.substring(0, i++);
                if(set.contains(curr)){
                    sb.append(curr).append(" ");
                    break;
                }
                if(i == s.length() + 1)
                    sb.append(s).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}