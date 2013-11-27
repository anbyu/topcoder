import java.util.Arrays;

public class CopyOfSpaceWarDiv2 {
    class Enemy implements Comparable<Enemy> {
        int str;
        int count;

        Enemy(int s, int c) {
            str = s;
            count = c;
        }

        @Override
        public int compareTo(Enemy o) {
            return Integer.valueOf(str).compareTo(Integer.valueOf(o.str));
        }
    }

    public int minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength,
            int[] enemyCount) {
        int[] fatigue = new int[magicalGirlStrength.length];
        Enemy[] enemies = new Enemy[enemyStrength.length];
        for (int i = 0; i < enemyStrength.length; i++) {
            enemies[i] = new Enemy(enemyStrength[i], enemyCount[i]);
        }

        Arrays.sort(magicalGirlStrength);
        Arrays.sort(enemies);

        int sumEnemies = 0;
        for (int c : enemyCount) {
            sumEnemies += c;
        }
        int mean = (int) Math.ceil((double) sumEnemies / enemyCount.length);

        int gi = 0, ei = 0;
        while (gi < magicalGirlStrength.length && ei < enemies.length) {
            int left = mean - fatigue[gi];
            if (magicalGirlStrength[gi] >= enemies[ei].str) {
                if (left <= enemies[ei].count) {
                    enemies[ei].count -= left;
                    fatigue[gi] += left;
                    gi++;
                } else {
                    fatigue[gi] += enemies[ei].count;
                    enemies[ei].count = 0;
                    ei++;
                }
            } else {
                gi++;
            }
        }

        boolean defeated = true;
        while (defeated) {
            defeated = false;
            for (int i = magicalGirlStrength.length - 1; i >= 0; --i) {
                for (int j = magicalGirlStrength.length - 1; j >= 0; --j) {
                    if (enemies[j].count > 0
                            && magicalGirlStrength[i] >= enemies[j].str) {
                        fatigue[i]++;
                        enemies[j].count--;
                        defeated = true;
                        break;
                    }
                }
            }
        }

        int sumFatigue = 0;
        for (int f : fatigue) {
            sumFatigue += f;
        }
        if (sumEnemies != sumFatigue) {
            return -1;
        }

        int max = 0;
        for (int f : fatigue) {
            if (f > max) {
                max = f;
            }
        }
        return max;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(magicalGirlStrength, enemyStrength, enemyCount, expected,
            // __case);
            break;

        case 0: {
            int magicalGirlStrength[] = new int[] { 2, 3, 5 };
            int enemyStrength[] = new int[] { 1, 3, 4 };
            int enemyCount[] = new int[] { 2, 9, 4 };
            int __excepted = 7;
            doTest(magicalGirlStrength, enemyStrength, enemyCount, __excepted,
                    __case);
            break;
        }
        case 1: {
            int magicalGirlStrength[] = new int[] { 2, 3, 5 };
            int enemyStrength[] = new int[] { 1, 1, 2 };
            int enemyCount[] = new int[] { 2, 9, 4 };
            int __excepted = 5;
            doTest(magicalGirlStrength, enemyStrength, enemyCount, __excepted,
                    __case);
            break;
        }
        case 2: {
            int magicalGirlStrength[] = new int[] { 14, 6, 22 };
            int enemyStrength[] = new int[] { 8, 33 };
            int enemyCount[] = new int[] { 9, 1 };
            int __excepted = -1;
            doTest(magicalGirlStrength, enemyStrength, enemyCount, __excepted,
                    __case);
            break;
        }
        case 3: {
            int magicalGirlStrength[] = new int[] { 17, 10, 29, 48, 92, 60, 80,
                    100, 15, 69, 36, 43, 70, 14, 88, 12, 14, 29, 9, 40 };
            int enemyStrength[] = new int[] { 93, 59, 27, 68, 48, 82, 15, 95,
                    61, 49, 68, 15, 16, 26, 64, 82, 7, 8, 92, 15 };
            int enemyCount[] = new int[] { 56, 26, 12, 52, 5, 19, 93, 36, 69,
                    61, 68, 66, 55, 28, 49, 55, 63, 57, 33, 45 };
            int __excepted = 92;
            doTest(magicalGirlStrength, enemyStrength, enemyCount, __excepted,
                    __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] magicalGirlStrength, int[] enemyStrength,
            int[] enemyCount, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        CopyOfSpaceWarDiv2 instance = new CopyOfSpaceWarDiv2();
        int __result = 0;
        try {
            __result = instance.minimalFatigue(magicalGirlStrength,
                    enemyStrength, enemyCount);
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
        System.err.println("SpaceWarDiv2 (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1371208609;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
