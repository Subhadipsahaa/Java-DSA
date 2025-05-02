public class HeapSort<T extends Comparable<T>> {

  public void heapSort(T[] arr) {
    int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--) {// start from last non-leaf node and heapify each node
      heapify(arr, n, i);
    }
    for (int i = n - 1; i >= 0; i--) {// one by one extract elements from heap and rebuild heap
      // move current root to end
      T temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, i, 0);// heapify the reduced heap
    }
  }

  void heapify(T[] arr, int n, int i) {
    int largest = i; // initialize largest as root
    int l = 2 * i + 1; // left child index
    int r = 2 * i + 2; // right child index
    if (l < n && arr[l].compareTo(arr[largest]) > 0) {// if left child is larger than root
      largest = l;
    }
    if (r < n && arr[r].compareTo(arr[largest]) > 0) {// if right child is larger than largest so far
      largest = r;
    }
    if (largest != i) {// if largest is not root, swap and continue heapifying
      T temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      heapify(arr, n, largest);// recursively heapify the subtree
    }
  }

  void sort(T[] arr) {
    heapSort(arr);
    for (T t : arr) {
      System.out.print(t + " ");
    }
    System.out.println();
  }
}
