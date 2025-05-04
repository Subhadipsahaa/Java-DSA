public class Primes {
    void primesMst(int cost[][], int v) {
        boolean selected[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            selected[i] = false;
        }
        int noOfEdge = 0;
        selected[0] = true;
        int minCost = 0;
        while (noOfEdge < v - 1) {// mst will have (v - 1) edges
            int min = 999;// initialize min to a large value
            int a = -1;
            int b = -1;
            for (int i = 0; i < v; i++) {// traverse and find the minimum cost edge
                if (selected[i]) {// checks if the vertex is already selected
                    for (int j = 0; j < v; j++) {
                        if (!selected[j] && cost[i][j] != 0 && cost[i][j] < 999) {// check valid edge
                            if (min > cost[i][j]) {// find the minimum edge
                                min = cost[i][j];
                                a = i;
                                b = j;
                            }
                        }
                    }
                }
            }
            System.out.println("Edge " + (char) (a + 65) + "-" + (char) (b + 65) + " cost = " + min);
            minCost += min;// add the cost of the edge to the total cost
            selected[b] = true;// mark the vertex as selected
            noOfEdge++;// increment the edge count
        }

        System.out.println("Minimum cost of the spanning tree: " + minCost);
    }
}
