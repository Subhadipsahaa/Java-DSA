public class MergeSort<T extends Comparable<T>> {

    private void conquer(T[] arr, int si, int mid, int ei) {// merge two sorted subarrays into one sorted array
        Object[] merge = new Object[ei - si + 1];// temporary array holds merged elements

        int idx1 = si;// start index of the left subarray
        int idx2 = mid + 1;// start index of the right subarray
        int x = 0;// index for the merge array

        while (idx1 <= mid && idx2 <= ei) {// Merge elements from both part in sorted order
            if (arr[idx1].compareTo(arr[idx2]) <= 0) {
                merge[x++] = arr[idx1++];
            } else {
                merge[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {// copy any remaining elements from the left half
            merge[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {// copy any remaining elements from the right half
            merge[x++] = arr[idx2++];
        }

        for (int i = 0; i < merge.length; i++) {// copy merged result back into the original array
            arr[si + i] = (T) merge[i];
        }
    }

    private void divide(T[] arr, int si, int ei) {// Recursively divide the array into two part
        if (si >= ei) {// checks when subarray has one or no elements
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);// Recursively divide the left half
        divide(arr, mid + 1, ei);// Recursively divide the right half
        conquer(arr, si, mid, ei);// Merge the sorted part
    }

    void sort(T[] arr) {
        divide(arr, 0, arr.length - 1);
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
