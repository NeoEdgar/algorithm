package org.justin.algorithm.unit6_树.层序遍历;

import org.justin.algorithm.unit6_树.基础.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Justin
 * @date 2023/2/1 5:09 PM
 */
public class BaseLevelOrder {


    public static void main(String[] args) {
        TreeNode a = new TreeNode();
        a.setVal(1);
        a.setLeft(null);
        a.setRight(null);

        TreeNode b = new TreeNode();
        b.setVal(2);
        b.setLeft(null);
        b.setRight(null);

        TreeNode c = new TreeNode();
        c.setVal(3);
        c.setLeft(a);
        c.setRight(b);

        TreeNode d = new TreeNode();
        d.setVal(5);
        d.setLeft(c);
        d.setRight(null);

        List<List<Integer>> lists = levelOrder(d);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println("/");
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        if (root == null) {
            throw new IllegalArgumentException("error");
        }

        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.getVal());

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            results.add(level);
        }

        return results;
    }
}
