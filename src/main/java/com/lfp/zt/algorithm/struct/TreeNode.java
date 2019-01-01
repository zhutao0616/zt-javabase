package com.lfp.zt.algorithm.struct;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-01
 * Copyright: Copyright (c) 2019
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class TreeNode {

    private String name;
    private int value;
    private TreeNode left;
    private TreeNode right;
    private boolean reverse;

    public TreeNode() {
    }

    public TreeNode(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
