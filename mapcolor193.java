import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void greedyColoring() {
        int result[] = new int[V];
        Arrays.fill(result, -1);

        boolean available[] = new boolean[V];
        Arrays.fill(available, true);

        result[0] = 0;

        for (int u = 1; u < V; u++) {
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1)
                    available[result[i]] = false;
            }

            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr])
                    break;
            }

            result[u] = cr;

            Arrays.fill(available, true);
        }

        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " ---> Color " + result[u]);
    }
}

public class mapcolor193 {
    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();
    }
}
    