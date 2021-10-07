package com.avltree;

import java.util.*;

public class AVLtree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root; //根节点

    private int size;

    public AVLtree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //检查是否为BST
    private boolean isBST() {
        ArrayList<K> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0)
                return false;
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> list) {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
    }

    //检查是否为平衡树
    private boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null)
            return true;
        if (Math.abs(getBalanceFactor(node)) > 1)
            return false;
        return isBalance(node.left) && isBalance(node.right);
    }

    //获取高度
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    //计算平衡因子
    private int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    //旋转
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    //add 递归
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else node.value = value;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //LL
        if (getBalanceFactor(node) > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //LR
        if (getBalanceFactor(node) > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RR
        if (getBalanceFactor(node) < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //RL
        if (getBalanceFactor(node) < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    //
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node node, K key) {
        // 递归终止条件：先判断节点是不是空
        if (node == null)
            return false;

        if (key.compareTo(node.key) < 0)
            return contains(node.left, key);
        else if (key.compareTo(node.key) > 0)
            return contains(node.left, node.key);
        else
            return true;
    }

    //遍历
    //前序
    public void preOrder() {
        System.out.print("preOrder: ");
        preOrder(root);
        System.out.print('\n');
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //层序 easy
    public void leverOrder() {
        Queue<Node> queue = new LinkedList<>();  //向上转型
        System.out.print("levelOrder: ");
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.print(cur.key + " ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        System.out.print('\n');
    }

    //找最值节点
    private Node getMin(Node node) {
        if (node == null || node.left == null)
            return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node getMax(Node node) {
        if (node == null || node.right == null)
            return null;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    //删除

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                Node successor = getMin(node.right);
                successor.right = remove(successor, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }
        if (retNode == null)
            return null;
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        //LL
        if (getBalanceFactor(retNode) > 1 &&
                getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //LR
        if (getBalanceFactor(retNode) > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RR
        if (getBalanceFactor(retNode) < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //RL
        if (getBalanceFactor(retNode) < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }




    public static void main(String[] args) {

    }

}


