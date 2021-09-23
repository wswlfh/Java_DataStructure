package com;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;


public class Main {


    //String的 传参、 == 和 equals测试
    public void stringTest(String str) {
        String s1 = "haha";
        String s2 = new String("haha");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(str == s1); //比的是栈中的内容
        System.out.println(str.equals(s1));

        System.out.println(str == s2);
        System.out.println(str.equals(s2));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(str.hashCode());
    }


    //进行treeMap和hashMap的测试，treeMap会按照key值排序
    private void mapTest() {
        Random random = new Random();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put(random.nextInt(100), i);
            hashMap.put(random.nextInt(100), i);
        }
        treeMap.forEach((key, value) -> {
            System.out.println("(" + key + "," + value + ")");
        });
        hashMap.forEach((key, value) -> {
            System.out.println("(" + key + "," + value + ")");
        });
    }

    //随机数
    private int random() {
        /**
         * 生成 [m,n] 的数字*/
        int l = 0;
        int r = 100;
        Random random = new Random();
        int i = random.nextInt((r - l + 1)) + l;
        return i;

    }

    //快速打印数组
    public void printNums() {
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(nums));
    }

    private void find(int n) {
        for (int i = 1; i < n / 2; i++) {
            _find(i, n);
        }
    }

    private int _find(int index, int n) {
        int flag = 0;
        if (index < n) {
            flag = _find(index + 1, n - index);
        } else if (index == n) {
            System.out.print("\n" + index + " ");
            return 1;
        }
        if (flag == 1)
            System.out.print(index + " ");
        return (flag == 1) ? 1 : 0;
    }

    public static void main(String[] args) {
        Main main = new Main();
        //main.random();
        System.out.println("aaa");
    }


}

