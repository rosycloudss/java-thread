package com.lw.java.thread.core.chapter3.wait_notify1;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("anything");
    }

    public static int size() {
        return list.size();
    }
}
