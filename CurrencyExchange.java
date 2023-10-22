import java.util.*;
import java.lang.*;
public class CurrencyExchange {
    public static void main(String[] args){
        String fxRates="USD,GBP,0.7;USD,JPY,109;GBP,JPY,155;CAD,CNY,5.27;CAD,KRW,921";
        String source="USD";
        String target="CNY";
        System.out.println(currencyExchangeValue(fxRates, source, target));
    }
    public static double currencyExchangeValue(String fxrates, String from, String target){
        Map<String, Map<String, Double>> rateMap=new HashMap<>();
        String[] rateList=fxrates.split(";");
        for(String rate:rateList){
            String[] parts=rate.split(",");
            String fromCurr=parts[0];
            String toCurr=parts[1];
            double excRate=Double.parseDouble(parts[2]);

            if(!rateMap.containsKey(fromCurr)){
                rateMap.put(fromCurr, new HashMap<>());
            }
            rateMap.get(fromCurr).put(toCurr,excRate);
        }
        double maxAmount=getMaxValue(from, target, rateMap, new HashMap<>());
        return (maxAmount==0)?-1.0:maxAmount;
    }
    public static double getMaxValue(String fromCurr, String toCurr, Map<String, Map<String, Double>> rateMap, Map<String, Double> memo){
        if(fromCurr.equals(toCurr)){
            return 1.0;
        }
        if(memo.containsKey(fromCurr)){
            memo.get(fromCurr);
        }
        Map<String, Double> exchange=rateMap.get(fromCurr);
        double maxRate=0;
        if(exchange!=null){
            for(String nextCurr:exchange.keySet()){
                double rate=exchange.get(nextCurr);
                double amount=getMaxValue(nextCurr, toCurr, rateMap, memo);
                if(amount>0){
                    double newAmount=rate*amount;
                    maxRate=Math.max(newAmount, maxRate);
                }     
            }
        }
        memo.put(fromCurr, maxRate);

        return maxRate;

    }
    
}
