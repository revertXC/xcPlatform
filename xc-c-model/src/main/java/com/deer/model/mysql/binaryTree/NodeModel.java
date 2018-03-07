package com.deer.model.mysql.binaryTree;

/**
 * 二叉树Model
 */
public class NodeModel {

    private String value; //值

    private NodeModel leftNode; //左节点

    private NodeModel rightNode; //右节点

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NodeModel getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NodeModel leftNode) {
        this.leftNode = leftNode;
    }

    public NodeModel getRightNode() {
        return rightNode;
    }

    public void setRightNode(NodeModel rightNode) {
        this.rightNode = rightNode;
    }
}
