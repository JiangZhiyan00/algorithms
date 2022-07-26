package com.jiangzhiyan.algorithms;

import java.util.Objects;

public class LinkedList<E> implements List<E> {

    // 链表长度
    transient int size = 0;

    // 头节点
    transient Node<E> first;

    // 尾节点
    transient Node<E> end;

    public LinkedList() {
    }

    /**
     * 头插法插入新元素
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(e, null, f);
        first = newNode;
        if (f == null){
            end = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 尾插法插入新元素
     */
    private void linkLast(E e) {
        final Node<E> last = end;
        final Node<E> newNode = new Node<>(e,last,null);
        end = newNode;
        if (last == null){
            first = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    /**
     * 链表节点
     */
    private static class Node<E>{

        // 节点存放的数据
        private E item;

        // 上一个节点
        private Node<E> prev;

        // 下一个节点
        private Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 在链表末尾插入元素
     */
    @Override
    public boolean add(E e) {
        this.linkLast(e);
        return true;
    }

    /**
     * 在链表第一个位置插入元素
     */
    @Override
    public boolean addFirst(E e) {
        this.linkFirst(e);
        return true;
    }

    /**
     * 在链表末尾插入元素
     */
    @Override
    public boolean addLast(E e) {
        this.linkLast(e);
        return true;
    }

    /**
     * 删除一个元素
     */
    @Override
    public boolean remove(Object o) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (Objects.equals(o,x.item)) {
                E unlink = this.unlink(x);
                return true;
            }
        }
        return false;
    }

    /**
     * 删除元素
     */
    private E unlink(Node<E> node) {
        // 待移除节点保存的数据
        final E element = node.item;
        // 待移除节点的下一个节点
        final Node<E> next = node.next;
        // 待移除节点的上一个节点
        final Node<E> prev = node.prev;

        if (prev == null){
            // 头节点移除,first向后一位
            first = next;
        }else {
            // 待移除节点的上一个节点的next指针指向待移除节点的下一个节点
            prev.next = next;
            // 被移除节点的prev指向null
            node.prev = null;
        }
        if (next == null){
            // 尾节点移除,end向前一位
            end = prev;
        }else {
            // 待移除节点的下一个节点的prev指针指向待移除节点的上一个节点
            next.prev = prev;
            // 被移除节点的next指向null
            node.next = null;
        }
        node.item = null;
        size--;
        return element;
    }

    /**
     * 使用索引获取元素
     */
    @Override
    public E get(int index) {
        if (index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.node(index).item;
    }

    /**
     * 根据索引获取节点
     */
    private Node<E> node(int index) {
        Node<E> x;
        //如果小于一半,则正序获取,否则倒序获取
        if (index < ((size) >> 1)){
            x = first;
            for (int i = 0; i < index; i++){
                x = x.next;
            }
        }else {
            x = end;
            for (int i = size - 1; i > index; i--){
                x = x.prev;
            }
        }
        return x;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * 从头节点到尾节点依次打印
     */
    @Override
    public void printLinkList() {
        if (this.size == 0) {
            System.out.println("链表为空");
        } else {
            Node<E> temp = first;
            System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + end.item + " 整体：");
            while (true) {
                E item = temp.item;
                temp = temp.next;
                if (temp == null){
                    System.out.println(item);
                    break;
                }else {
                    System.out.print(item + ",");
                }
            }
        }
    }
}
