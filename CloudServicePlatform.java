import java.util.Arrays;

public class CloudServicePlatform {

    public static int maxComputingPower(int[] power) {
        if (power == null || power.length == 0) {
            return 0;
        }

        // Finding the maximum power among the processors
        int maxPower = Arrays.stream(power).max().orElse(0);

        // Creating an array to store the count of processors with each power value
        int[] count = new int[maxPower + 1];
        for (int p : power) {
            count[p]++;
        }

        // Creating an array to store the maximum possible sum of computing powers for each power value
        int[] dp = new int[maxPower + 1];
        dp[1] = count[1];

        for (int i = 2; i <= maxPower; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i] * i);
        }

        return dp[maxPower];
    }

    public static void main(String[] args) {
        int[] power = {3, 3, 3, 4, 4, 1, 8};
        int result = maxComputingPower(power);
        System.out.println("Maximum possible sum of computing powers: " + result);
    }
}
