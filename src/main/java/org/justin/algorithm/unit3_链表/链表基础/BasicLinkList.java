package org.justin.algorithm.unit3_链表.链表基础;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Justin
 * @date 2022/12/27 2:56 PM
 *
 * 构造链表，使用静态内部类定表示结点，实现增加和删除元素的功能
 */
public class BasicLinkList {

    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
//        new LinkedList<>();
//        Queue
        Node head = new Node(1);
        System.out.println("初始化节点1:"+BasicLinkList.toString(head));

        head = BasicLinkList.add(head, new Node(2), 2);
        System.out.println("尾部添加节点2:"+BasicLinkList.toString(head));

        head = BasicLinkList.add(head, new Node(3), 2);
        System.out.println("中间添加节点3:"+BasicLinkList.toString(head));

        head = BasicLinkList.delete(head, 2);
        System.out.println("删除中间节点3:"+BasicLinkList.toString(head));

        head = BasicLinkList.delete(head, 1);
        System.out.println("删除头部节点1:"+BasicLinkList.toString(head));
    }

    /**
     * 链表插入
     */
    public static Node add(Node head, Node newNode, int position){
        if (head == null){
            return newNode;
        }

        int length = getListLength(head);
        if (position > length + 1 || position < 1){
            throw new RuntimeException("插入位置错误");
        }

        //表头
        if (position == 1){
            newNode.next = head;
            //再将表头指向链首元素
            head = newNode;
            return head;
        }

        //表中
        Node pNode = head;
        int count = 1;
        //current的前一个位置停下
        while (count < position - 1){
            pNode = pNode.next;
            count++;
        }
        //只能先将cur=pNode.next 赋值给 newNode
        newNode.next = pNode.next;
        //再将newNode接入前驱节点的next
        pNode.next = newNode;
        return head;

        //表尾这里位置限制的
//        Node p2Node = head;
//        while (p2Node != null){
//            p2Node = p2Node.next;
//            if (p2Node == null){
//                p2Node.next = newNode;
//            }
//        }

    }

    /**
     * 删除节点
     */
    public static Node delete(Node head, int position){
        if (head == null){
            return null;
        }
        int length = getListLength(head);
        if (position > length + 1 || position < 1){
            throw new RuntimeException("删除位置错误");
        }

        //删除表头
        if (position == 1){
            head = head.next;
            return head;
        }

        Node pNode = head;
        int count =1;
        while (count < position-1){
            pNode = pNode.next;
            count++;
        }
        //要删除的节点
        Node curNode = pNode.next;
        pNode.next = curNode.next;
        return head;
    }


    /**
     * 遍历链表,条件是尾节点为null
     */
    public static int getListLength(Node head){
        int length = 0;
        Node node = head;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    public static String toString(Node head){
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null){
            sb.append(node.data).append("\t");
            node = node.next;
        }
        return sb.toString();
    }
}
