package com.nagihome.jn.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTreeImpl {

    public static void main(String[] args) {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10);
        tree.insert(2);
        tree.insert(12);
        tree.insert(1);
        tree.insert(3);
        tree.insert(11);
        tree.insert(13);

        System.out.println(tree.toString());
    }

    private BSTNode root;

    private void insertNode(BSTNode node, Integer data) {

        if (data >= node.getData()) {
            if (node.getRightNode() == null) {
                BSTNode right = new BSTNode();
                right.setData(data);
                node.setRightNode(right);
            } else {
                insertNode(node.getRightNode(), data);
            }

        } else {
            if (node.getLeftNode() == null) {
                BSTNode left = new BSTNode();
                left.setData(data);
                node.setLeftNode(left);
            } else {
                insertNode(node.getLeftNode(), data);
            }
        }

    }

    public void insert(Integer data) {

        if (root == null) {
            BSTNode node = new BSTNode();
            node.setData(data);
            root = node;
        } else {
            insertNode(root, data);
        }
    }


    private class BSTNode {

        private BSTNode leftNode;
        private BSTNode rightNode;
        private Integer data;

        public BSTNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(BSTNode leftNode) {
            this.leftNode = leftNode;
        }

        public BSTNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(BSTNode rightNode) {
            this.rightNode = rightNode;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return this.getData().toString();
        }
    }

    @Override
    public String toString() {
        printTree(root);
        return "";
    }

    private void printTree(BSTNode node) {

        List<BSTNode> rootList = new ArrayList<>();
        rootList.add(node);
        getListNodes(rootList);
        finalNodes.stream()
                .map(l -> l.stream()
                        .map(b -> String.valueOf(b.getData()))
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);

    }

    List<List<BSTNode>> finalNodes = new ArrayList<>();

    private void getListNodes(List<BSTNode> nodes) {

        if(finalNodes.size() ==0){
            finalNodes.add(nodes);
        }

        List<BSTNode> tempNodes = nodes.stream()
                .map(n -> {
                            List<BSTNode> list = new ArrayList<>();
                            if (n.getLeftNode() != null)
                                list.add(n.getLeftNode());
                            if (n.getRightNode() != null)
                                list.add(n.getRightNode());

                            return list.stream();
                        }
                )
                .flatMap(s -> s).collect(Collectors.toList());
        finalNodes.add(tempNodes);

        if(tempNodes.size() > 0) {
            getListNodes(tempNodes);
        }

    }

    private void printNodeValues(List<BSTNode> nodes) {
        nodes.forEach(n -> printNodeValue(n));
    }

    private void printNodeValue(BSTNode node) {
        System.out.print(node.getData());
    }
}
