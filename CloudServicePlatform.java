/*Problem Statement: In order to increase their computing efficiency, a cloud services platform added n new processors, where the th processor provides them a compute of power[i]. However, not all processors can be used to execute a process. If a processor with computing power of power[i] is used, then all processors that have (power[i] + 1) or (power[i] - 1) cannot be used for execution. A processor can only be used once. Find the maximum possible sum of computing powers of chosen processors.*/
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
