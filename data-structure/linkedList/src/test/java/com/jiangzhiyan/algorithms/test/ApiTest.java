package com.jiangzhiyan.algorithms.test;

import com.jiangzhiyan.algorithms.LinkedList;
import com.jiangzhiyan.algorithms.List;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testLinkedList(){
        List<String> list = new LinkedList<>();
        System.out.println(list.size());//0
        list.add("aaa");
        list.addLast("bbb");
        list.addFirst("111");
        System.out.println(list.get(1));//aaa
        list.printLinkList();//目前的列表，头节点：111 尾节点：bbb 整体：111,aaa,bbb
        list.remove("111");
        System.out.println(list.size());//2
        list.printLinkList();//目前的列表，头节点：aaa 尾节点：bbb 整体：aaa,bbb
    }
}
