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
