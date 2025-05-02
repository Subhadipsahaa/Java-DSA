public class Main {
    public static void main(String[] args) {
        Integer [] arr ={5,71,3,1,2};
        BubbleSort <Integer> obj = new BubbleSort<Integer>(arr);
        Integer [] res=obj.BubbleSortOp();
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
