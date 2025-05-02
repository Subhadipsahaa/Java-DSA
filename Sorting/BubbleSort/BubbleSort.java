public class BubbleSort<T extends Comparable<T>> {
    T[] arr;

    BubbleSort(T[] arr) {
        this.arr = arr;
    }

    T[] BubbleSortOp() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        return arr;
    }
}