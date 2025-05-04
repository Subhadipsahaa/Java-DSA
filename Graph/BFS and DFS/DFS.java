public class DFS {
    void dfsTraversal(int adj[][], boolean visited[], int start) {
        int n = adj.length;
        int stack[] = new int[n];
        int tos = -1;
        int i;
        stack[++tos] = start;// push the start node into the stack
        visited[start] = true;// mark start as visited
        System.out.print((char) (start + 65) + " ");
        while (tos != -1) {// while the stack is not empty
            start = stack[tos];// pop the top node from the stack
            for (i = 0; i < n; i++) {
                if (adj[start][i] == 1 && visited[i] == false) {// if the node is adjacent and not visited
                    stack[++tos] = i;// push the adjacent node into the stack
                    System.out.print((char) (i + 65) + " ");
                    visited[i] = true;// mark it as visited
                    break;// break the loop to process the next node
                }
            }
            if (i == 5) {// if all adjacent nodes are visited
                tos--;// pop the top node from the stack
            }
        }
    }
}