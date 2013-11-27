public class Crossroads {
	public int[] getOut(int[] angles) {
		return new int[0];
	}

// CUT begin
	static void runTestcase(int __case) {
		switch (__case) {
			// Your custom testcase goes here
			case -1:
				//doTest(angles, expected, __case);
				break;

			case 0: {
				int angles[] = new int[] {
					105, 75, 25, 120, 35, 75
				};
				int __excepted[] = new int[] {
					0, 1, 5
				};
				doTest(angles, __excepted, __case);
				break;
			}
			case 1: {
				int angles[] = new int[] {
					1, 1, 1, 1, 1, 1
				};
				int __excepted[] = new int[] {
					0, 1, 2, 3, 4, 5
				};
				doTest(angles, __excepted, __case);
				break;
			}
			case 2: {
				int angles[] = new int[] {
					13
				};
				int __excepted[] = new int[] {
					0
				};
				doTest(angles, __excepted, __case);
				break;
			}
			case 3: {
				int angles[] = new int[] {
					90, 123, 1, 23, 132, 11, 28, 179, 179, 77, 113, 91
				};
				int __excepted[] = new int[] {
					0
				};
				doTest(angles, __excepted, __case);
				break;
			}
			case 4: {
				int angles[] = new int[] {
					179, 89, 90, 91, 1
				};
				int __excepted[] = new int[] {
					0, 2, 4
				};
				doTest(angles, __excepted, __case);
				break;
			}
			case 5: {
				int angles[] = new int[] {
					89, 91
				};
				int __excepted[] = new int[] {
					0
				};
				doTest(angles, __excepted, __case);
				break;
			}
			case 6: {
				int angles[] = new int[] {
					140, 118, 54, 166, 151, 44, 90, 5, 14, 6, 64, 129, 74, 33, 134, 25, 11, 95, 65, 145, 29, 162, 24, 147, 45, 103, 63, 97, 120, 156, 167, 170, 19, 28, 100, 144, 161, 13, 157, 148
				};
				int __excepted[] = new int[] {
					0, 1, 6
				};
				doTest(angles, __excepted, __case);
				break;
			}
			default: break;
		}
	}

	static void doTest(int[] angles, int[] __expected, int caseNo) {
		long startTime = System.currentTimeMillis();
		Throwable exception = null;
		Crossroads instance = new Crossroads();
		int[] __result = new int[0];
		try {
			__result = instance.getOut(angles);
		}
		catch (Throwable e) { exception = e; }
		double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

		nAll++;
		System.err.print(String.format("  Testcase #%d ... ", caseNo));

		if (exception != null) {
			System.err.println("RUNTIME ERROR!");
			exception.printStackTrace();
		}
		else if (equals(__result, __expected)) {
			System.err.println("PASSED! " + String.format("(%.2f seconds)", elapsed));
			nPassed++;
		}
		else {
			System.err.println("FAILED! " + String.format("(%.2f seconds)", elapsed));
			System.err.println("           Expected: " + toString(__expected));
			System.err.println("           Received: " + toString(__result));
		}
	}

	static int nExample = 7;
	static int nAll = 0, nPassed = 0;

	static boolean equals(int[] a, int[] b) {
		if (a.length != b.length) return false;
		for (int i = 0; i < a.length; ++i) if (a[i] != b[i]) return false;
		return true;
	}

	static String toString(int[] arr) {
		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		for (int i = 0; i < arr.length; ++i) {
			if (i > 0) sb.append(", ");
			sb.append(arr[i]);
		}
		return sb.toString() + " ]";
	}
	public static void main(String[] args){
		System.err.println("Crossroads (1000 Points)");
		System.err.println();
		if (args.length == 0)
			for (int i = -1; i < nExample; ++i) runTestcase(i);
		else
			for (int i = 0; i < args.length; ++i) runTestcase(Integer.parseInt(args[i]));
		System.err.println(String.format("%nPassed : %d/%d cases", nPassed, nAll));

		int T = (int)(System.currentTimeMillis() / 1000) - 1372715083;
		double PT = T / 60.0, TT = 75.0;
		System.err.println(String.format("Time   : %d minutes %d secs%nScore  : %.2f points", T / 60, T % 60, 1000 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))));
	}
// CUT end
}
