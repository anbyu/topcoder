public class MergeSort {
    private int comparisons = 0;

    public int howManyComparisons(int[] numbers) {
        comparisons = 0;
        mergeSort(numbers);
        return comparisons;
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        } else {
            int[] n1 = subarray(nums, 0, nums.length / 2);
            int[] n2 = subarray(nums, nums.length / 2, nums.length);

            int[] sn1 = mergeSort(n1);
            int[] sn2 = mergeSort(n2);

            return merge(sn1, sn2);
        }
    }

    private int[] merge(int[] sn1, int[] sn2) {
        int[] merged = new int[sn1.length + sn2.length];
        int i = 0, j = 0;
        int k = 0;

        while (i < sn1.length && j < sn2.length) {
            if (sn1[i] < sn2[j]) {
                comparisons++;
                merged[k++] = sn1[i++];
            } else if (sn1[i] > sn2[j]) {
                comparisons++;
                merged[k++] = sn2[j++];
            } else {
                comparisons++;
                merged[k++] = sn1[i++];
                merged[k++] = sn2[j++];
            }
        }

        while (i < sn1.length) {
            merged[k++] = sn1[i++];
        }

        while (j < sn2.length) {
            merged[k++] = sn2[j++];
        }

        return merged;
    }

    private int[] subarray(int[] nums, int p, int q) {
        int[] array = new int[q - p];
        System.arraycopy(nums, p, array, 0, q - p);
        return array;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(numbers, expected, __case);
            break;

        case 0: {
            int numbers[] = new int[] { 1, 2, 3, 4 };
            int __excepted = 4;
            doTest(numbers, __excepted, __case);
            break;
        }
        case 1: {
            int numbers[] = new int[] { 2, 3, 2 };
            int __excepted = 2;
            doTest(numbers, __excepted, __case);
            break;
        }
        case 2: {
            int numbers[] = new int[] { -17 };
            int __excepted = 0;
            doTest(numbers, __excepted, __case);
            break;
        }
        case 3: {
            int numbers[] = new int[] {

            };
            int __excepted = 0;
            doTest(numbers, __excepted, __case);
            break;
        }
        case 4: {
            int numbers[] = new int[] { -2000000000, 2000000000, 0, 0, 0,
                    -2000000000, 2000000000, 0, 0, 0 };
            int __excepted = 19;
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
        MergeSort instance = new MergeSort();
        int __result = 0;
        try {
            __result = instance.howManyComparisons(numbers);
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
        System.err.println("MergeSort (1000 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374188452;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1000 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
