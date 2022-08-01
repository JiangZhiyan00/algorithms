package com.jiangzhiyan.algorithms.test;

import com.jiangzhiyan.algorithms.ArrayList;
import com.jiangzhiyan.algorithms.List;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_ArrayListAdd(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
