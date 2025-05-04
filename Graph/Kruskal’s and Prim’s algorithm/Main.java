public class Main {
    public static void main(String[] args) {
        int v = 5;
        int[][] cost = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };
        Kruskal kruskal = new Kruskal(v);
        kruskal.kruskalMst(cost);
        int[][] cost1 = {
            { 0, 9, 75, 0, 0 }, 
    		{ 9, 0, 95, 19, 42 }, 
    		{ 75, 95, 0, 51, 66 }, 
    		{ 0, 19, 51, 0, 31 },
    		{ 0, 42, 66, 31, 0 } 
        };
        Primes primes = new Primes();
        primes.primesMst(cost1, v);
    }
}