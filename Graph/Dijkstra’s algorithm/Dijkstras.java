public class Dijkstras {
    int findminDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;// initialize minimum distance as infinite
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    void dijkstra(int[][] graph, int source) {
        int v = graph[0].length;// number of vertices
        boolean visited[] = new boolean[v];// track visited vertices
        int distance[] = new int[v];// store the shortest distance from source to each vertex
        for (int i = 0; i < v; i++) {
            visited[i] = false;// initialize all vertices as unvisited
            distance[i] = Integer.MAX_VALUE;// initialize all distances as infinite
        }
        distance[source] = 0;
        for (int i = 0; i < v - 1; i++) {// loop through all vertices
            int u = findminDistance(distance, visited);// get the vertex with the minimum distance
            visited[u] = true;// mark the vertex as visited
            for (int j = 0; j < v; j++) {// update distances of adjacent vertices
                if (!visited[j] && graph[u][j] != 0 && (distance[u] + graph[u][j] < distance[j])) {
                    distance[j] = distance[u] + graph[u][j];
                }
            }
        }
        for (int i = 0; i < v; i++) {
            System.out.println("Distance from " + source + " to " + i + " is " + distance[i]);
        }
    }
}