import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BridgeCrossing {
    class State {
        int time;
        List<Integer> left;
        List<Integer> right;

        public State(int time, List<Integer> left, List<Integer> right) {
            this.time = time;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return time + " " + left + " " + right;
        }
    }

    public int minTime(int[] times) {
        if (times.length == 1) {
            return times[0];
        }

        List<Integer> timesList = new LinkedList<Integer>();
        for (int time : times) {
            timesList.add(time);
        }

        Stack<State> stack = new Stack<State>();
        stack.add(new State(0, timesList, new LinkedList<Integer>()));

        int min = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            State s = stack.pop();

            if (s.left.size() == 2) {
                int time = s.time + Math.max(s.left.get(0), s.left.get(1));
                if (time < min) {
                    min = time;
                }
            } else {
                for (int i = 0; i < s.left.size(); i++) {
                    for (int j = i + 1; j < s.left.size(); j++) {
                        int ti = s.left.get(i);
                        int tj = s.left.get(j);

                        List<Integer> left = new LinkedList<Integer>(s.left);
                        List<Integer> right = new LinkedList<Integer>(s.right);
                        right.add(left.remove(j));
                        right.add(left.remove(i));
                        int t = s.time + Math.max(ti, tj);

                        for (int k = 0; k < right.size(); k++) {
                            int tk = right.get(k);
                            List<Integer> tleft = new LinkedList<Integer>(left);
                            List<Integer> tright = new LinkedList<Integer>(
                                    right);
                            tleft.add(tright.remove(k));
                            stack.add(new State(t + tk, tleft, tright));
                        }
                    }
                }
            }
        }

        return min;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1: {
            int times[] = new int[] { 1, 2 };
            int __excepted = 2;
            doTest(times, __excepted, __case);
            break;
        }
        case 0: {
            int times[] = new int[] { 1, 2, 5, 10 };
            int __excepted = 17;
            doTest(times, __excepted, __case);
            break;
        }
        case 1: {
            int times[] = new int[] { 1, 2, 3, 4, 5 };
            int __excepted = 16;
            doTest(times, __excepted, __case);
            break;
        }
        case 2: {
            int times[] = new int[] { 100 };
            int __excepted = 100;
            doTest(times, __excepted, __case);
            break;
        }
        case 3: {
            int times[] = new int[] { 1, 2, 3, 50, 99, 100 };
            int __excepted = 162;
            doTest(times, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] times, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        BridgeCrossing instance = new BridgeCrossing();
        int __result = 0;
        try {
            __result = instance.minTime(times);
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

    static int nExample = 4;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("BridgeCrossing (1000 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1371161256;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1000 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
