public class Main {
    public static void main(String[] args) {
        int v = 4;
        int INF = 99999;
        int graph[][] = {
                { 0, 3, INF, 7 },
                { 8, 0, 2, INF },
                { 5, INF, 0, 1 },
                { 2, INF, INF, 0 }
        };
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.floydWarshall(graph, v);
    }
}
