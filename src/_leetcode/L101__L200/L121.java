package _leetcode.L101__L200;

import java.util.*;

public class L121 {
    //Solution1：想象成折线图，用一个变量来记录连续的，最大的高低差(当前最小值与之后的最大值的差）
    //即为最大利润
    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else if (maxProfit < prices[i] - minPrice){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
