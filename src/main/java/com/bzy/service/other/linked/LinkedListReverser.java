package com.bzy.service.other.linked;

import java.util.Stack;

/**
 * 链表反转
 */
public class LinkedListReverser {


    /**
     * 递归现实
     * @param node
     * @return
     */
    public Node reverserLinkedList(Node node){
        if (node.getNode() == null || node == null){
            return node;
        }
        Node newdata = reverserLinkedList(node.getNode());
        node.getNode().setNode(node);
        node.setNode(null);
        return newdata;
    }
    //这个递归，返回值只是为了控制返回的是最后一个节点
    //然后通过递归通过栈的特性，这里就是让它可以从最后一个节点开始把自己的子节点的子节点改成自己
    //自己的子节点改为null


    /**
     * 栈现实
     * @param node
     * @return
     */
    public Node reverserLinkedList2(Node node){
        Stack<Node> nodeStack = new Stack<>();
        Node head = null;
        //存入栈中，模拟递归开始的栈状态
        while (node != null){
            nodeStack.push(node);
            node = node.getNode();
        }
        //特殊处理第一个栈顶元素（也就是反转前的最后一个元素，因为它位于最后，不需要反转，如果它参与下面的while， 因为它的下一个节点为空，如果getNode()， 那么为空指针异常）
        if ((!nodeStack.isEmpty())){
            head = nodeStack.pop();
        }
        //排除以后就可以快乐的循环
        while (!nodeStack.isEmpty()){
            Node tempNode = nodeStack.pop();
            tempNode.getNode().setNode(tempNode);
            tempNode.setNode(null);
        }
        return head;
    }

    /**
     * 遍历实现
     * @param node
     * @return
     */
    public Node reverserLinkedList3(Node node){
        //指向空，可以想象成位于第一个节点之前
        Node newNode = null;
        //指向第一个节点
        Node curNode = node;

        //循环中，使用第三变量事先保存curNode的后面一个节点

        while (curNode != null){
            Node tempNode = curNode.getNode();
            //把curNode反向往前指
            curNode.setNode(newNode);
            //newNode向后移动
            newNode = curNode;
            //curNode 向后移动
            curNode = tempNode;
        }

        return newNode;
    }


   

}
