class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();  
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int a = 0, b = 0;
        int n = s.length();
        for(int i = 0; i < n/2; i++){
            if(set.contains(s.charAt(i))){
                a++;
            }
        }
        for(int i = n/2; i < n; i++){
            if(set.contains(s.charAt(i))){
                b++;
            }
        }

        return (a == b)? true : false;
    }
}