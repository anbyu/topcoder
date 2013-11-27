import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MNS {
    class Square {
        int[] nums;

        public Square(int[] numbers) {
            this.nums = numbers;
        }

        public boolean isMagic() {
            int sum = nums[0] + nums[1] + nums[2];

            for (int i = 1; i < 3; i++) {
                if (nums[i * 3] + nums[i * 3 + 1] + nums[i * 3 + 2] != sum) {
                    return false;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (nums[i] + nums[i + 3] + nums[i + 6] != sum) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(nums);
        }

        @Override
        public boolean equals(Object obj) {
            return Arrays.equals(nums, ((Square) obj).nums);
        }
    }

    private final Set<Square> magicSquares = new HashSet<Square>();

    public int combos(int[] numbers) {
        permutations(new int[0], numbers);

        return magicSquares.size();
    }

    private void permutations(int[] prefix, int[] rest) {
        if (rest.length == 0) {
            Square s = new Square(prefix);
            if (s.isMagic()) {
                magicSquares.add(s);
            }
        } else {
            for (int i = 0; i < rest.length; i++) {
                int[] nextPrefix = add(prefix, rest[i]);
                permutations(nextPrefix, without(rest, i));
            }
        }
    }

    private int[] add(int[] numbers, int n) {
        int[] copy = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, copy, 0, numbers.length);
        copy[copy.length - 1] = n;
        return copy;
    }

    private int[] without(int[] numbers, int index) {
        int[] copy = new int[numbers.length - 1];
        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i != index) {
                copy[j++] = numbers[i];
            }
        }
        return copy;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(numbers, expected, __case);
            break;

        case 0: {
            int numbers[] = new int[] { 1, 2, 3, 3, 2, 1, 2, 2, 2 };
            int __excepted = 18;
            doTest(numbers, __excepted, __case);
            break;
        }
        case 1: {
            int numbers[] = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4 };
            int __excepted = 1;
            doTest(numbers, __excepted, __case);
            break;
        }
        case 2: {
            int numbers[] = new int[] { 1, 5, 1, 2, 5, 6, 2, 3, 2 };
            int __excepted = 36;
            doTest(numbers, __excepted, __case);
            break;
        }
        case 3: {
            int numbers[] = new int[] { 1, 2, 6, 6, 6, 4, 2, 6, 4 };
            int __excepted = 0;
            doTest(numbers, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] numbers, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        MNS instance = new MNS();
        int __result = 0;
        try {
            __result = instance.combos(numbers);
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
        System.err.println("MNS (1000 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373925356;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1000 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
