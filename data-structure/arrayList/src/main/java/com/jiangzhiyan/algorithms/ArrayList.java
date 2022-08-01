package com.jiangzhiyan.algorithms;

import java.util.Arrays;

public class ArrayList<E> implements List<E>{

    /**
     * 默认初始化空间
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空元素
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * ArrayList 元素数组缓存区
     */
    transient Object[] elementData;

    /**
     * List 集合元素数量
     */
    private int size;

    public ArrayList() {
        // 默认给个空集合,当开始添加元素再初始化size
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean add(E e) {
        int minCapacity = size + 1;
        //只有第一次执行add时,会进入此if,minCapacity赋值10
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        //原容量
        int oldCapacity = elementData.length;
        //如果添加元素后的容量>原容量,则需要扩容
        if (minCapacity - oldCapacity > 0){
            //扩容为原容量的1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            newCapacity = Math.max(newCapacity,minCapacity);
            elementData = Arrays.copyOf(elementData,newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        //删除这个元素需要移动的其他元素个数
        int numMoved = size - 1 - index;
        if (numMoved > 0){
            //将原index后的元素向index进一位
            System.arraycopy(elementData,index + 1,elementData,index,numMoved);
        }
        //末尾元素置空,size-1
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }
}
