public class BFS {
    void bfsTraversal(int adj[][], boolean visited[], int start) {
        int n = adj.length;
        int queue[] = new int[n];
        int rear = -1;
        int front = -1;
        int i;
        queue[++rear] = start;// enqueue the starting node
        visited[start] = true;// mark start as visited
        while (front != rear) {
            start = queue[++front];// dequeue the front node
            System.out.print((char) (start + 65) + " ");
            for (i = 0; i < n; i++) {
                if (adj[start][i] == 1 && visited[i] == false) {// if the node is adjacent and not visited
                    queue[++rear] = i;// enqueue the adjacent node
                    visited[i] = true;// mark it as visited
                }
            }

        }
    }
}
