package com.lfp.zt.algorithm.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Project: zt-javabase
 * Title: 数结构的搜索
 * Description: 提供深度搜索、广度搜索、摆动搜索等
 * Date: 2019-01-01
 * Copyright: Copyright (c) 2019
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    public TreeNode createTree(){
        TreeNode head = new TreeNode("head", 0);
        TreeNode[] nodes = new TreeNode[11];
        for (int i=1;i<11;i++){
            nodes[i] = new TreeNode("node", i);
        }
        head.setLeft(nodes[1]);
        head.setRight(nodes[2]);
        head.getLeft().setLeft(nodes[3]);
        head.getLeft().setRight(nodes[4]);
        head.getRight().setLeft(nodes[5]);
        head.getRight().setRight(nodes[6]);
        head.getLeft().getLeft().setLeft(nodes[7]);
        head.getLeft().getLeft().setRight(nodes[8]);
        head.getLeft().getRight().setLeft(nodes[9]);
        head.getLeft().getRight().setRight(nodes[10]);

        return head;
    }

    // 深度搜索
    public void DFS(TreeNode tree){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            if (node.getRight()!=null) stack.push(node.getRight());
            if (node.getLeft()!=null) stack.push(node.getLeft());
            System.out.println(node);
        }
    }

    // 广度搜索
    public void BFS(TreeNode tree){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.getLeft()!=null) queue.add(node.getLeft());
            if (node.getRight()!=null) queue.add(node.getRight());
            System.out.println(node);
        }
    }

    // 摆动搜索
    public void SFS(TreeNode tree){
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        tree.setReverse(true);
        queue.add(tree);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.getLeft()!=null){
                node.getLeft().setReverse(!node.getReverse());
                queue.add(node.getLeft());
            }
            if (node.getRight()!=null){
                node.getRight().setReverse(!node.getReverse());
                queue.add(node.getRight());
            }
            if (node.getReverse()){
                stack.push(node);
            } else {
                while (!stack.empty()){
                    System.out.println(stack.pop());
                }
                System.out.println(node);
            }
        }
    }


    public static void main(String[] args){
        Client client = new Client();
        TreeNode tree = client.createTree();
        client.DFS(tree);
        System.out.println("=================");
        client.BFS(tree);
        System.out.println("=================");
        client.SFS(tree);
    }

}
