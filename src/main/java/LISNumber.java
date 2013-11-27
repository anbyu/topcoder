public class LISNumber {
	public int count(int[] cardsnum, int K) {
		return 0;
	}

// CUT begin
	static void runTestcase(int __case) {
		switch (__case) {
			// Your custom testcase goes here
			case -1:
				//doTest(cardsnum, K, expected, __case);
				break;

			case 0: {
				int cardsnum[] = new int[] {
					1, 1, 1
				};
				int K = 2;
				int __excepted = 4;
				doTest(cardsnum, K, __excepted, __case);
				break;
			}
			case 1: {
				int cardsnum[] = new int[] {
					2
				};
				int K = 1;
				int __excepted = 0;
				doTest(cardsnum, K, __excepted, __case);
				break;
			}
			case 2: {
				int cardsnum[] = new int[] {
					36, 36, 36, 36, 36
				};
				int K = 36;
				int __excepted = 1;
				doTest(cardsnum, K, __excepted, __case);
				break;
			}
			case 3: {
				int cardsnum[] = new int[] {
					3, 2, 11, 5, 7
				};
				int K = 20;
				int __excepted = 474640725;
				doTest(cardsnum, K, __excepted, __case);
				break;
			}
			case 4: {
				int cardsnum[] = new int[] {
					31, 4, 15, 9, 26, 5, 35, 8, 9, 7, 9, 32, 3, 8, 4, 6, 26
				};
				int K = 58;
				int __excepted = 12133719;
				doTest(cardsnum, K, __excepted, __case);
				break;
			}
			case 5: {
				int cardsnum[] = new int[] {
					27, 18, 28, 18, 28, 4, 5, 9, 4, 5, 23, 5, 36, 28, 7, 4, 7, 13, 5, 26, 6, 24, 9, 7, 7, 5, 7, 24, 7, 9, 36, 9, 9, 9, 5, 9
				};
				int K = 116;
				int __excepted = 516440918;
				doTest(cardsnum, K, __excepted, __case);
				break;
			}
			default: break;
		}
	}

	static void doTest(int[] cardsnum, int K, int __expected, int caseNo) {
		long startTime = System.currentTimeMillis();
		Throwable exception = null;
		LISNumber instance = new LISNumber();
		int __result = 0;
		try {
			__result = instance.count(cardsnum, K);
		}
		catch (Throwable e) { exception = e; }
		double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

		nAll++;
		System.err.print(String.format("  Testcase #%d ... ", caseNo));

		if (exception != null) {
			System.err.println("RUNTIME ERROR!");
			exception.printStackTrace();
		}
		else if (__result == __expected) {
			System.err.println("PASSED! " + String.format("(%.2f seconds)", elapsed));
			nPassed++;
		}
		else {
			System.err.println("FAILED! " + String.format("(%.2f seconds)", elapsed));
			System.err.println("           Expected: " + __expected);
			System.err.println("           Received: " + __result);
		}
	}

	static int nExample = 6;
	static int nAll = 0, nPassed = 0;

	public static void main(String[] args){
		System.err.println("LISNumber (500 Points)");
		System.err.println();
		if (args.length == 0)
			for (int i = -1; i < nExample; ++i) runTestcase(i);
		else
			for (int i = 0; i < args.length; ++i) runTestcase(Integer.parseInt(args[i]));
		System.err.println(String.format("%nPassed : %d/%d cases", nPassed, nAll));

		int T = (int)(System.currentTimeMillis() / 1000) - 1374931009;
		double PT = T / 60.0, TT = 75.0;
		System.err.println(String.format("Time   : %d minutes %d secs%nScore  : %.2f points", T / 60, T % 60, 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))));
	}
// CUT end
}
