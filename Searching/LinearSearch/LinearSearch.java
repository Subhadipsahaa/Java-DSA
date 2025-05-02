import java.util.Scanner;

class FuncDeff {
    int inputarr[];
    int target;
    int size;

    FuncDeff(int size, int inputarr[], int target) {
        this.size = size;
        this.inputarr = inputarr;
        this.target = target;
    }

    int LinearSearch() {
        for (int i = 0; i < size; i++) {
            if (inputarr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    void Execution() {
        int result = LinearSearch();
        if (result == -1) {
            System.out.println("The element is not found.");
        } else {
            System.out.println("The element is present at " + (result + 1) + "th position.");
        }
    }
}

class LinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = in.nextInt();
        in.nextLine();
        int actualSize = 0;
        int inputarr[] = new int[size];
        String msg = "Enter " + size + " elements (Enter 'stop' to stop)";
        System.out.println(msg);
        for (int i = 0; i < msg.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "->");
            String temp = in.nextLine();
            if (temp.equals("stop")) {
                break;
            }
            try {
                inputarr[actualSize] = Integer.parseInt(temp);
                actualSize++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                i--;
            }
        }
        System.out.println();
        System.out.print("Enter the target element: ");
        int target = in.nextInt();
        FuncDeff obj = new FuncDeff(actualSize, inputarr, target);
        obj.Execution();
        in.close();
    }
}
