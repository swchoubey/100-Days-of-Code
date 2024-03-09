class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int numOfLetters = 0;

        for(String word : words){
            if(word.length() + curr.size() + numOfLetters > maxWidth){
                for(int i = 0; i < maxWidth - numOfLetters; i++){
                    curr.set(i % (curr.size() - 1 > 0 ? curr.size() - 1 : 1), 
                    curr.get(i % (curr.size() - 1 > 0 ? curr.size() - 1 : 1)) + " ");
                }
                StringBuilder sb = new StringBuilder();
                for(String s : curr) sb.append(s);
                res.add(sb.toString());
                curr.clear();
                numOfLetters = 0;
            }
            curr.add(word);
            numOfLetters += word.length();
        }
            StringBuilder last = new StringBuilder();
            for(int i = 0; i < curr.size(); i++){
                last.append(curr.get(i));
                if(i != curr.size() - 1) last.append(" ");
            }
            while(last.length() < maxWidth) last.append(" ");
            res.add(last.toString());

            return res;
    }
}