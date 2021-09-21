package bst;

import java.util.*;

public class BST<E extends Comparable<E>> { // 让E具有可比较性
    private class Node {
        public E e;
        public Node left, right;

        Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root; //根节点

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    //add 非递归 non_recursion
    public void add_non_recursion(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            Node cur = root;
            while (cur != null) {
                if (e.compareTo(cur.e) < 0) {
                    if (cur.left == null) {
                        cur.left = new Node(e);
                        size++;
                        return;
                    } else
                        cur = cur.left;
                } else if (e.compareTo(cur.e) > 0) {
                    if (cur.right == null) {
                        cur.right = new Node(e);
                        size++;
                        return;
                    } else
                        cur = cur.right;
                } else
                    return;
            }
        }
    }

    //add 递归
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    // 非递归
    public boolean contains_non_recursion(E e) {
        if (e.compareTo(root.e) == 0)
            return true;
        Node cur = root;
        while (cur != null) {
            if (e.compareTo(cur.e) < 0)
                cur = cur.left;
            else if (e.compareTo(cur.e) > 0)
                cur = cur.right;
            else return true;
        }
        return false;
    }

    //
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        // 递归终止条件：先判断节点是不是空
        if (node == null)
            return false;

        if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else if (e.compareTo(node.e) > 0)
            return contains(node.left, e);
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

        System.out.print(node.e + " ");
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
            System.out.print(cur.e + " ");
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
    public void removeMin() {
        if (size != 0)
            root = removeMinR(root);
    }

    private Node removeMinR(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinR(node.left);
        return node;
    }

    //非递归
    private void removeMinNR(Node node) {
        if (node == null || node.left == null)
            return;
        Node cur = node;
        while (cur.left.left != null) {
            cur = cur.left;
        }
        if (cur.left.right != null) {
            Node temp = cur.left;
            cur.left = cur.left.right;
            temp.right = null;

        } else
            cur.left = null;
        size--;
    }

    public void removeMax() {
        if (size != 0)
            root = removeMaxR(root);
    }

    private Node removeMaxR(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxR(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) < 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = getMin(node.right);
            successor.right = removeMinR(node);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    //打印
    public void printNode() {
        BTreePrinter bTreePrinter = new BTreePrinter();
        bTreePrinter.printNode(root);
    }


    private class BTreePrinter {
        BTreePrinter() {

        }

        private void printNode(Node root) {
            int maxLevel = maxLevel(root);
            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            printWhitespaces(firstSpaces);

            List<Node> newNodes = new ArrayList<Node>();
            for (Node node : nodes) {
                if (node != null) {
                    System.out.print(node.e);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        printWhitespaces(1);

                    printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        printWhitespaces(1);

                    printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private int maxLevel(Node node) {
            if (node == null)
                return 0;

            return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
        }

        private <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }

}


