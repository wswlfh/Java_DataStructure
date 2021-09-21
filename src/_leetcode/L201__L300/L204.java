package _leetcode.L201__L300;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class L204 {

    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int j = 0;
        int count = 0;
        int[] list = new int[n / 2];
        list[0] = 2;
        list[1] = 3;
        count++;
        for (int i = 5; i < n; i = i + 2) {
            for (j = 0; j < count; j++) {
                if (i % list[j] != 0 ) {
                    if ( list[j] > Math.pow(i,0.5)){
                        list[count] = i;
                        count++;
                        break;
                    }else
                        break;
                }
            }
        }
        System.out.println(Arrays.toString(list));
        return count;
    }


    public static void main(String[] args) {
        //System.out.println(L204.countPrimes(100));
    }
}
