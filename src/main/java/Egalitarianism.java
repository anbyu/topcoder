import java.util.Stack;

public class Egalitarianism {
    private int n;

    public int maxDifference(String[] isFriend, int d) {
        n = isFriend.length;
        boolean[][] graph = toBool(isFriend);

        if (isDivided(graph)) {
            return -1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int longest = longestPath(graph, i);
            if (longest > max) {
                max = longest;
            }
        }

        return max == 0 ? -1 : max * d;
    }

    private int longestPath(boolean[][] graph, int node) {
        Stack<Integer> s = new Stack<Integer>();
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            path[i] = Integer.MAX_VALUE;
        }
        path[node] = 0;

        s.add(node);

        while (!s.empty()) {
            int current = s.pop();
            boolean[] neighbors = graph[current];
            for (int i = 0; i < n; i++) {
                if (neighbors[i] && path[i] > path[current] + 1) {
                    path[i] = path[current] + 1;
                    s.add(i);
                }
            }
        }

        int maxPath = 0;
        for (int p : path) {
            if (p > maxPath) {
                maxPath = p;
            }
        }

        return maxPath;
    }

    private boolean isDivided(boolean[][] graph) {
        Stack<Integer> s = new Stack<Integer>();
        boolean[] visited = new boolean[n];

        visited[0] = true;
        s.add(0);

        while (!s.empty()) {
            int current = s.pop();
            boolean[] neighbors = graph[current];
            for (int i = 0; i < n; i++) {
                if (i != current && !visited[i] && neighbors[i]) {
                    s.add(i);
                    visited[i] = true;
                }
            }
        }

        for (boolean v : visited) {
            if (!v) {
                return true;
            }
        }

        return false;
    }

    boolean[][] toBool(String[] isFriend) {
        boolean[][] graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = isFriend[i].charAt(j) == 'Y';
            }
        }

        return graph;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(isFriend, d, expected, __case);
            break;

        case 0: {
            String isFriend[] = new String[] { "NYN", "YNY", "NYN" };
            int d = 10;
            int __excepted = 20;
            doTest(isFriend, d, __excepted, __case);
            break;
        }
        case 1: {
            String isFriend[] = new String[] { "NN", "NN" };
            int d = 1;
            int __excepted = -1;
            doTest(isFriend, d, __excepted, __case);
            break;
        }
        case 2: {
            String isFriend[] = new String[] { "NNYNNN", "NNYNNN", "YYNYNN",
                    "NNYNYY", "NNNYNN", "NNNYNN" };
            int d = 1000;
            int __excepted = 3000;
            doTest(isFriend, d, __excepted, __case);
            break;
        }
        case 3: {
            String isFriend[] = new String[] { "NNYN", "NNNY", "YNNN", "NYNN" };
            int d = 584;
            int __excepted = -1;
            doTest(isFriend, d, __excepted, __case);
            break;
        }
        case 4: {
            String isFriend[] = new String[] { "NYNYYYN", "YNNYYYN", "NNNNYNN",
                    "YYNNYYN", "YYYYNNN", "YYNYNNY", "NNNNNYN" };
            int d = 5;
            int __excepted = 20;
            doTest(isFriend, d, __excepted, __case);
            break;
        }
        case 5: {
            String isFriend[] = new String[] { "NYYNNNNYYYYNNNN",
                    "YNNNYNNNNNNYYNN", "YNNYNYNNNNYNNNN", "NNYNNYNNNNNNNNN",
                    "NYNNNNYNNYNNNNN", "NNYYNNYNNYNNNYN", "NNNNYYNNYNNNNNN",
                    "YNNNNNNNNNYNNNN", "YNNNNNYNNNNNYNN", "YNNNYYNNNNNNNNY",
                    "YNYNNNNYNNNNNNN", "NYNNNNNNNNNNNNY", "NYNNNNNNYNNNNYN",
                    "NNNNNYNNNNNNYNN", "NNNNNNNNNYNYNNN" };
            int d = 747;
            int __excepted = 2988;
            doTest(isFriend, d, __excepted, __case);
            break;
        }
        case 6: {
            String isFriend[] = new String[] { "NY", "YN" };
            int d = 0;
            int __excepted = 0;
            doTest(isFriend, d, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String[] isFriend, int d, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        Egalitarianism instance = new Egalitarianism();
        int __result = 0;
        try {
            __result = instance.maxDifference(isFriend, d);
        } catch (Throwable e) {
            exception = e;
        }
        double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

        nAll++;
        System.err.print(String.format("  Testcase #%d ... ", caseNo));

        if (exception != null) {
            System.err.println("RUNTIME ERROR!");
            exception.printStackTrace();
        } else if (__result == __expected) {
            System.err.println("PASSED! "
                    + String.format("(%.2f seconds)", elapsed));
            nPassed++;
        } else {
            System.err.println("FAILED! "
                    + String.format("(%.2f seconds)", elapsed));
            System.err.println("           Expected: " + __expected);
            System.err.println("           Received: " + __result);
        }
    }

    static int nExample = 7;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("Egalitarianism (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373455123;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
