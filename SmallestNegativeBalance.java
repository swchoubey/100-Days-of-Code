import java.util.*;
import java.util.stream.Collectors;

class DebtRecord {
    String borrower;
    String lender;
    int amount;

    public DebtRecord(String borrower, String lender, int amount) {
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }
}

public class SmallestNegativeBalance {
    public static List<String> smallestNegativeDebt(List<List<String>> debts) {
        Map<String, Integer> balances = new HashMap<>();

        for (List<String> debtData : debts) {
            String borrower = debtData.get(0);
            String lender = debtData.get(1);
            int amount = Integer.parseInt(debtData.get(2));

            balances.put(borrower, balances.getOrDefault(borrower, 0) - amount);
            balances.put(lender, balances.getOrDefault(lender, 0) + amount);
        }

        List<String> smallestNegativeBalances = new ArrayList<>();
        int minBalance = 0;

        for (Map.Entry<String, Integer> entry : balances.entrySet()) {
            if (entry.getValue() < minBalance) {
                minBalance = entry.getValue();
                smallestNegativeBalances.clear();
                smallestNegativeBalances.add(entry.getKey());
            } else if (entry.getValue() == minBalance) {
                smallestNegativeBalances.add(entry.getKey());
            }
        }

        if (minBalance == 0) {
            return Collections.singletonList("No");
        } else {
            Collections.sort(smallestNegativeBalances);
            return smallestNegativeBalances;
        }
    }

    public static void main(String[] args) {
        List<List<String>> debts = new ArrayList<>();
        debts.add(Arrays.asList("Alex", "Blake", "2"));
        debts.add(Arrays.asList("Blake", "Alex", "2"));
        debts.add(Arrays.asList("Casey", "Alex", "5"));
        debts.add(Arrays.asList("Blake", "Casey", "7"));
        debts.add(Arrays.asList("Alex", "Blake", "4"));
        debts.add(Arrays.asList("Alex", "Casey", "4"));

        List<String> result = smallestNegativeDebt(debts);

        for (String name : result) {
            System.out.println(name);
        }
    }
}
