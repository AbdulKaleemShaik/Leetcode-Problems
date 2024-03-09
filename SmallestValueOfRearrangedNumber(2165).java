import java.util.Arrays;

class Solution {
    public static long smallestNumber(long n) {
        if (n == 0) {
            return n;
        }
        StringBuilder sb = new StringBuilder();
        if (n > 0) {
            while (n != 0) {
                sb.append(n % 10);
                n = n / 10;
            }
            char[] arr = new char[sb.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sb.charAt(i);
            }
            sb = new StringBuilder();
            Arrays.sort(arr);
            boolean t = true;
            int i = 0;
            if (arr[0] != '0') {
                for (int j = 0; j < arr.length; j++) {
                    sb.append(arr[j]);
                }
                return Long.valueOf(sb.toString());
            }
            while (t) {
                if (arr[i] != '0') {
                    char temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                    t = false;
                }
                i++;
            }
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]);
            }
            return Long.valueOf(sb.toString());
        } else {
            n = -n;
            while (n != 0) {
                sb.append(n % 10);
                n = n / 10;
            }
            char[] arr = new char[sb.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sb.charAt(i);
            }
            sb = new StringBuilder();
            Arrays.sort(arr);
            for (int j = arr.length - 1; j >= 0; j--) {
                sb.append(arr[j]);
            }
            return -(Long.valueOf(sb.toString()));
        }

    }
}