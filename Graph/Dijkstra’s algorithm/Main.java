public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, 4, 0, 0, 0 },
                { 0, 0, 1, 7, 0, 0 },
                { 0, 0, 0, 0, 3, 0 },
                { 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 2, 0, 6 },
                { 0, 0, 0, 0, 0, 0 } };
        Dijkstras dijkstra = new Dijkstras();
        dijkstra.dijkstra(graph, 0);
    }
}
