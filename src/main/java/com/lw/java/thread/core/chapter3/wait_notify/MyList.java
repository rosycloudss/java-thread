package com.lw.java.thread.core.chapter3.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList<>();

    public void add() {
        list.add("李伟");
    }

    public int size() {
        return list.size();
    }
}
