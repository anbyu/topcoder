public class CCipher {
    public String decode(String cipherText, int shift) {
        char[] chars = cipherText.toCharArray();
        int tmp;
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= shift;
            tmp = chars[i] - 'A';
            if (tmp < 0) {
                chars[i] = (char) ('Z' + tmp + 1);
            }
        }
        return new String(chars);
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(cipherText, shift, expected, __case);
            break;

        case 0: {
            String cipherText = "VQREQFGT";
            int shift = 2;
            String __excepted = "TOPCODER";
            doTest(cipherText, shift, __excepted, __case);
            break;
        }
        case 1: {
            String cipherText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int shift = 10;
            String __excepted = "QRSTUVWXYZABCDEFGHIJKLMNOP";
            doTest(cipherText, shift, __excepted, __case);
            break;
        }
        case 2: {
            String cipherText = "TOPCODER";
            int shift = 0;
            String __excepted = "TOPCODER";
            doTest(cipherText, shift, __excepted, __case);
            break;
        }
        case 3: {
            String cipherText = "ZWBGLZ";
            int shift = 25;
            String __excepted = "AXCHMA";
            doTest(cipherText, shift, __excepted, __case);
            break;
        }
        case 4: {
            String cipherText = "DBNPCBQ";
            int shift = 1;
            String __excepted = "CAMOBAP";
            doTest(cipherText, shift, __excepted, __case);
            break;
        }
        case 5: {
            String cipherText = "LIPPSASVPH";
            int shift = 4;
            String __excepted = "HELLOWORLD";
            doTest(cipherText, shift, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String cipherText, int shift, String __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        CCipher instance = new CCipher();
        String __result = "";
        try {
            __result = instance.decode(cipherText, shift);
        } catch (Throwable e) {
            exception = e;
        }
        double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

        nAll++;
        System.err.print(String.format("  Testcase #%d ... ", caseNo));

        if (exception != null) {
            System.err.println("RUNTIME ERROR!");
            exception.printStackTrace();
        } else if (__expected.equals(__result)) {
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
        System.err.println("CCipher (250 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373916945;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 250 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
