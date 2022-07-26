package com.jiangzhiyan.algorithms.test;

import com.jiangzhiyan.algorithms.LinkedList;
import com.jiangzhiyan.algorithms.List;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testLinkedList(){
        List<String> list = new LinkedList<>();
        System.out.println(list.size());
        list.add("aaa");
        list.addLast("bbb");
        list.addFirst("111");
        System.out.println(list.get(1));
        list.printLinkList();

        list.remove("111");
        System.out.println(list.size());
        list.printLinkList();
    }
}
