package org.justin.algorithm.unit3_链表.链表基础;

/**
 * @author Justin
 * @date 2022/12/27 2:51 PM
 *
 * 常见的链表定义
 */
public class ListNode {

    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
