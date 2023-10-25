class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }
        //Each row has double the number of elements as the previous row, for ex: row 1 has 1 element[0], row 2 has 2 elements[0 1], row 3 has 4 elements [0 1 1 0] and so on.The pattern here indicates that the length of the nth row will be 2^(n-1). Since each bitwise left shift multiplies a number by 2, 1<<(n-1) shifts the binary representation of 1 by (n-1) bits
        int len=1<<(n-1); 
        if(k<=len/2){
            return kthGrammar(n-1,k);
        }
        else{
            return 1-kthGrammar(n-1,k-len/2);
        }
    }
}