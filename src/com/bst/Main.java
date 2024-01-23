package com.bst;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        //int nums[] = {12, 64, 32, 23, 3,7,77,56};
        int nums[] = {28, 16, 30, 13,22,29,42};
        for (int num : nums) {
            bst.add(num);
        }

    }
}
