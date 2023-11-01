/*Problem Statement: Given three integers, i, j, and k, a sequence sum to be the value of 
i + (i + 1) + (i + 2) + (i + 3) + ... +j + (j - 1) + (j - 2) + (j - 3) + ... +k
(increment from i until it equals j, then decrement from j until it equals k). 
Given values i, j, and k, calculate the sequence sum as described.*/

import java.util.*;
public class SequenceSum {
    public static long getSequenceSum(int i, int j, int k){
        long sum=0;
        if(i<=j){
            while(i<j){
                sum+=i;
                ++i;
            }
            while(j>=k){
                sum+=j;
                --j;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        int j = s.nextInt();
        int k = s.nextInt();
        System.out.println(getSequenceSum(i,j,k));
        s.close();
    }
    
}
