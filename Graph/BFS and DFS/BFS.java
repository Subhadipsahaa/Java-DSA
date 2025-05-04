public class BFS {
    void bfsTraversal(int adj[][], boolean visited[], int start) {
        int n = adj.length;
        int queue[] = new int[n];
        int rear = -1;
        int front = -1;
        int i;
        queue[++rear] = start;
        visited[start] = true;
        while (front != rear) {
            start = queue[++front];
            System.out.print((char) (start + 65) + " ");
            for (i = 0; i < n; i++) {
                if (adj[start][i] == 1 && visited[i] == false) {
                    queue[++rear] = i;
                    // System.out.print((char) (i + 65) + " ");
                    visited[i] = true;
                }
            }

        }
    }
}
