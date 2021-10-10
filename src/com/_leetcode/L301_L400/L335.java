package com._leetcode.L301_L400;

import java.util.HashSet;

public class L335 {
    //困难 ： 不做了
    HashSet<String> set = new HashSet<>();
    int startX = 0;
    int startY = 0;

    //从(0,0)开始 移动方向：上左下右
    public boolean isSelfCrossing(int[] distance) {

        for (int i = 0; i < distance.length; i++) {
            if (i % 4 == 0)
                up(distance, i);
            else if (i % 4 == 1)
                left(distance, i);
            else if (i % 4 == 2)
                down(distance, i);
            else if (i % 4 == 3)
                right(distance, i);
        }

        return false;
    }

    private void up(int[] distance, int index) {
        int upX = startX;
        int upY = startY + distance[index];
        if (startY > upY) {
            int t = startY;
            startY = upY;
            upY = t;
        }
        for (int i = startY; i <= upY; i++)
            set.add(upX + "," + i);
        startY = upY;
    }

    private void left(int[] distance, int index) {
        int leftX = startX - distance[index];
        int leftY = startY;
        if (startX > leftX) {
            int t = startX;
            startX = leftX;
            leftX = t;
        }
        for (int i = startX; i <= leftX; i++)
            set.add(i + "," + leftY);
        startX = leftX;
    }

    private void down(int[] distance, int index) {
        int downX = startX;
        int downY = startY - distance[index];

        if (startY > downY) {
            int t = startY;
            startY = downY;
            downY = t;
        }
        for (int i = startY; i <= downY; i++)
            set.add(downX + "," + i);
        startY = downY;
    }

    private void right(int[] distance, int index) {
        int rightX = startX + distance[index];
        int rightY = startY;

        if (startX > rightX) {
            int t = startX;
            startX = rightX;
            rightX = t;
        }
        for (int i = startX; i <= rightX; i++)
            set.add(i + "," + rightY);
        startX = rightX;
    }


    public static void main(String[] args) {
        new L335().isSelfCrossing(new int[]{1,2,3,4});
        System.out.println();
    }
}
