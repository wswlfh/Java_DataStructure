import com._leetcode.ListNode;
import org.junit.Test;

import java.util.*;

public class MainTest {

    @Test
    public void main() {
        System.out.println("hello");
    }

    //测试链表节点在hashSet中的存储结构
    @Test
    public void ListNodeInSet() {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode A = new ListNode(-1, null);
        hashSet.add(A);

        //输出的hashCode相等，说明进入hashSet的不是A的拷贝
        System.out.println(hashSet);//[com._leetcode.ListNode@69663380]
        System.out.println(A);//com._leetcode.ListNode@69663380


        ListNode B = new ListNode(1, A);
        ListNode C = new ListNode(1, A);
        hashSet.add(B);
        hashSet.add(C);
        //hashSet中元素顺序是混乱的，与先后进入顺序不一致
        //即使B.val == C.val 且其next指向都为A，但在内存栈中，B != C,hashCode不同
        System.out.println(hashSet);
        //[com._leetcode.ListNode@5b37e0d2,  ==> B
        // com._leetcode.ListNode@69663380,  ==> A
        // com._leetcode.ListNode@4459eb14]  ==> C

    }

    //测试Java中的优先队列结构
    @Test
    public void PriorityQueueTest() {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            /* java中 优先队列的compare的实现
            比较器里 return值实质上改变的是 每次siftUp和siftDown的判断条件
            a和b，a是新加入节点，b是a的父节点
            java的优先队列由最小堆实现
            加入新节点，如果compare返回为负，说明新节点优于其父节点，需要交换
            如果为正，说明新节点优先级低，则不动
            如果return为0，则不进行siftUp和siftDown操作，怎么进来就排成二叉树，然后直接出去
            遗留问题：java pg的remove()底层实现
             */
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        int[] nums = {1, 6, 5, 2};
        for (int i = 0; i < nums.length; i++) {
            //pq1.add(nums[i]);
            pq2.add(nums[i]);
        }
//        while (!pq1.isEmpty()) {
//            System.out.print(pq1.remove() + " ");
//        }
        System.out.println();
        System.out.println(pq2.remove());
        System.out.println(pq2.remove());


    }



}