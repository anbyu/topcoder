public class BinaryCode {
    public String[] decode(String message) {
        char[] chars = message.toCharArray();
        int n = chars.length;
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = chars[i] - '0';
        }

        String[] answer = new String[2];

        answer[0] = checkWithFirst(0, q, n);
        answer[1] = checkWithFirst(1, q, n);

        return answer;
    }

    private String checkWithFirst(int first, int[] q, int n) {
        int[] p = new int[n];
        p[0] = first;

        if (n == 1 && q[0] != p[0]) {
            return "NONE";
        }

        if (n > 1) {
            p[1] = q[0] - first;
            if (n > 2) {
                for (int i = 2; i < n; i++) {
                    p[i] = q[i - 1] - p[i - 1] - p[i - 2];
                }
            }
            if (q[n - 1] != p[n - 2] + p[n - 1]) {
                return "NONE";
            }
        }

        for (int bit : p) {
            if (bit != 0 && bit != 1) {
                return "NONE";
            }
        }
        return ai2s(p);
    }

    private String ai2s(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int n : array) {
            sb.append(n);
        }
        return sb.toString();
    }
}
