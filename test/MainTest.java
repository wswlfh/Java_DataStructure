import com._leetcode.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainTest {

    @Test
    public void main() {
        System.out.println("hello");
    }

    //测试链表节点在hashSet中的存储结构
    @Test
    public void ListNodeInSet(){
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode A = new ListNode(-1, null);
        hashSet.add(A);

        //输出的hashCode相等，说明进入hashSet的不是A的拷贝
        System.out.println(hashSet);//[com._leetcode.ListNode@69663380]
        System.out.println(A);//com._leetcode.ListNode@69663380


        ListNode B = new ListNode(1,A);
        ListNode C = new ListNode(1,A);
        hashSet.add(B);
        hashSet.add(C);
        //hashSet中元素顺序是混乱的，与先后进入顺序不一致
        //即使B.val == C.val 且其next指向都为A，但在内存栈中，B != C,hashCode不同
        System.out.println(hashSet);
        //[com._leetcode.ListNode@5b37e0d2,  ==> B
        // com._leetcode.ListNode@69663380,  ==> A
        // com._leetcode.ListNode@4459eb14]  ==> C

    }
}