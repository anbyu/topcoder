import java.util.Arrays;
import java.util.Stack;

public class ColorTheCells {

    class State {
        int time;
        int pos;
        int moves;
        int[] painted;

        public State(int time, int pos, int moves, int[] painted) {
            this.time = time;
            this.pos = pos;
            this.moves = moves;
            this.painted = Arrays.copyOf(painted, painted.length);
        }
    }

    public int minimalTime(int[] dryingTime) {
        Stack<State> stack = new Stack<State>();
        int[] painted = new int[dryingTime.length];
        stack.add(new State(0, 0, 0, painted));
        int min = Integer.MAX_VALUE;
        int mm = dryingTime.length * 3;

        while (!stack.isEmpty()) {
            State s = stack.pop();
            int t = 0;
            boolean nvm = false;
            for (int pt : s.painted) {
                if (pt == 0) {
                    nvm = true;
                }
                if (pt > t) {
                    t = pt;
                }
            }
            if (!nvm) {
                if (t < min) {
                    min = t;
                }
            }

            if (s.moves < mm) {
                if (s.pos > 0
                        && s.time + 1 >= s.painted[s.pos - 1]
                                + dryingTime[s.pos - 1]) {
                    stack.add(new State(s.time + 1, s.pos - 1, s.moves + 1,
                            painted));
                }
                if (s.pos < dryingTime.length - 1
                        && s.time + 1 >= s.painted[s.pos + 1]
                                + dryingTime[s.pos + 1]) {
                    stack.add(new State(s.time + 1, s.pos - 1, s.moves + 1,
                            painted));
                }
            }

            if (s.pos > 0 && s.painted[s.pos - 1] != 0) {
                s.painted[s.pos - 1] = s.time + 1;
                stack.add(new State(s.time + 1, s.pos, s.moves, painted));
            }
            if (s.pos > dryingTime.length - 1 && s.painted[s.pos + 1] != 0) {
                s.painted[s.pos + 1] = s.time + 1;
                stack.add(new State(s.time + 1, s.pos, s.moves, painted));
            }
        }

        return min;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(dryingTime, expected, __case);
            break;

        case 0: {
            int dryingTime[] = new int[] { 2, 2, 3 };
            int __excepted = 6;
            doTest(dryingTime, __excepted, __case);
            break;
        }
        case 1: {
            int dryingTime[] = new int[] { 1, 2, 100, 1 };
            int __excepted = 7;
            doTest(dryingTime, __excepted, __case);
            break;
        }
        case 2: {
            int dryingTime[] = new int[] { 33, 58, 21, 44 };
            int __excepted = 26;
            doTest(dryingTime, __excepted, __case);
            break;
        }
        case 3: {
            int dryingTime[] = new int[] { 35198, 26281, 72533, 91031, 44326,
                    43178, 85530 };
            int __excepted = 26287;
            doTest(dryingTime, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] dryingTime, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        ColorTheCells instance = new ColorTheCells();
        int __result = 0;
        try {
            __result = instance.minimalTime(dryingTime);
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
        System.err.println("ColorTheCells (1000 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1371211571;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1000 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
