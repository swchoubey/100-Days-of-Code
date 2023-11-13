class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for(char c : s.toCharArray()){
            if("aeiouAEIOU".indexOf(c)!=-1){
                vowels.add(c);
            }
        }
        Collections.sort(vowels, Collections.reverseOrder());
        StringBuilder t = new StringBuilder();
        for(char c : s.toCharArray()){
            if("aeiouAEIOU".indexOf(c)!=-1){
                t.append(vowels.get(vowels.size()-1));
                vowels.remove(vowels.size()-1);
            }
            else{
                t.append(c);
            }
        }
        return t.toString();
    }
}