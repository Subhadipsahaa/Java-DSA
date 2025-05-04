public class Main {
    public static void main(String[] args) {
        int adj[][] = {
                { 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 0, 0, 0 }
        };
        boolean visited[] = { false, false, false, false, false };
        System.err.println("DFS Traversal:");
        DFS dfs = new DFS();
        dfs.dfsTraversal(adj, visited, 0);
        System.out.println();
        System.err.println("BFS Traversal:");
        int adjb[][] = {
                { 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 0, 0, 0 }
        };
        boolean visitedb[] = { false, false, false, false, false };
        BFS bfs = new BFS();
        bfs.bfsTraversal(adjb, visitedb, 0);

    }
}
