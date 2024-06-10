import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class precisely {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sum = 1 << n;
            List<Integer> ans = findNumbers(sum, n);
            for (Integer i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static List<Integer> findNumbers(int sum, int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            ans.add(i);
            sum -= i;
        }
        ans.add(ans.get(ans.size() - 1));
        sum -= ans.get(ans.size() - 1);
        ans.add(sum);
        return ans;
    }
}
