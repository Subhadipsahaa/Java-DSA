// 6. Write a program to find out the total number of ways to make change of given amount.
// For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1}, {1,1,2}, {2,2}, {1,3}.
// So output should be 4. [Infinite Supply of coins]
public class CoinChangeWays {
    static int countWays(int coins[], int n, int amount) {
        int res[][] = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            res[i][0] = 1; // If amount is 0, there is one way to make change
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {// include the coin or exclude it
                    res[i][j] = res[i][j - coins[i - 1]] + res[i - 1][j];
                } else {// exclude the coin
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        return res[n][amount];
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
        int amount = 4;
        int n = coins.length;
        System.out.println("Total number of ways to make change: " + countWays(coins, n, amount));
    }
}
