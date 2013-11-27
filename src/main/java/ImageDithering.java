import java.util.HashSet;
import java.util.Set;

public class ImageDithering {
    public int count(String dithered, String[] screen) {
        int sum = 0;
        Set<Character> colors = new HashSet<Character>();
        for (char c : dithered.toCharArray()) {
            colors.add(c);
        }
        for (String row : screen) {
            for (char pixel : row.toCharArray()) {
                if (colors.contains(pixel)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(dithered, screen, expected, __case);
            break;

        case 0: {
            String dithered = "BW";
            String screen[] = new String[] { "AAAAAAAA", "ABWBWBWA",
                    "AWBWBWBA", "ABWBWBWA", "AWBWBWBA", "AAAAAAAA" };
            int __excepted = 24;
            doTest(dithered, screen, __excepted, __case);
            break;
        }
        case 1: {
            String dithered = "BW";
            String screen[] = new String[] { "BBBBBBBB", "BBWBWBWB",
                    "BWBWBWBB", "BBWBWBWB", "BWBWBWBB", "BBBBBBBB" };
            int __excepted = 48;
            doTest(dithered, screen, __excepted, __case);
            break;
        }
        case 2: {
            String dithered = "ACEGIKMOQSUWY";
            String screen[] = new String[] {
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX" };
            int __excepted = 150;
            doTest(dithered, screen, __excepted, __case);
            break;
        }
        case 3: {
            String dithered = "CA";
            String screen[] = new String[] { "BBBBBBB", "BBBBBBB", "BBBBBBB" };
            int __excepted = 0;
            doTest(dithered, screen, __excepted, __case);
            break;
        }
        case 4: {
            String dithered = "DCBA";
            String screen[] = new String[] { "ACBD" };
            int __excepted = 4;
            doTest(dithered, screen, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String dithered, String[] screen, int __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        ImageDithering instance = new ImageDithering();
        int __result = 0;
        try {
            __result = instance.count(dithered, screen);
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

    static int nExample = 5;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("ImageDithering (250 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = 0; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1369679565;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 250 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
