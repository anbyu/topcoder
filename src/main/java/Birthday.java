import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Birthday {
    private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");

    public String getNext(String date, String[] birthdays) {
        long now = getDate(date).getTime();
        Date bdate;
        long diff;
        long min = Long.MAX_VALUE;
        int min_i = 0;
        for (int i = 0; i < birthdays.length; i++) {
            bdate = getDate(birthdays[i].substring(0, 5));
            diff = bdate.getTime() - now;
            if (diff < 0) {
                Calendar c = Calendar.getInstance();
                c.setTime(bdate);
                c.add(Calendar.YEAR, 1);
                bdate = c.getTime();
                diff = bdate.getTime() - now;
            }
            if (diff < min) {
                min = diff;
                min_i = i;
            }
        }

        return birthdays[min_i].substring(0, 5);
    }

    private Date getDate(String str) {
        Date d = null;
        try {
            d = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(date, birthdays, expected, __case);
            break;

        case 0: {
            String date = "06/17";
            String birthdays[] = new String[] { "02/17 Wernie", "10/12 Stefan" };
            String __excepted = "10/12";
            doTest(date, birthdays, __excepted, __case);
            break;
        }
        case 1: {
            String date = "06/17";
            String birthdays[] = new String[] { "10/12 Stefan" };
            String __excepted = "10/12";
            doTest(date, birthdays, __excepted, __case);
            break;
        }
        case 2: {
            String date = "02/17";
            String birthdays[] = new String[] { "02/17 Wernie", "10/12 Stefan" };
            String __excepted = "02/17";
            doTest(date, birthdays, __excepted, __case);
            break;
        }
        case 3: {
            String date = "12/24";
            String birthdays[] = new String[] { "10/12 Stefan" };
            String __excepted = "10/12";
            doTest(date, birthdays, __excepted, __case);
            break;
        }
        case 4: {
            String date = "01/02";
            String birthdays[] = new String[] { "02/17 Wernie", "10/12 Stefan",
                    "02/17 MichaelJordan", "10/12 LucianoPavarotti",
                    "05/18 WilhelmSteinitz" };
            String __excepted = "02/17";
            doTest(date, birthdays, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String date, String[] birthdays, String __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        Birthday instance = new Birthday();
        String __result = "";
        try {
            __result = instance.getNext(date, birthdays);
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

    static int nExample = 5;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("Birthday (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374187493;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
