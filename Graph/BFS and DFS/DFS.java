public class DFS {
    void dfsTraversal(int adj[][], boolean visited[], int start) {
        int n = adj.length;
        int stack[] = new int[n];
        int tos = -1;
        int i;
        stack[++tos] = start;
        visited[start] = true;
        System.out.print((char) (start + 65) + " ");
        while (tos != -1) {
            start = stack[tos];
            for (i = 0; i < n; i++) {
                if (adj[start][i] == 1 && visited[i] == false) {
                    stack[++tos] = i;
                    System.out.print((char) (i + 65) + " ");
                    visited[i] = true;
                    break;
                }
            }
            if (i == 5) {
                tos--;
            }
        }
    }
}