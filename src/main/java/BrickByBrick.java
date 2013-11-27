public class BrickByBrick {
    private static final int RD = 0;
    private static final int LD = 1;
    private static final int LU = 2;
    private static final int RU = 3;
    private static final int U = 0;
    private static final int L = 3;

    public int timeToClear(String[] map) {
        int rows = map.length;
        int cols = map[0].length();
        char[][] board = new char[map.length][];
        for (int i = 0; i < map.length; i++) {
            board[i] = map[i].toCharArray();
        }

        int bricks = 0;
        for (char[] row : board) {
            for (char c : row) {
                if (c == 'B') {
                    bricks++;
                }
            }
        }

        int seconds = 0;
        char neighbor;

        int pos = U;
        int dir = RD;
        int pi = 0, pj = 0;

        while (seconds < 1000000) {
            seconds++;
            if (pos == U) {
                pos = L;
                if (dir == RD) {
                    pj++;
                    if (pj == cols) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi][pj];
                        if (neighbor == 'B') {
                            board[pi][pj] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = LD;
                    }
                } else if (dir == LD) {
                    if (pj == 0) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi][pj - 1];
                        if (neighbor == 'B') {
                            board[pi][pj - 1] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = RD;
                    }
                } else if (dir == RU) {
                    pj++;
                    pi--;
                    if (pj == cols) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi][pj];
                        if (neighbor == 'B') {
                            board[pi][pj] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = LU;
                    }
                } else { // (dir == LU)
                    pi--;
                    if (pj == 0) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi][pj - 1];
                        if (neighbor == 'B') {
                            board[pi][pj - 1] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = RU;
                    }
                }
            } else {
                pos = U;
                if (dir == RD) {
                    pi++;
                    if (pi == rows) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi][pj];
                        if (neighbor == 'B') {
                            board[pi][pj] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = RU;
                    }
                } else if (dir == LD) {
                    pj--;
                    pi++;
                    if (pi == rows) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi][pj];
                        if (neighbor == 'B') {
                            board[pi][pj] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = LU;
                    }
                } else if (dir == RU) {
                    if (pi == 0) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi - 1][pj];
                        if (neighbor == 'B') {
                            board[pi - 1][pj] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = RD;
                    }
                } else { // (dir == LU)
                    pj--;
                    if (pi == 0) {
                        neighbor = '#';
                    } else {
                        neighbor = board[pi - 1][pj];
                        if (neighbor == 'B') {
                            board[pi - 1][pj] = '.';
                        }
                    }
                    if (neighbor != '.') {
                        dir = LD;
                    }
                }
            }
            if (neighbor == 'B') {
                bricks--;
                if (bricks == 0) {
                    return seconds;
                }
            }

        }
        return -1;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(map, expected, __case);
            break;

        case 0: {
            String map[] = new String[] { ".B", "BB" };
            int __excepted = 6;
            doTest(map, __excepted, __case);
            break;
        }
        case 1: {
            String map[] = new String[] { ".BB", "BBB", "BBB" };
            int __excepted = -1;
            doTest(map, __excepted, __case);
            break;
        }
        case 2: {
            String map[] = new String[] { "......B", "###.###", "B.....B" };
            int __excepted = 35;
            doTest(map, __excepted, __case);
            break;
        }
        case 3: {
            String map[] = new String[] { "..BBB...", ".#BB..#.", "B.#B.B..",
                    "B.B.....", "##.B.B#.", "#BB.#.B.", "B..B.BB.", "#..BB..B",
                    ".B....#." };
            int __excepted = -1;
            doTest(map, __excepted, __case);
            break;
        }
        case 4: {
            String map[] = new String[] { ".BB..BBB.B...", "B.B...B..BB..",
                    "#B...B#B.....", "B#B.B##...##B", "BB.B#.B##B.B#",
                    "B.B#.BBB.BB#B", "B#BBB##.#B#B.", "B#BB.BBB#BB.#" };
            int __excepted = 3912;
            doTest(map, __excepted, __case);
            break;
        }
        case 5: {
            String map[] = new String[] { ".BBBBBBBBBBBBBB", "##############B",
                    "BBBBBBBBBBBBBBB", "B##############", "BBBBBBBBBBBBBBB",
                    "##############B", "BBBBBBBBBBBBBBB", "B##############",
                    "BBBBBBBBBBBBBBB", "##############B", "BBBBBBBBBBBBBBB",
                    "B##############", "BBBBBBBBBBBBBBB", "##############B",
                    "BBBBBBBBBBBBBBB" };
            int __excepted = 31753;
            doTest(map, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String[] map, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        BrickByBrick instance = new BrickByBrick();
        int __result = 0;
        try {
            __result = instance.timeToClear(map);
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

    static int nExample = 6;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("BrickByBrick (1100 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374098945;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1100 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
