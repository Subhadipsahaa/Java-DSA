class Fractionalknapsack {
    // Inner class to represent an item with value and weight
    static class Item {
        int value, weight;

        // Constructor to initialize an item
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    // Method to calculate the maximum value that can be obtained
    static double getMaxValue(Item[] items, int capacity) {
        // Sort items based on value-to-weight ratio in descending order
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - i - 1; j++) {
                double ratio1 = (double) items[j].value / items[j].weight;
                double ratio2 = (double) items[j + 1].value / items[j + 1].weight;
                if (ratio1 < ratio2) {
                    // Swap items if the current item's ratio is less than the next item's ratio
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }

        double totalValue = 0.0; // Variable to store the total value of items in the knapsack

        // Iterate through the sorted items
        for (Item item : items) {
            if (capacity <= 0) // If the knapsack is full, stop
                break;

            if (item.weight <= capacity) {
                // If the item can fit entirely, add its full value
                totalValue += item.value;
                capacity -= item.weight; // Reduce the remaining capacity
            } else {
                // If the item can't fit entirely, take the fraction that fits
                totalValue += item.value * ((double) capacity / item.weight);
                break; // No more capacity left, so break
            }
        }

        return totalValue; // Return the maximum value obtained
    }

    public static void main(String[] args) {
        // Define an array of items with their values and weights
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50; // Define the capacity of the knapsack

        // Print the maximum value that can be obtained
        System.out.println("Maximum value in Knapsack = " + getMaxValue(items, capacity));
    }
}