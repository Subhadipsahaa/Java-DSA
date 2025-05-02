public class QuickSort<T extends Comparable<T>> {

    int partition(T[] arr, int low, int high) {// it return correect position after place it at it's correct position
        T pivot = arr[high];// we choose the high mean last element as pivot element
        int i = low - 1;// smaller element index

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {// if j th element is less than the pivot then swap with i th element
                i++;// increment the i index
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;// increment i for place the pivort element for after all smaller elements
        // swap with pivort element mean high indexed element
        T temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;// returns pivort index
    }

    void sort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);// partition function return the pivort index
            sort(arr, low, pivotIndex - 1);// recursively low to sort pivotIndex-1
            sort(arr, pivotIndex + 1, high);// recursively sort pivotIndex+1 to high
        }
    }

    void quickSort(T[] arr) {// method for call the sort and show the result
        int n = arr.length;
        sort(arr, 0, n - 1);
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
