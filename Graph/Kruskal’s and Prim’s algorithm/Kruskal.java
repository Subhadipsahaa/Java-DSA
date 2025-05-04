public class Kruskal {
    int v;
    int parent[];// parent array for finding the ultimate parent of each vertex

    Kruskal(int v) {
        this.v = v;// initialize vertex
        parent = new int[v];
        for (int i = 0; i < v; i++) {// initialize parent array
            parent[i] = i; // initialize each vertex as its own parent
        }

    }

    int find(int i) {// find the ultimate parent of vertex i
        while (parent[i] != i) {// is i is not parent itself
            i = parent[i];// i = the parent of i
        }
        return i;// if i is parent itself return i
    }

    boolean union(int i, int j) {// union two verices
        int a = find(i);// finding the ultimate parent of i and j
        int b = find(j);
        if (a != b) {// if a and b are not same then add b as parent of a and return true
            parent[a] = b;
            return true;
        }
        return false;// if a and b are same then return false because it will create a cucle
    }

    void kruskalMst(int cost[][]) {
        int mincost = 0; // mincost for store minimum cost
        int edgecount = 0;// counts the edge
        while (edgecount < v - 1) {// mst will have vertex-1 edges
            int min = 999;// initialize min to a large value
            int a = -1, b = -1;
            for (int i = 0; i < v; i++) {// traverse and find the minimum cost edge
                for (int j = 0; j < v; j++) {
                    if (cost[i][j] < min && cost[i][j] != 0) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            if (a != -1 && b != -1 && union(a, b)) {// if a and b are not same then add b as parent of a and return true
                System.out.println("Edge " + (char) (a + 65) + "-" + (char) (b + 65) + " cost = " + min);
                mincost += min;// add the cost of edge + mincost
                edgecount++;// increment the edge count
            }
            cost[a][b] = 999;// remove the edge from the graph by setting it to a large value
            cost[b][a] = 999;// remove the edge from the graph by setting it to a large value
        }

        System.out.println("Minimum cost of the spanning tree: " + mincost);
    }
}