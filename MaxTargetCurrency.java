import java.util.HashMap;
import java.util.Map;

public class MaxTargetCurrency {
    public static void main(String[] args) {
        String fxRates = "USD,CAD,1.3;USD,GBP,0.71;USD,JPY,109;GBP,JPY,155";
        String originalCurrency = "USD";
        String targetCurrency = "JPY";

        double maxAmount = calculateMaxTargetCurrency(fxRates, originalCurrency, targetCurrency);
        System.out.println(maxAmount);
    }

    public static double calculateMaxTargetCurrency(String fxRates, String originalCurrency, String targetCurrency) {
        Map<String, Map<String, Double>> ratesMap = new HashMap<>();
        
        // Parse the FX rates and build a ratesMap
        String[] rateList = fxRates.split(";");
        for (String rate : rateList) {
            String[] parts = rate.split(",");
            String fromCurrency = parts[0];
            String toCurrency = parts[1];
            double rateValue = Double.parseDouble(parts[2]);
            
            if (!ratesMap.containsKey(fromCurrency)) {
                ratesMap.put(fromCurrency, new HashMap<>());
            }
            ratesMap.get(fromCurrency).put(toCurrency, rateValue);
        }

        // Calculate the max amount recursively
        double maxAmount = findMaxAmount(originalCurrency, targetCurrency, ratesMap, new HashMap<>());
        
        return (maxAmount == 0) ? -1.0 : maxAmount;
    }

    public static double findMaxAmount(String fromCurrency, String toCurrency, Map<String, Map<String, Double>> ratesMap, Map<String, Double> memo) {
        if (fromCurrency.equals(toCurrency)) {
            return 1.0;
        }
        
        if (memo.containsKey(fromCurrency)) {
            return memo.get(fromCurrency);
        }

        Map<String, Double> rates = ratesMap.get(fromCurrency);
        double maxAmount = 0;

        if (rates != null) {
            for (String nextCurrency : rates.keySet()) {
                double rate = rates.get(nextCurrency);
                double amount = findMaxAmount(nextCurrency, toCurrency, ratesMap, memo);
                if (amount > 0) {
                    double currentAmount = rate * amount;
                    maxAmount = Math.max(maxAmount, currentAmount);
                }
            }
        }

        memo.put(fromCurrency, maxAmount);
        return maxAmount;
    }
}
