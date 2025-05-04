// 7. Write a program to find out the minimum no of coins to make change of given amount
// For example, for N = 10 and S = {1,5,6,9}, there are two solutions: {5,5},{1,9} So output should
// be 2. [Infinite Supply of coins]

public class MinCoinsChange {
    static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int minCoins(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {// initialize the res array with a large value
            res[i] = Integer.MAX_VALUE;
        }
        res[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (res[j - coin] != Integer.MAX_VALUE) {
                    res[j] = min(res[j], res[j - coin] + 1);// update the minimum coins needed for amount j
                }
            }
        }
        if (res[amount] == Integer.MAX_VALUE) {// if res[amount] is still Integer.MAX_VALUE then it means that we cannot make the amount with the given coins
            return -1;
        } else {
            return res[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = { 1, 5, 6, 9 };
        int amount = 10;
        int result = minCoins(coins, amount);
        if (result != -1) {
            System.out.println("Minimum number of coins required: " + result);
        } else {
            System.out.println("No solution.");
        }
    }
}