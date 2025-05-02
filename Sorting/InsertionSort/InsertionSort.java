public class InsertionSort<T extends Comparable<T>> {
    void sort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {//loop for iterate the array from index 1 because we assume that index 0 is sorted
            T temp = arr[i];//asinging the i th value to temp;
            int j = i - 1;//we assign the value j i-1 for get the last indexed value for compare
            while (j >= 0 && arr[j].compareTo(temp) > 0) {//check the j>=0 and arr[j]>temp that mean we need to assign temp at correct poition we shit till the currect position
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;// assgn the temp at correct position
            for (T t : arr) {// shows the result after each iteration
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}