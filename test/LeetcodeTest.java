import org.junit.Test;

public class LeetcodeTest {


    @Test //509
    public void fib() {
        int n = 5;
        int[] ans = new int[n + 1];
        System.out.println(compute(ans, n));
    }

    private int compute(int[] ans, int n) {
        if (n == 1 || n == 2)
            return 1;
        if (ans[n] != 0)
            return ans[n];
        ans[n] = compute(ans, n - 1) + compute(ans, n - 2);
        return ans[n];
    }

    @Test //509
    public void L509() {
        System.out.println(fib(10));
    }

    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
