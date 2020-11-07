package pratice.rating1400;

import java.io.*;

public class B538 {
    private static final int MAX_N = 200001;
    private static Integer[] a = new Integer[MAX_N];
    private static Integer[] dp = new Integer[MAX_N];

    static class InputSupport {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer getInt() throws Exception {
            return Integer.valueOf(br.readLine());
        }

        Integer[] getIntArray(int n) throws Exception {
            String s = br.readLine();
            Integer[] result = new Integer[n];
            String[] strings = s.split(" ");
            for (int i = 0; i < n; i++) {
                result[i] = Integer.valueOf(strings[i]);
            }
            return result;
        }

        Long getLong() throws Exception {
            return Long.valueOf(br.readLine());
        }

        Long[] getLongArray(int n) throws Exception {
            String s = br.readLine();
            Long[] result = new Long[n];
            String[] strings = s.split(" ");
            for (int i = 0; i < n; i++) {
                result[i] = Long.valueOf(strings[i]);
            }
            return result;
        }

        Double getDouble() throws Exception {
            return Double.valueOf(br.readLine());
        }

        Double[] getDoubleArray(int n) throws Exception {
            String s = br.readLine();
            Double[] result = new Double[n];
            String[] strings = s.split(" ");
            for (int i = 0; i < n; i++) {
                result[i] = Double.valueOf(strings[i]);
            }
            return result;
        }

    }

    public static void main(String[] args) throws Exception {
        InputSupport inputSupport = new InputSupport();
        int n = inputSupport.getInt();

        System.out.println();
    }
}
