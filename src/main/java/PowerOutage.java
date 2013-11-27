import java.util.Stack;

public class PowerOutage {
    private static final int MAX = 50;

    class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

    public int estimateTimeOut(int[] fromJunction, int[] toJunction,
            int[] ductLength) {
        int[][] graph = new int[MAX][MAX];
        int n = fromJunction.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            graph[fromJunction[i]][toJunction[i]] = ductLength[i];
            sum += 2 * ductLength[i];
        }

        Stack<Edge> stack = new Stack<Edge>();
        stack.push(new Edge(0, 0, 0));
        while (!stack.isEmpty()) {
            Edge e = stack.pop();
            int cost = graph[e.from][e.to] + e.cost;
            // System.out.println(e.from + " -> " + e.to + "(" + cost + ")");
            graph[e.from][e.to] = cost;

            for (int i = 1; i < MAX; i++) {
                if (graph[e.to][i] != 0) {
                    stack.push(new Edge(e.to, i, cost));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (graph[i][j] > max) {
                    max = graph[i][j];
                }
            }
        }

        // for (int[] row : graph) {
        // System.out.println(Arrays.toString(row));
        // }

        return sum - max;
    }
}
