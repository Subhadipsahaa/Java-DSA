public class SelectionSort<T extends Comparable<T>> {
    void sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//assuming that i indexed element is the minimum element
            for (int j = i + 1; j < arr.length; j++) {// loop for unsorted part
                if (arr[j].compareTo(arr[min]) < 0) {// find the minimum element index in the array
                    min = j;
                }
            }
            if (min != i) {//if the min is not equal to i min that i indexed element is not the minimun 
                T temp = arr[min];//so we swap the content betwen the min indexed content and i indexed content
                arr[min] = arr[i];
                arr[i] = temp;
            }
            for (T t : arr) {//loop for show the result after each iteration
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}