class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
public class ZerOneKnapsack {
    static int max(int a, int b) {//method to find the maximum
        return (a > b) ? a : b;
    }
    static int getMaxValue(Item[] items, int capacity) {// method to find the maximum value in the knapsack
        int size = items.length;
        int[][] table = new int[size + 1][capacity + 1];//array to store the maximun value of each capacity
        for (int i = 0; i <= size; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {//if capacity is 0 or no items are left the maximum value will be 0
                    table[i][w] = 0;
                } else if (items[i - 1].weight <= w) {//if the item can fit in the knapsack
                    table[i][w] = max(table[i - 1][w], items[i - 1].value + table[i - 1][w - items[i - 1].weight]);//maximum of the previous item and the current item + the maximum value of the remaining capacity
                } else {//if the item can't fit in the knapsack
                    table[i][w] = table[i - 1][w];//store the maximum value of the previous item
                }
            }
        }
        return table[size][capacity];
    }
    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;
        System.out.println("Maximum value in Knapsack : " + getMaxValue(items, capacity));
    }
}
