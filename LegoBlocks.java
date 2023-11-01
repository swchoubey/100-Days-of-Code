/*Problem Statement: To make learning more interactive and fun for students, 
a math teacher decides to teach a concept to students by using Lego blocks. 
There are 2 rows of legos, rowA (of length and row (of length m). Both rows hold 
legos with positive integer values printed on them. However, some values (possibly none) are missing. 
The missing values are denoted by 0. Students need to incorporate the missing values. 
The task is to replace each 0 with a positive integer such that the sums of both arrays are equal. 
Return the minimum sum possible if it is not possible to make the sums equal return-1.*/

import java.util.Arrays;

public class LegoBlocks {

    public static int minSumToMakeEqual(int[] rowA, int[] rowB) {
        int sumA = Arrays.stream(rowA).sum();
        int sumB = Arrays.stream(rowB).sum();

        if (sumA == sumB) {
            return 0; // Arrays already have equal sums
        } else if (sumA > sumB) {
            return calculateMinSum(rowA, rowB, sumA, sumB);
        } else {
            return calculateMinSum(rowB, rowA, sumB, sumA);
        }
    }

    public static int calculateMinSum(int[] largerRow, int[] smallerRow, int sumLarger, int sumSmaller) {
        int difference = sumLarger - sumSmaller;

        for (int i = 0; i < largerRow.length; i++) {
            if (largerRow[i] == 0) {
                int targetValue = difference + smallerRow[i];
                if (targetValue > 0) {
                    return targetValue;
                }
            }
        }
        return -1; // Unable to make sums equal
    }

    public static void main(String[] args) {
        int[] rowA = {0, 0, 0};
        int[] rowB = {1, 1};

        int result = minSumToMakeEqual(rowA, rowB);
        if (result == -1) {
            System.out.println("It is not possible to make the sums equal.");
        } else {
            System.out.println("Minimum sum possible to make the sums equal: " + result);
        }
    }
}
