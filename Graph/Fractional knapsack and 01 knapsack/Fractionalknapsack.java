class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Fractionalknapsack {
    static double getMaxValue(Item[] items, int capacity) {
        for (int i = 0; i < items.length - 1; i++) {// sort items based on value-to-weight ratio in descending order
            for (int j = 0; j < items.length - i - 1; j++) {
                double ratio1 = (double) items[j].value / items[j].weight;
                double ratio2 = (double) items[j + 1].value / items[j + 1].weight;
                if (ratio1 < ratio2) {// swap items if the current item's ratio is less than the next item's ratio
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        double totalValue = 0.0;// variable to store the total value of items in the knapsack
        for (Item item : items) {
            if (capacity <= 0) {// if capacity is full, stop
                break;
            }
            if (item.weight <= capacity) {// if the item can fit entirely, add its full value
                totalValue += item.value;
                capacity -= item.weight;// reduce capacity
            } else {// if the item can't fit entirely take the fraction
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;
        System.out.println("Maximum value in Knapsack : " + getMaxValue(items, capacity));
    }
}