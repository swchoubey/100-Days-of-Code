import java.util.*;
public class FindFactor {
    public static long pthFactor(long n, long p){
        List<Long> factors = new ArrayList<>();
        for(long i = 1; i*i <=n ; i++){
            if(n%i==0){
                factors.add(i);
                if(n/i!=i){
                    factors.add(n/i);
                }
            }
        }
        Collections.sort(factors);
        if(p>factors.size()){
            return 0;
        }
        else{
            return factors.get((int) p - 1);
        }
    }
    public static void main(String[] args){
        long n = 20;
        long p = 4;
        System.out.println(pthFactor(n,p));
    }
    
}
