import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Code {
    boolean[] flag;
    int ans = 1;

    public int maxEnvelopes(int[][] e) {
        // write code here
        flag = new boolean[e.length];
        for (int i = 0; i < e.length; i++) {
            dfs(e, i, 0, 0);
        }

        return ans;
    }

    private void dfs(int[][] e, int index, int round, int last) {
        if (round != 0) {
            if (e[last][0] >= e[index][0] && e[last][1] >= e[index][1]) {
                ans = Math.max(ans, round + 1);
            } else
                return;
        }

        for (int i = 0; i < e.length; i++) {
            if (i == index || flag[i]) continue;
            flag[i] = true;
            dfs(e, i, round + 1, index);
            flag[i] = false;
        }
    }

    public int maxEnvelopes2(int[][] e) {
        LinkedList<int[]> list = new LinkedList<>(Arrays.asList(e));
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });
        int ans = 0;
        int[] memo = new int[e.length];
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] > list.get(i + 1)[0] && list.get(i - 1)[1] > list.get(i - 1)[1]) {
                memo[i] = memo[i - 1] + 1;
                ans = Math.max(memo[i], ans);
            }
        }
        return 0;
    }


    public static int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[2] = memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //比较 原来的memo[i] 和 j * memo[i-j] 哪个大
                // 但如果有的数不需要再分就会更大 即 (i-j) > memo[i-j] 的情况，所以要再判断一次
                memo[i] = Math.max(memo[i], Math.max(j * memo[i - j], j * (i - j)));
            }
        }
        return memo[n];
    }


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        int ans = dp(coins, memo, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dp(int[] coins, int[] memo, int C) {
        if (C == 0) return 0;
        if (C < 0) return Integer.MAX_VALUE;
        if (memo[C] != 0) return memo[C];
        //每种硬币都要选
        memo[C] = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, memo, C - coin);
            if (sub == Integer.MAX_VALUE) continue;
            memo[C] = Math.min(memo[C], sub + 1);
        }
        return memo[C];
    }


    public static void main(String[] args) {
        System.out.println(new Code().coinChange(new int[]{1, 2, 5}, 100));
    }
}