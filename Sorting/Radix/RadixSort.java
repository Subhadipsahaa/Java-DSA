public class RadixSort {

    // Function to get the maximum value in the array
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // A stable counting sort that sorts based on the digit represented by exp
    private void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10]; // Count array for digits 0-9

        // Count occurrences of each digit at current place value
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Update count[i] so it contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array from right to left (to maintain stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Main radix sort function
    public void sort(int[] arr) {
        int max = getMax(arr); // Find the max number to know number of digits

        // Apply counting sort for every digit, from least significant to most
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);

            // Optional: Print the array after each pass
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
