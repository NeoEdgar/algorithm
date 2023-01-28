package org.justin.algorithm.unit3_链表.链表反转;

import org.justin.algorithm.unit3_链表.创建链表.BasicLinkList;

public class ReverseLinkList {

    static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 虚拟头节点头插法
     */
    public static ListNode vh(ListNode head){
        ListNode vh = new ListNode(0);
        //vh.next = head;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = vh.next;
            vh.next = cur;
            cur = next;
        }
        return vh.next;
    }


    /**
     * 穿针引线法,尾部null,往头部插入
     */
    public static ListNode rL(ListNode head){
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode(1);
        ListNode head = cur;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);

        System.out.println(toString(head));

        System.out.println(toString(vh(head)));
        //System.out.println(toString(rL(head)));

    }

    public static String toString(ListNode head){
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null){
            sb.append(node.data).append("\t");
            node = node.next;
        }
        return sb.toString();
    }




}
