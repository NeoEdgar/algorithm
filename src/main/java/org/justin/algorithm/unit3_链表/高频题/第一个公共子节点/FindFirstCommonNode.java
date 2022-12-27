package org.justin.algorithm.unit3_链表.高频题.第一个公共子节点;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Justin
 * @date 2022/12/27 4:36 PM
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode[] heads = initLinkedList();
        ListNode A = heads[0];
        ListNode B = heads[1];

        ListNode node = findFirstCommonNodeByStack(A, B);
        System.out.println("公共节点为："+node.val);
    }

    /**
     * 方法2：通过集合来辅助查找
     */
    public static ListNode findFirstCommonNodeBySet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 方法3：通过栈
     */
    public static ListNode findFirstCommonNodeByStack(ListNode headA, ListNode headB) {

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (headA != null){
            stackA.push(headA);
            headA = headA.next;
        }

        while (headB != null){
            stackB.push(headB);
            headB = headB.next;
        }

        ListNode pNode = null;
        while (stackB.size() > 0 && stackA.size() > 0){
            if (stackA.peek() == stackB.peek()){
                pNode = stackA.pop();
                stackB.pop();
            }else{
                break;
            }
        }
        return pNode;
    }

    /**
     * 简单构造两个链表
     *
     * @return
     */
    private static ListNode[] initLinkedList() {
        ListNode[] heads = new ListNode[2];
        heads[0] = new ListNode(1);
        ListNode current1 = heads[0];
        current1.next = new ListNode(2);
        current1 = current1.next;
        current1.next = new ListNode(3);
        current1 = current1.next;

        heads[1] = new ListNode(11);
        ListNode current2 = heads[1];
        current2.next = new ListNode(22);
        current2 = current2.next;

        ListNode node4 = new ListNode(4);
        current1.next = node4;
        current2.next = node4;
        node4.next = new ListNode(5);

        return heads;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
