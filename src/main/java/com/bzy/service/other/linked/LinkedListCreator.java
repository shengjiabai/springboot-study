package com.bzy.service.other.linked;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LinkedListCreator {
	//构建函数
    public Node createLinkedList(List<Integer> list){
        if (list.isEmpty()){
            return null;
        }
        Node headNode = new Node(list.get(0));
        Node tempNode = createLinkedList(list.subList(1, list.size()));
        headNode.setNode(tempNode);
        return headNode;
    }

	//测试方便的打印函数
    public void printList(Node node){
        while (node != null){
            System.out.print(node.getValue());
            System.out.print(" ");
            node = node.getNode();
        }
        System.out.println();
    }





    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        Node node = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node node2 = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node node3 = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        LinkedListReverser linkedListReverser = new LinkedListReverser();

        Node res = linkedListReverser.reverserLinkedList(node);
        Node res2 = linkedListReverser.reverserLinkedList2(node2);
        Node res3 = linkedListReverser.reverserLinkedList3(node3);

        linkedListCreator.printList(res);
        linkedListCreator.printList(res2);
        linkedListCreator.printList(res3);
    }
}