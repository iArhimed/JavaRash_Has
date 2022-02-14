package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        //напишите тут ваш код
        Node node = new Node();
        node.value = value;
        if (first.next == null) {
            first.next = node;
            last.prev = node;
        } else {
            Node lastNode = last.prev;
            last.prev = node;
            node.prev = lastNode;
            lastNode.next = node;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
