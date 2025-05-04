public class FloydWarshall {
    int INF = 99999;
    void floydWarshall(int graph[][], int v) {
        int dist[][] = new int[v][v];// store the shortest distances between every pair of vertices
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dist[i][j] = graph[i][j];// initialize the distance matrix with graph
            }
        }
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {// if the path through vertex k is shorter update the distance
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        display(dist, v);
    }
    void display(int dist[][], int v) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (dist[i][j] == INF) {// if the distance is INF print "INF"
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");// print the distance value
                }
            }
            System.out.println();
        }
    }
}