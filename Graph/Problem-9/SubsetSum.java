// 8. Given a set of non-negative integers, and a value sum, Write a program to determine if there is a
// subset of the given set with sum equal to given sum. Input: set [] = {3, 34, 4, 12, 5, 2}, sum = 9
// Output: True [ There is a subset (4, 5) with sum 9]

public class SubsetSum {
    public static boolean isSubsetSum(int[] set, int n, int sum) {
        boolean[][] res = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {// if sum is 0, answer is true
            res[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {// if sum is not 0, answer is false
            res[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {// fill the subset table in a bottom-up manner
            for (int j = 1; j <= sum; j++) {
                if (set[i - 1] > j) {// if the current element is greater than the sum, we cannot include it
                    res[i][j] = res[i - 1][j];// exclude the current element
                } else {
                    res[i][j] = (res[i - 1][j] || res[i - 1][j - set[i - 1]]);// include or exclude the current element
                }
            }
        }
        return res[n][sum];
    }

    public static void main(String[] args) {
        int[] set = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum)) {
            System.out.println("True [There is a subset with the given sum]");
        } else {
            System.out.println("False [No subset with the given sum]");
        }
    }
}